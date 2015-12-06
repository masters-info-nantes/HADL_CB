package fr.alma.csa.hadl.m1.server.configuration.connector.clearance;

import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;

public class ToSecurityAuthReceive extends ProvidedRole{
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Passage dans ToSecurityAuthReceive, setO : " + o.toString());
		super.setO(o);
	}
}
