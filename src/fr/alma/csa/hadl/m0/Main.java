package fr.alma.csa.hadl.m0;

import fr.alma.csa.hadl.m1.client.Client;
import fr.alma.csa.hadl.m1.client.ClientSendRequestPort;
import fr.alma.csa.hadl.m1.client.ClientSendRequestService;
import fr.alma.csa.hadl.m1.clientserver.ClientServer;
import fr.alma.csa.hadl.m1.clientserver.FromClientSendRequestPort;
import fr.alma.csa.hadl.m1.clientserver.In;
import fr.alma.csa.hadl.m1.clientserver.InServ;
import fr.alma.csa.hadl.m1.clientserver.Out;
import fr.alma.csa.hadl.m1.clientserver.OutServ;
import fr.alma.csa.hadl.m1.clientserver.RPCConnexion;
import fr.alma.csa.hadl.m1.clientserver.ToServerReceiveRequestPort;
import fr.alma.csa.hadl.m1.server.Server;
import fr.alma.csa.hadl.m1.server.ServerReceiveRequestPort;
import fr.alma.csa.hadl.m1.server.ServerReceiveRequestService;
import fr.alma.csa.hadl.m1.server.ServerSendRequestPort;
import fr.alma.csa.hadl.m1.server.ServerSendRequestService;

public class Main {

	public static void main(String[] args) {
		
		ClientSendRequestPort sendP = new ClientSendRequestPort();
		ClientSendRequestService serv = new ClientSendRequestService(sendP);
		Client client = new Client(serv);
		
		ServerSendRequestPort servSendP = new ServerSendRequestPort();
		ServerSendRequestService servSendS = new ServerSendRequestService(servSendP);
		ServerReceiveRequestPort servRecP = new ServerReceiveRequestPort();
		ServerReceiveRequestService servRecS = new ServerReceiveRequestService(servRecP);		
		Server server = new Server(servRecS, servSendS, null);
		
		Out outP = new Out();
		OutServ outS = new OutServ(outP);
		In inP = new In();
		InServ inS = new InServ(inP);
		ClientServer cs = new ClientServer(client, server, outS, inS);
		
		ToServerReceiveRequestPort to = new ToServerReceiveRequestPort();
		FromClientSendRequestPort from = new FromClientSendRequestPort();
		RPCConnexion rpc = new RPCConnexion(to, from);
		cs.addConnector(rpc, to, from, client, client.getSndReqst().getPort(), server, server.getRcvServ().getPort());
		
		System.out.println("New request in Client/Server :\n");
		client.sendRequest("bonjour");
		
		
	}

}
