package fr.alma.csa.hadl.m2.component;

import java.util.ArrayList;
import java.util.List;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPort;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;
import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;
import fr.alma.csa.hadl.m2.other.Constraint;
import fr.alma.csa.hadl.m2.other.Property;

public abstract class Component {
	
	protected List<ProvidedService> providedServices;
	protected List<RequiredService> requiredServices;
	
	protected List<ProvidedPort> providedPort;
	protected List<RequiredPort> requiredPort;
	
	protected List<Property> properties;
	protected List<Constraint> constraints;
	
	public Component(ProvidedService service) {
		providedServices = new ArrayList<ProvidedService>();
		providedServices.add(service);
		
		requiredServices = new ArrayList<RequiredService>();
		properties = new ArrayList<Property>();
		constraints = new ArrayList<Constraint>();
		
		providedPort = new ArrayList<ProvidedPort>();
		requiredPort = new ArrayList<RequiredPort>();
	}
	
	public void addProvidedService( ProvidedService provServ){
		providedServices.add(provServ);
	}
	
	public void addRequiredService( RequiredService reqServ){
		requiredServices.add(reqServ);
	}
	
	public void addProperty( Property prop){
		properties.add(prop);
	}
	
	public void addConstraint( Constraint constr){
		constraints.add(constr);
	}
	
	public void rmvProvidedService( ProvidedService provServ){
		providedServices.remove(provServ);
	}
	
	public void rmvRequiredService( RequiredService reqServ){
		requiredServices.remove(reqServ);
	}
	
	public void rmvProperty( Property prop){
		properties.remove(prop);
	}
	
	public void rmvConstraint( Constraint constr){
		constraints.remove(constr);
	}
	

	public List<ProvidedService> getProvidedServices() {
		return providedServices;
	}

	public List<RequiredService> getRequiredServices() {
		return requiredServices;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}
	
	public List<ProvidedPort> getProvidedPorts() {
		return providedPort;
	}

	public List<RequiredPort> getRequiredPorts() {
		return requiredPort;
	}
}
