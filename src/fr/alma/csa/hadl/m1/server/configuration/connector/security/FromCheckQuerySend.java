package fr.alma.csa.hadl.m1.server.configuration.connector.security;

import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;

public class FromCheckQuerySend extends RequiredRole{
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Passage dans FromCheckQuerySend, setO : " + o.toString());
		super.setO(o);
	}
}
