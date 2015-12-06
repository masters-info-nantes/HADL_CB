package fr.alma.csa.hadl.m1.server.configuration.components.database.query;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class QueryDSend extends ProvidedPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans QueryDSend, setO : " + o.toString());
		super.setO(o);
	}
}
