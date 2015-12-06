package fr.alma.csa.hadl.m1.client;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.component.SimpleComponent;

public class Client extends SimpleComponent{

	ClientReceiveRequestService rcvReqst;
	ClientSendRequestService sndReqst;
	
	public Client(ClientSendRequestService sendSrv) {
		super((ProvidedPortComponent)sendSrv.getPort(), sendSrv);
		ClientReceiveRequestPort rcvPort = new ClientReceiveRequestPort();
		ClientReceiveRequestService rcvRqst = new ClientReceiveRequestService(rcvPort);
		this.addRequiredService(rcvRqst);
		this.addRequiredPort(rcvPort);
		
		rcvReqst = rcvRqst;
		sndReqst = sendSrv;
	}
	
	public void sendRequest(Object o){
		System.out.println("Passage dans Client, sendRequest : " + o.toString());
		sndReqst.sendRequest(o);
	}

	public ClientReceiveRequestService getRcvReqst() {
		return rcvReqst;
	}

	public void setRcvReqst(ClientReceiveRequestService rcvReqst) {
		this.rcvReqst = rcvReqst;
	}

	public ClientSendRequestService getSndReqst() {
		return sndReqst;
	}

	public void setSndReqst(ClientSendRequestService sndReqst) {
		this.sndReqst = sndReqst;
	}
}
