package fr.alma.csa.hadl.m2.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPort;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;
import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;
import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;
import fr.alma.csa.hadl.m2.Liens.Attachement;
import fr.alma.csa.hadl.m2.Liens.AttachementToRequiredPort;
import fr.alma.csa.hadl.m2.Liens.AttachementToRequiredRole;
import fr.alma.csa.hadl.m2.Liens.Binding;
import fr.alma.csa.hadl.m2.Liens.BindingOnProvidedPort;
import fr.alma.csa.hadl.m2.Liens.BindingOnRequiredPort;
import fr.alma.csa.hadl.m2.connector.Connector;

public class Configuration extends Component{
	
	protected List<Attachement> attachements;
	protected List<Binding> bindings;
	
	protected List<Connector> connectors;
	protected List<Component> components;
	
	protected Map<Connector,Set<Component>> connexions;
	
	public Configuration(ProvidedPortConfiguration provport, RequiredPortConfiguration reqport, ProvidedService provserv, RequiredService reqserv, Component comp){
		super(provserv);
		this.requiredServices.add(reqserv);
		
		connectors = new ArrayList<Connector>();
		components = new ArrayList<Component>();
		connexions = new HashMap<Connector,Set<Component>>();
		bindings = new ArrayList<Binding>();
		attachements = new ArrayList<Attachement>();
		
		providedPort.add(provport);
		requiredPort.add(reqport);
		components.add(comp);
	}

	public List<Binding> getBindings(){
		return bindings;
	}
	
	public void addBinding(ProvidedPortConfiguration portConf, ProvidedPortComponent portComp){
		bindings.add(new BindingOnProvidedPort(portConf, portComp));
	}
	
	public void addBinding(RequiredPortConfiguration portConf, RequiredPortComponent portComp){
		bindings.add(new BindingOnRequiredPort(portComp, portConf));
	}
	
	public void removeBinding(Binding binding){
		this.bindings.remove(binding);
	}
	
	public void addProvidedPort( ProvidedPortConfiguration provPort){
		providedPort.add(provPort);
	}
	
	public void addRequiredPort( RequiredPortConfiguration reqServ){
		requiredPort.add(reqServ);
	}
	
	public void addConnector( Connector connect, ProvidedRole provRole, RequiredRole reqRole, Component firstComp, ProvidedPort firstprov, Component secondComp, RequiredPort secondRequ){
		attachements.add(new AttachementToRequiredPort(secondRequ, provRole));
		attachements.add(new AttachementToRequiredRole(firstprov, reqRole));
		connectors.add(connect);
		Set<Component> temp = new HashSet<Component>();
		temp.add(firstComp);
		temp.add(secondComp);
		connexions.put(connect,temp);
	}
	
	public void addAttachement(Connector conn, ProvidedRole provRole, RequiredRole reqRole, Component firstComp , ProvidedPort firstProv, Component secondComp, RequiredPort secondReq){
		attachements.add(new AttachementToRequiredPort(secondReq, provRole));
		attachements.add(new AttachementToRequiredRole(firstProv, reqRole));
		
		if(this.connexions.containsKey(conn)){
			this.connexions.get(conn).add(firstComp);
			this.connexions.get(conn).add(secondComp);
		}
		else{
			connectors.add(conn);
			Set<Component> temp = new HashSet<Component>();
			temp.add(firstComp);
			temp.add(secondComp);
			this.connexions.put(conn, temp);
		}
	}
	
	public void rmvConnector( Connector connect){
		if(connexions.containsKey(connect)){
			for(Attachement a : attachements){
				if(a.getRole() == connect.getProvidedRoles() || a.getRole() == connect.getRequiredRoles()){
					attachements.remove(a);
				}
			}
			connexions.remove(connect);
			connectors.remove(connect);
		}
	}
	
	public void addComponent( Component comp){
		components.add(comp);
	}
	
	public void rmvComponent( Component comp){
		for(Map.Entry<Connector,Set<Component>> m : connexions.entrySet()){
			if(m.getValue().contains(comp)){
				for(Attachement a : attachements){
					if(comp.getRequiredPorts().contains(a.getPort()) || comp.getProvidedPorts().contains(a.getPort())){
						attachements.remove(a);
					}
				}
				connexions.remove(m);
				connectors.remove(m);
			}
		}
	}

	public List<Connector> getConnectors() {
		return connectors;
	}

	public List<Component> getComponents() {
		return components;
	}

	public Map<Connector, Set<Component>> getConnexions() {
		return connexions;
	}
	
	public List<Attachement> getAttachements() {
		return attachements;
	}
	
	public void rmvAttachement(Attachement attachement) {
		this.attachements.remove(attachement);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
