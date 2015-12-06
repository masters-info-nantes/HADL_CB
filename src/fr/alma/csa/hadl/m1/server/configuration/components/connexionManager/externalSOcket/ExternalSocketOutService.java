package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class ExternalSocketOutService extends ProvidedService{

	public ExternalSocketOutService(ExternalSocketOut port) {
		super(port);
		this.port = port;
	}
	
	public void sendExternalSocket(Object o){
		System.out.println("Passage dans ExternalSocketOutService, sendExternalSocket : " + o.toString());
		this.port.setO(o);
	}
}
