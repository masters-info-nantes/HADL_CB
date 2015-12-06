package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class SecurityCheckSendService extends ProvidedService{
	
	public SecurityCheckSendService(SecurityCheckSend port) {
		super(port);
		this.port = port;
	}
	
	public void sendSecurityCheck(Object o){
		System.out.println("Passage dans SecurityCheckSendService, sendExternalSocket : " + o.toString());
		this.port.setO(o);
	}
}
