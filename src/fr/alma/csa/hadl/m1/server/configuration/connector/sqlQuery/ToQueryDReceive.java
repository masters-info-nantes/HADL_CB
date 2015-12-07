package fr.alma.csa.hadl.m1.server.configuration.connector.sqlQuery;

import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;

public class ToQueryDReceive extends RequiredRole{
	@Override
	public void setO(Object o) {
		// TODO Auto-generated method stub
		System.out.println("Passage dans ToQueryDReceive, setO : " + o.toString());
		super.setO(o);
	}
}
