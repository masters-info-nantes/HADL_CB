package fr.alma.csa.hadl.m1.server.configuration.components.database.query;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class QueryDReceive extends RequiredPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans QueryDReceive, setO : " + o.toString());
		super.setO(o);
	}
}
