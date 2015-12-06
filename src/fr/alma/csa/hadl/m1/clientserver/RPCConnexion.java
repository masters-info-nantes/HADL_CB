package fr.alma.csa.hadl.m1.clientserver;

import java.util.Observable;

import fr.alma.csa.hadl.m2.connector.Glue;
import fr.alma.csa.hadl.m2.connector.SimpleConnector;

public class RPCConnexion extends SimpleConnector{

	FromClientSendRequestPort fromClient;
	ToServerReceiveRequestPort toClient;
	
	public RPCConnexion(ToServerReceiveRequestPort provrole, FromClientSendRequestPort reqrole) {
		super(new Glue(), provrole, reqrole);
		fromClient = reqrole;
		toClient = provrole;
		fromClient.addObserver(this);
	}

	public void doSomething(Object o){
		System.out.println("Passage dans RPConnexion, doSomething : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.toClient.setO(temp);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == fromClient){
			System.out.println("Passage dans RPConnexion, update : " + ((FromClientSendRequestPort)o).getO().toString());
			doSomething(fromClient.getO());
		}
	}
}
