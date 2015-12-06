package fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class CheckQuerySendService extends ProvidedService{
	public CheckQuerySendService(CheckQuerySend port) {
		super(port);
		this.port = port;
	}
	
	public void sendCheckQuery(Object o){
		System.out.println("Passage dans CheckQuerySendService, sendCheckQuery : " + o.toString());
		this.port.setO(o);
	}
}
