package fr.alma.csa.hadl.m1.clientserver;

import fr.alma.csa.hadl.m1.client.Client;
import fr.alma.csa.hadl.m1.server.Server;
import fr.alma.csa.hadl.m2.component.Configuration;

public class ClientServer extends Configuration{

	Client client;
	Server server;
	
	public ClientServer(Client client, Server server, OutServ provserv, InServ reqserv) {
		super((Out)provserv.getPort(), (In)reqserv.getPort(), provserv, reqserv, client);
		this.addComponent(server);
		this.client = client;
		this.server = server;
	}
}
