package fr.alma.csa.hadl.m2.connector;

import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;
import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;


public class SimpleConnector extends Connector{
	
	protected Glue glue;

	public SimpleConnector(Glue glue,ProvidedRole provrole, RequiredRole reqrole) {
		super(provrole, reqrole);
		this.glue = glue;
	}

}
