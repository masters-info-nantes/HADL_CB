package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class SecurityCheckSend extends ProvidedPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans SecurityCheckSend, setO : " + o.toString());
		super.setO(o);
	}
}
