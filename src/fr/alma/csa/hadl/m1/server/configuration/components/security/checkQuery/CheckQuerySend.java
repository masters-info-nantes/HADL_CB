package fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class CheckQuerySend extends ProvidedPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans CheckQuerySend, setO : " + o.toString());
		super.setO(o);
	}
}
