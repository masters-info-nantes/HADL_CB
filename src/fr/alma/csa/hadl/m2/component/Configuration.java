package fr.alma.csa.hadl.m2.component;

import java.util.List;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;
import fr.alma.csa.hadl.m2.connector.Connector;



public class Configuration extends Component{

	protected List<ProvidedPortConfiguration> providedPorts;
	protected List<RequiredPortConfiguration> requiredPorts;
	
	protected List<Connector> connectors;
	protected List<Component> components;
	
	public Configuration( ProvidedPortConfiguration provport, RequiredPortConfiguration reqport, Component comp){
		providedPorts.add(provport);
		requiredPorts.add(reqport);
		components.add(comp);
	}
}
