package fr.alma.csa.hadl.m2.component;

import java.util.List;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;
import fr.alma.csa.hadl.m2.other.Constraint;
import fr.alma.csa.hadl.m2.other.Property;

public abstract class Component {
	
	protected List<ProvidedService> providedServices;
	protected List<RequiredService> requiredServices;
	
	protected List<Property> properties;
	protected List<Constraint> constraints;
	
	//TODO les methodes
}
