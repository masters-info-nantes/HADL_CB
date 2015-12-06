package fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class CheckQueryReceive extends RequiredPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans CheckQueryReceive, setO : " + o.toString());
		super.setO(o);
	}
}
