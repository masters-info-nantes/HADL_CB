package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class DBQuerySendService extends ProvidedService{

	public DBQuerySendService(DBQuerySend port) {
		super(port);
		this.port = port;
	}
	
	public void sendQuery(Object o){
		System.out.println("Passage dans DBQuerySendService, sendQUery : " + o.toString());
		this.port.setO(o);
	}

}
