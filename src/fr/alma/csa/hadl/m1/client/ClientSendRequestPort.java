package fr.alma.csa.hadl.m1.client;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class ClientSendRequestPort extends ProvidedPortComponent{
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Passage dans ClientSendRequestPort, setO : " + o.toString());
		super.setO(o);
	}
}
