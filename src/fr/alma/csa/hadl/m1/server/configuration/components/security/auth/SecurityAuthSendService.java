package fr.alma.csa.hadl.m1.server.configuration.components.security.auth;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class SecurityAuthSendService extends ProvidedService{
	public SecurityAuthSendService(SecurityAuthSend port) {
		super(port);
		this.port = port;
	}
	
	public void sendSecurityAuth(Object o){
		System.out.println("Passage dans SecurityManagementSendService, SecurityAuthSendService : " + o.toString());
		this.port.setO(o);
	}
}
