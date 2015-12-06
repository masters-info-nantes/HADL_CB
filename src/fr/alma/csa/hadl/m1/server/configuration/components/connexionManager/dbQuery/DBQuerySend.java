package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;

public class DBQuerySend extends ProvidedPortComponent{

	@Override
	public void setO(Object o) {
		System.out.println("Passage dans DBQuerySend, setO : " + o.toString());
		super.setO(o);
	}
}
