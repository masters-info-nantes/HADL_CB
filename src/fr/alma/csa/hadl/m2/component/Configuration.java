package fr.alma.csa.hadl.m2.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;
import fr.alma.csa.hadl.m2.connector.Connector;



public class Configuration extends Component{

	protected List<ProvidedPortConfiguration> providedPorts;
	protected List<RequiredPortConfiguration> requiredPorts;
	
	protected List<Connector> connectors;
	protected List<Component> components;
	
	protected Map<Connector,List<Component>> connexions;
	
	public Configuration( ProvidedPortConfiguration provport, RequiredPortConfiguration reqport, Component comp){
		providedPorts = new ArrayList<ProvidedPortConfiguration>();
		requiredPorts = new ArrayList<RequiredPortConfiguration>();
		connectors = new ArrayList<Connector>();
		components = new ArrayList<Component>();
		connexions = new HashMap<Connector,List<Component>>();
		
		providedPorts.add(provport);
		requiredPorts.add(reqport);
		components.add(comp);
	}
	
	public void addProvidedPort( ProvidedPortConfiguration provPort){
		providedPorts.add(provPort);
	}
	
	public void addRequiredPort( RequiredPortConfiguration reqServ){
		requiredPorts.add(reqServ);
	}
	
	public void addConnector( Connector connect, Component firstComp, Component secondComp){
		connectors.add(connect);
		List<Component> temp = new ArrayList<Component>();
		temp.add(firstComp);
		temp.add(secondComp);
		connexions.put(connect,temp);
	}
	
	public void addComponent( Component comp){
		components.add(comp);
	}

	public List<ProvidedPortConfiguration> getProvidedPorts() {
		return providedPorts;
	}

	public List<RequiredPortConfiguration> getRequiredPorts() {
		return requiredPorts;
	}

	public List<Connector> getConnectors() {
		return connectors;
	}

	public List<Component> getComponents() {
		return components;
	}

	public Map<Connector, List<Component>> getConnexions() {
		return connexions;
	}
	
	
}
