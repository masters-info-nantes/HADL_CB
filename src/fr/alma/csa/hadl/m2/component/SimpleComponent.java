package fr.alma.csa.hadl.m2.component;

import java.util.List;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;

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
}
