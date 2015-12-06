package fr.alma.csa.hadl.m1.server;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;

public class ServerSendRequestPort extends ProvidedPortConfiguration{
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		super.setO(o);
		System.out.println("Passage dans ServerSendRequestPort, setO : " + o.toString());
	}
}
