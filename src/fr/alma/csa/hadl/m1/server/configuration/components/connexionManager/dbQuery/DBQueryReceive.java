package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

public class DBQueryReceive extends RequiredPortComponent{
	
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans DBQueryReceive, setO : " + o.toString());
		super.setO(o);
	}

}
