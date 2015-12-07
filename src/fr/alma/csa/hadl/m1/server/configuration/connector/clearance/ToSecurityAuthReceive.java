package fr.alma.csa.hadl.m1.server.configuration.connector.clearance;

import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;

public class ToSecurityAuthReceive extends RequiredRole{
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Passage dans ToSecurityAuthReceive, setO : " + o.toString());
		super.setO(o);
	}
}
