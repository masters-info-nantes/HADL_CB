package fr.alma.csa.hadl.m1.server.configuration.components.security.auth;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class SecurityAuthReceive extends RequiredPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans SecurityAuthReceive, setO : " + o.toString());
		super.setO(o);
	}
}
