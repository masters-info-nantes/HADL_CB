package fr.alma.csa.hadl.m2.component;

import java.util.List;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;

public class SimpleComponent extends Component{
	
	protected List<ProvidedPortComponent> providedPorts;
	protected List<RequiredPortComponent> requiredPorts;
	
	public SimpleComponent(ProvidedPortComponent port){
		providedPorts.add(port);
	}

	public SimpleComponent(ProvidedPortComponent port, RequiredPortComponent reqport){
		providedPorts.add(port);
		requiredPorts.add(reqport);
	}
	
	public void addProvidedPort( ProvidedPortComponent provPort){
		providedPorts.add(provPort);
	}
	
	public void addRequiredPort( RequiredPortComponent reqServ){
		requiredPorts.add(reqServ);
	}

	public List<ProvidedPortComponent> getProvidedPorts() {
		return providedPorts;
	}

	public List<RequiredPortComponent> getRequiredPorts() {
		return requiredPorts;
	}
	
}
