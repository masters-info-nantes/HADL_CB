package fr.alma.csa.hadl.m1.server.configuration.components.database.Security;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class SecurityManagementReceive extends RequiredPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans SecurityManagementReceive, setO : " + o.toString());
		super.setO(o);
	}
}
