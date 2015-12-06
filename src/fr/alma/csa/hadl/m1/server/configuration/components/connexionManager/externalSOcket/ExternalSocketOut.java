package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class ExternalSocketOut extends ProvidedPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans ExternalSocketOut, setO : " + o.toString());
		super.setO(o);
	}
}
