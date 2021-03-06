package fr.alma.csa.hadl.m2.connector;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;
import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;
import fr.alma.csa.hadl.m2.other.Constraint;
import fr.alma.csa.hadl.m2.other.Property;
public abstract class Connector implements Observer{
	
	protected List<ProvidedRole> providedRoles;
	protected List<RequiredRole> requiredRoles;
	
	protected List<Constraint> constraints;
	protected List<Property> properties;
	
	public Connector(ProvidedRole provrole, RequiredRole reqrole){
		providedRoles = new ArrayList<ProvidedRole>();
		requiredRoles = new ArrayList<RequiredRole>();
		
		constraints = new ArrayList<Constraint>();
		properties = new ArrayList<Property>();
		
		providedRoles.add(provrole);
		requiredRoles.add(reqrole);	
	}
	
	public void addProvidedRole(ProvidedRole provRole){
		providedRoles.add(provRole);
	}
	
	public void addRequiredRole(RequiredRole reqRole){
		requiredRoles.add(reqRole);
	}
	
	public void addProperty( Property prop){
		properties.add(prop);
	}
	
	public void addConstraint( Constraint constr){
		constraints.add(constr);
	}
	
	public void rmvProvidedRole(ProvidedRole provRole){
		providedRoles.remove(provRole);
	}
	
	public void rmvRequiredRole(RequiredRole reqRole){
		requiredRoles.remove(reqRole);
	}
	
	public void rmvProperty( Property prop){
		properties.remove(prop);
	}
	
	public void rmvConstraint( Constraint constr){
		constraints.remove(constr);
	}

	public List<ProvidedRole> getProvidedRoles() {
		return providedRoles;
	}

	public List<RequiredRole> getRequiredRoles() {
		return requiredRoles;
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}

	public List<Property> getProperties() {
		return properties;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
