package fr.alma.csa.hadl.m1.server.configuration.components.database.Security;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class SecurityManagementSend extends ProvidedPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans SecurityManagementSend, setO : " + o.toString());
		super.setO(o);
	}
}
