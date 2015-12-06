package fr.alma.csa.hadl.m1.server;

import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.ConnexionManager;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketOut;
import fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket.ExternalSocketOutService;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;
import fr.alma.csa.hadl.m2.component.Component;
import fr.alma.csa.hadl.m2.component.Configuration;

public class Server extends Configuration{
	
	ServerSendRequestService sndServ;
	ServerReceiveRequestService rcvServ;
	ConnexionManager connexionM;

	public Server(ServerReceiveRequestService rcvSrv, ServerSendRequestService sendSrv, Component comp) {
		super((ServerSendRequestPort)sendSrv.getPort(), (ServerReceiveRequestPort)rcvSrv.getPort(), sendSrv, rcvSrv, comp);
		
		this.sndServ = sendSrv;
		this.rcvServ = rcvSrv;
		
		ExternalSocketOutService serv = new ExternalSocketOutService(new ExternalSocketOut());
		connexionM = new ConnexionManager(serv);
		this.addComponent(comp);
		
		this.addBinding((ProvidedPortConfiguration)this.sndServ.getPort(), (ProvidedPortComponent)connexionM.getSocketOut().getPort());
		this.addBinding((RequiredPortConfiguration)this.rcvServ.getPort(), (RequiredPortComponent)connexionM.getSocketIn().getPort());
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
