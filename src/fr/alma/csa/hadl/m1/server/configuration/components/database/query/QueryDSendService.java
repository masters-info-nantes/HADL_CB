package fr.alma.csa.hadl.m1.server.configuration.components.database.query;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class QueryDSendService extends ProvidedService{
	public QueryDSendService(QueryDSend port) {
		super(port);
		this.port = port;
	}
	
	public void sendQyeryD(Object o){
		System.out.println("Passage dans QueryDSendService, sendQyeryD : " + o.toString());
		this.port.setO(o);
	}
}
