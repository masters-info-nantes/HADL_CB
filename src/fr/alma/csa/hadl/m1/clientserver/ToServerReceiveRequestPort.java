package fr.alma.csa.hadl.m1.clientserver;

import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;

public class ToServerReceiveRequestPort extends ProvidedRole{
	
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Passage dans ToServerReceiveRequestPort, setO : " + o.toString());
		super.setO(o);
	}
}
