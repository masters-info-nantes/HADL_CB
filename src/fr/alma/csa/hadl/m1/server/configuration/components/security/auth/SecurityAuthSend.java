package fr.alma.csa.hadl.m1.server.configuration.components.security.auth;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class SecurityAuthSend extends ProvidedPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans SecurityAuthSend, setO : " + o.toString());
		super.setO(o);
	}
}
