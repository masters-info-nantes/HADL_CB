package fr.alma.csa.hadl.m2.connector;

import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;
import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;
import fr.alma.csa.hadl.m2.component.Configuration;

public class ComplexConnector extends Connector{

	protected Configuration configuration;

	public ComplexConnector(Configuration configuration, ProvidedRole provrole, RequiredRole reqrole) {
		super(provrole,reqrole);
		this.configuration = configuration;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}		
}
