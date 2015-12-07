package fr.alma.csa.hadl.m1.server.configuration.components.database.Security;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class SecurityManagementSendService extends ProvidedService{
	public SecurityManagementSendService(SecurityManagementSend port) {
		super(port);
	}
	
	public void sendSecurityManagement(Object o){
		System.out.println("Passage dans SecurityManagementSendService, sendSecurityManagement : " + o.toString());
		this.port.setO(o);
	}
}
