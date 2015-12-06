package fr.alma.csa.hadl.m1.client;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class ClientReceiveRequestPort extends RequiredPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans ClientReceiveRequestPort, setO : " + o.toString());
		super.setO(o);
	}
}
