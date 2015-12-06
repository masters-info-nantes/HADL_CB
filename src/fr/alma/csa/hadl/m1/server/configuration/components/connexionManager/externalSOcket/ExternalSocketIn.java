package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class ExternalSocketIn extends RequiredPortComponent{
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans ExternalSocketIn, setO : " + o.toString());
		super.setO(o);
	}
}
