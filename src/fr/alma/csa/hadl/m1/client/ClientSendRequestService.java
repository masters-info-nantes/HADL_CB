package fr.alma.csa.hadl.m1.client;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class ClientSendRequestService extends ProvidedService{

	ClientSendRequestPort portClient;

	public ClientSendRequestService(ClientSendRequestPort port) {
		super(port);
		this.portClient = port;
	}
	
	public void sendRequest(Object o){
		System.out.println("Passage dans ClientSendRequestService, sendRequest : " + o.toString());
		this.portClient.setO(o);
	}
}
