package fr.alma.csa.hadl.m1.clientserver;

import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;

public class FromClientSendRequestPort extends RequiredRole{
	
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Passage dans FromClientSendRequestPort, update : " + o.toString());
		super.setO(o);
	}
}
