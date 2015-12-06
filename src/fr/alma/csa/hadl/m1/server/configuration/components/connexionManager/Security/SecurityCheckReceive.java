package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class SecurityCheckReceive extends RequiredPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans SecurityCheckReceive, setO : " + o.toString());
		super.setO(o);
	}
}
