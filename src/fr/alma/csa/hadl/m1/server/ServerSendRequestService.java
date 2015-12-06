package fr.alma.csa.hadl.m1.server;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class ServerSendRequestService extends ProvidedService{

	ServerSendRequestPort portServer;

	public ServerSendRequestService(ServerSendRequestPort port) {
		super(port);
		this.portServer = port;
	}
	
	public void sendRequest(Object o){
		this.portServer.setO(o);
		System.out.println("Passage dans ServerSendREquestService : " + o.toString());
	}

}
