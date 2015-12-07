package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager;

import java.util.Observable;

import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security.SecurityCheckReceive;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security.SecurityCheckReceiveService;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security.SecurityCheckSend;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security.SecurityCheckSendService;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery.DBQueryReceive;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery.DBQueryReceiveService;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery.DBQuerySend;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery.DBQuerySendService;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketIn;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketInService;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketOut;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketOutService;
import fr.alma.csa.hadl.m2.Interfaces.service.Service;
import fr.alma.csa.hadl.m2.component.SimpleComponent;

public class ConnexionManager extends SimpleComponent{
	
	ExternalSocketOutService socketOut;
	ExternalSocketInService socketIn;
	
	DBQueryReceiveService dbQueryRcv;
	DBQuerySendService dbQuerySend;
	
	SecurityCheckReceiveService securityRcv;
	SecurityCheckSendService securitySend;

	public ConnexionManager(ExternalSocketOutService service) {
		super((ExternalSocketOut)service.getPort(), service);
		
		this.socketOut = service;
		
		ExternalSocketIn portIn = new ExternalSocketIn();
		this.socketIn = new ExternalSocketInService(portIn);
		this.addRequiredPort(portIn);
		this.addRequiredService(this.socketIn);
		this.socketIn.addObserver(this);

		DBQueryReceive dbQueryRcvP = new DBQueryReceive();
		this.dbQueryRcv = new DBQueryReceiveService(dbQueryRcvP);
		this.addRequiredPort(dbQueryRcvP);
		this.addRequiredService(dbQueryRcv);
		
		DBQuerySend dbSendP = new DBQuerySend();
		this.dbQuerySend = new DBQuerySendService(dbSendP);
		this.dbQuerySend.setPort(dbSendP);
		this.addProvidedService(dbQuerySend);
		this.addProvidedPort(dbSendP);
		
		SecurityCheckReceive scrP = new SecurityCheckReceive();
		this.securityRcv = new SecurityCheckReceiveService(scrP);
		this.addRequiredPort(scrP);
		this.addRequiredService(securityRcv);
		
		SecurityCheckSend scsP = new SecurityCheckSend(); 
		this.securitySend = new SecurityCheckSendService(scsP);
		this.addProvidedPort(scsP);
		this.addProvidedService(securitySend);
		
		System.out.println("lo   "+dbQuerySend.getPort());

	}

	public ExternalSocketOutService getSocketOut() {
		return socketOut;
	}

	public void setSocketOut(ExternalSocketOutService socketOut) {
		this.socketOut = socketOut;
	}

	public ExternalSocketInService getSocketIn() {
		return socketIn;
	}

	public void setSocketIn(ExternalSocketInService socketIn) {
		this.socketIn = socketIn;
	}

	public DBQueryReceiveService getDbQueryRcv() {
		return dbQueryRcv;
	}

	public void setDbQueryRcv(DBQueryReceiveService dbQueryRcv) {
		this.dbQueryRcv = dbQueryRcv;
	}

	public DBQuerySendService getDbQuerySend() {
		return dbQuerySend;
	}

	public void setDbQuerySend(DBQuerySendService dbQuerySend) {
		this.dbQuerySend = dbQuerySend;
	}

	public SecurityCheckReceiveService getSecurityRcv() {
		return securityRcv;
	}

	public void setSecurityRcv(SecurityCheckReceiveService securityRcv) {
		this.securityRcv = securityRcv;
	}

	public SecurityCheckSendService getSecuritySend() {
		return securitySend;
	}

	public void setSecuritySend(SecurityCheckSendService securitySend) {
		this.securitySend = securitySend;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == socketIn){
			System.out.println("Passage dans ConnexionManager, update : " + ((Service)o).getO().toString());
			goToDatabase(((Service)o).getO());
		}
	}
	
	public void goToDatabase(Object o){
		System.out.println("Passage dans ConnexionManager, goToDatabase : " + o.toString());
		this.dbQuerySend.sendQuery(o);
	}

}
