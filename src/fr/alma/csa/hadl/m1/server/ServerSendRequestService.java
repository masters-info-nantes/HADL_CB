package fr.alma.csa.hadl.m1.server;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class ServerSendRequestService extends ProvidedService{

	public ServerSendRequestService(ServerSendRequestPort port) {
		super(port);
	}
	
	public void sendRequest(Object o){
		System.out.println("Passage dans ServerSendREquestService : " + o.toString());
		this.port.setO(o);
	}

}
