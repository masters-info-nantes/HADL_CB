package fr.alma.csa.hadl.m1.server;

import fr.alma.csa.hadl.m2.component.Component;
import fr.alma.csa.hadl.m2.component.Configuration;

public class Server extends Configuration{
	
	ServerSendRequestService sndServ;
	ServerReceiveRequestService rcvServ;

	public Server(ServerReceiveRequestService rcvSrv, ServerSendRequestService sendSrv, Component comp) {
		super((ServerSendRequestPort)sendSrv.getPort(), (ServerReceiveRequestPort)rcvSrv.getPort(), sendSrv, rcvSrv, comp);
		
		this.sndServ = sendSrv;
		this.rcvServ = rcvSrv;
	}
	
	public void sendRequest(Object o){
		System.out.println("Passage dans Server, sendRequest : " + o.toString());
		sndServ.sendRequest(o);
	}

	public ServerSendRequestService getSndServ() {
		return sndServ;
	}

	public void setSndServ(ServerSendRequestService sndServ) {
		this.sndServ = sndServ;
	}

	public ServerReceiveRequestService getRcvServ() {
		return rcvServ;
	}

	public void setRcvServ(ServerReceiveRequestService rcvServ) {
		this.rcvServ = rcvServ;
	}
}
