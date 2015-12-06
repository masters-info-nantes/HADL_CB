package fr.alma.csa.hadl.m1.clientserver;

import fr.alma.csa.hadl.m1.client.Client;
import fr.alma.csa.hadl.m1.server.Server;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;
import fr.alma.csa.hadl.m2.component.Configuration;

public class ClientServer extends Configuration{

	Client client;
	Server server;
	OutServ outS;
	InServ inS;
	
	public ClientServer(Client client, Server server, OutServ provserv, InServ reqserv) {
		super((Out)provserv.getPort(), (In)reqserv.getPort(), provserv, reqserv, client);
		this.addBinding((RequiredPortConfiguration) reqserv.getPort(), (RequiredPortComponent)client.getRcvReqst().getPort());
		this.addBinding((ProvidedPortConfiguration)provserv.getPort(), (ProvidedPortComponent)client.getSndReqst().getPort());
		this.addComponent(server);
		this.client = client;
		this.server = server;
		this.outS = provserv;
		this.inS = reqserv;
	}
	
	public void newRequest(Object o){
		System.out.println("Passage dans ClientServer, newRequest : " + o.toString());
		this.inS.newRequest(o);
	}
	
	public void sendRequest(Object o){
		System.out.println("Passage dans ClientServer, send : " + o.toString());
		this.outS.sendRequest(o);
	}
}
