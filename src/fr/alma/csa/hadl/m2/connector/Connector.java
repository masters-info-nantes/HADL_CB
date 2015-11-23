package fr.alma.csa.hadl.m2.connector;

import java.util.List;

import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;
import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;
import fr.alma.csa.hadl.m2.other.Constraint;
import fr.alma.csa.hadl.m2.other.Property;
public abstract class Connector {
	
	protected List<ProvidedRole> providedRoles;
	protected List<RequiredRole> requiredRoles;
	
	protected List<Constraint> constraints;
	protected List<Property> properties;
	
	public Connector(ProvidedRole provrole, RequiredRole reqrole){
		providedRoles.add(provrole);
		requiredRoles.add(reqrole);	
	}
	
	
}
