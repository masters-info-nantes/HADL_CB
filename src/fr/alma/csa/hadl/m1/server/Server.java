package fr.alma.csa.hadl.m1.server;

import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.ConnexionManager;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketOut;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketOutService;
import fr.alma.csa.hadl.m1.server.configuration.components.database.Database;
import fr.alma.csa.hadl.m1.server.configuration.components.database.query.QueryDSend;
import fr.alma.csa.hadl.m1.server.configuration.components.database.query.QueryDSendService;
import fr.alma.csa.hadl.m1.server.configuration.components.security.SecurityManager;
import fr.alma.csa.hadl.m1.server.configuration.components.security.auth.SecurityAuthSend;
import fr.alma.csa.hadl.m1.server.configuration.components.security.auth.SecurityAuthSendService;
import fr.alma.csa.hadl.m1.server.configuration.connector.clearance.ClearanceRequest;
import fr.alma.csa.hadl.m1.server.configuration.connector.clearance.FromSecurityAuthSend;
import fr.alma.csa.hadl.m1.server.configuration.connector.clearance.ToSecurityAuthReceive;
import fr.alma.csa.hadl.m1.server.configuration.connector.security.FromCheckQuerySend;
import fr.alma.csa.hadl.m1.server.configuration.connector.security.SecurityQuery;
import fr.alma.csa.hadl.m1.server.configuration.connector.security.ToCheckQueryReceive;
import fr.alma.csa.hadl.m1.server.configuration.connector.sqlQuery.FromDBQuerySend;
import fr.alma.csa.hadl.m1.server.configuration.connector.sqlQuery.SQLQuery;
import fr.alma.csa.hadl.m1.server.configuration.connector.sqlQuery.ToDBQueryReceive;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;
import fr.alma.csa.hadl.m2.component.Component;
import fr.alma.csa.hadl.m2.component.Configuration;

public class Server extends Configuration{
	
	ServerSendRequestService sndServ;
	ServerReceiveRequestService rcvServ;
	
	ConnexionManager connexionM;
	Database database;
	SecurityManager securityManager;
	
	ClearanceRequest clearanceR;
	SecurityQuery securityQuery;
	SQLQuery sqlQuery;
	
	public Server(ServerReceiveRequestService rcvSrv, ServerSendRequestService sendSrv, Component comp) {
		super((ServerSendRequestPort)sendSrv.getPort(), (ServerReceiveRequestPort)rcvSrv.getPort(), sendSrv, rcvSrv, comp);
		
		this.sndServ = sendSrv;
		this.rcvServ = rcvSrv;
		
		ExternalSocketOutService serv = new ExternalSocketOutService(new ExternalSocketOut());
		connexionM = new ConnexionManager(serv);
		this.addComponent(comp);
		
		this.addBinding((ProvidedPortConfiguration)this.sndServ.getPort(), (ProvidedPortComponent)connexionM.getSocketOut().getPort());
		this.addBinding((RequiredPortConfiguration)this.rcvServ.getPort(), (RequiredPortComponent)connexionM.getSocketIn().getPort());
		
		connexionM = new ConnexionManager(new ExternalSocketOutService(new ExternalSocketOut()));
		this.addComponent(connexionM);
		
		database = new Database(new QueryDSendService(new QueryDSend()));
		this.addComponent(database);
		
		securityManager = new SecurityManager(new SecurityAuthSendService(new SecurityAuthSend()));
		this.addComponent(securityManager);
		
		clearanceR = new ClearanceRequest(new ToSecurityAuthReceive(), new FromSecurityAuthSend());
		this.addConnector(clearanceR, clearanceR.getToSecAuth(), clearanceR.getFromSecCheck(), connexionM, connexionM.getSecuritySend().getPort(), securityManager, securityManager.getSecuAuthRcv().getPort());
		
		securityQuery = new SecurityQuery(new ToCheckQueryReceive(), new FromCheckQuerySend());
		this.addConnector(securityQuery, securityQuery.getToCheckQuery(), securityQuery.getFromSecManag(), database, database.getSecurityManSend().getPort(), securityManager, securityManager.getCheckQueryRcv().getPort());
		
		sqlQuery = new SQLQuery(new ToDBQueryReceive(), new FromDBQuerySend());
		this.addConnector(sqlQuery, sqlQuery.getToQueryD(), sqlQuery.getFromDBQuery(), connexionM, connexionM.getDbQuerySend().getPort(), database, database.getQueryDRcv().getPort());	
	
		this.addAttachement(clearanceR, clearanceR.getToSecCheck(), clearanceR.getFromSecAuth(), securityManager, securityManager.getSecuAuthSend().getPort(), connexionM, connexionM.getSecurityRcv().getPort());
		this.addAttachement(securityQuery, securityQuery.getToSecManag(), securityQuery.getFromCheckQuery(), securityManager, securityManager.getCheckQuerySend().getPort(), database, database.getSecurityManRcv().getPort());
		this.addAttachement(sqlQuery, sqlQuery.getToDBQuery(), sqlQuery.getFromQueryD(), database, database.getQueryDSend().getPort(), connexionM, connexionM.getDbQueryRcv().getPort());
	}
	
	public void sendRequest(Object o){
		System.out.println("Passage dans Server, sendRequest : " + o.toString());
		sndServ.sendRequest(o);
	}

	public ServerSendRequestService getSndServ() {
		return sndServ;
	}

	public void setSndServ(ServerSendRequestService sndServ) {
		this.sndServ = sndServ;
	}

	public ServerReceiveRequestService getRcvServ() {
		return rcvServ;
	}

	public void setRcvServ(ServerReceiveRequestService rcvServ) {
		this.rcvServ = rcvServ;
	}
}
