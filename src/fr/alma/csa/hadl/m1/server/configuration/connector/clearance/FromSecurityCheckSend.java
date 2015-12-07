package fr.alma.csa.hadl.m1.server.configuration.connector.clearance;

import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;

public class FromSecurityCheckSend extends ProvidedRole{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans FromSecurityCheckSend, setO : " + o.toString());
		super.setO(o);
	}
}
