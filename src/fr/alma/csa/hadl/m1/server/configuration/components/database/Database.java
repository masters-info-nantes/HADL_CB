package fr.alma.csa.hadl.m1.server.configuration.components.database;

import java.util.Observable;

import fr.alma.csa.hadl.m1.server.configuration.components.database.Security.SecurityManagementReceive;
import fr.alma.csa.hadl.m1.server.configuration.components.database.Security.SecurityManagementReceiveService;
import fr.alma.csa.hadl.m1.server.configuration.components.database.Security.SecurityManagementSend;
import fr.alma.csa.hadl.m1.server.configuration.components.database.Security.SecurityManagementSendService;
import fr.alma.csa.hadl.m1.server.configuration.components.database.query.QueryDReceive;
import fr.alma.csa.hadl.m1.server.configuration.components.database.query.QueryDReceiveService;
import fr.alma.csa.hadl.m1.server.configuration.components.database.query.QueryDSend;
import fr.alma.csa.hadl.m1.server.configuration.components.database.query.QueryDSendService;
import fr.alma.csa.hadl.m2.Interfaces.service.Service;
import fr.alma.csa.hadl.m2.component.SimpleComponent;

public class Database extends SimpleComponent{

	QueryDReceiveService queryDRcv;
	QueryDSendService queryDSend;
	
	SecurityManagementReceiveService securityManRcv;
	SecurityManagementSendService securityManSend;
	
	
	public Database(QueryDSendService service) {
		super((QueryDSend)service.getPort(), service);
		
		QueryDReceive queryDSR = new QueryDReceive();
		this.queryDRcv = new QueryDReceiveService(queryDSR);
		this.addRequiredPort(queryDSR);
		this.addRequiredService(queryDRcv);
		this.queryDRcv.addObserver(this);
		
		QueryDSend queryDS = new QueryDSend();
		this.queryDSend = new QueryDSendService(queryDS);
		this.addProvidedPort(queryDS);
		this.addProvidedService(queryDSend);
		
		SecurityManagementReceive secuMRcv = new SecurityManagementReceive();
		this.securityManRcv = new SecurityManagementReceiveService(secuMRcv);
		this.addRequiredPort(secuMRcv);
		this.addRequiredService(securityManRcv);
		this.securityManRcv.addObserver(this);
		
		SecurityManagementSend smS = new SecurityManagementSend();
		this.securityManSend = new SecurityManagementSendService(smS);
		this.addProvidedPort(smS);
		this.addProvidedService(securityManSend);
	}


	public QueryDReceiveService getQueryDRcv() {
		return queryDRcv;
	}


	public void setQueryDRcv(QueryDReceiveService queryDRcv) {
		this.queryDRcv = queryDRcv;
	}


	public QueryDSendService getQueryDSend() {
		return queryDSend;
	}


	public void setQueryDSend(QueryDSendService queryDSend) {
		this.queryDSend = queryDSend;
	}


	public SecurityManagementReceiveService getSecurityManRcv() {
		return securityManRcv;
	}


	public void setSecurityManRcv(SecurityManagementReceiveService securityManRcv) {
		this.securityManRcv = securityManRcv;
	}


	public SecurityManagementSendService getSecurityManSend() {
		return securityManSend;
	}


	public void setSecurityManSend(SecurityManagementSendService securityManSend) {
		this.securityManSend = securityManSend;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == queryDRcv){
			System.out.println("Passage dans Database, update : " + ((Service)o).getO().toString());;

		}
		else if(o == securityManRcv){
			System.out.println("Passage dans Database, update : " + ((Service)o).getO().toString());;

		}
	}
}
