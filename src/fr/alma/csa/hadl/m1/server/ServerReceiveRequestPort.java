package fr.alma.csa.hadl.m1.server;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;

public class ServerReceiveRequestPort extends RequiredPortConfiguration{

	@Override
	public void setO(Object o) {
		System.out.println("Passage dans ServerReceiveRequestPort, setO : " + o.toString());
		super.setO(o);
	}
}
