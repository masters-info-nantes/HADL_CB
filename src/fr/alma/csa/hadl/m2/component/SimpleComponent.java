package fr.alma.csa.hadl.m2.component;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class SimpleComponent extends Component{
	
	public SimpleComponent(ProvidedPortComponent port, ProvidedService service){
		super(service);
		providedPort.add(port);
	}

	public SimpleComponent(ProvidedPortComponent port, ProvidedService provserv, RequiredPortComponent reqport, RequiredService reqserv){
		super(provserv);
		providedPort.add(port);
		requiredPort.add(reqport);
	}
	
	public void addProvidedPort( ProvidedPortComponent provPort){
		providedPort.add(provPort);
	}
	
	public void addRequiredPort( RequiredPortComponent reqServ){
		requiredPort.add(reqServ);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	
}
