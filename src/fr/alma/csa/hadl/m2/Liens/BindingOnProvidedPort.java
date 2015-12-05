package fr.alma.csa.hadl.m2.Liens;

import java.util.Observable;
import java.util.Observer;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortConfiguration;

public class BindingOnProvidedPort extends Binding implements Observer{
	
	ProvidedPortConfiguration portConfiguration;
	ProvidedPortComponent portComponent;
	
	public BindingOnProvidedPort(ProvidedPortConfiguration portConfiguration, ProvidedPortComponent portComponent) {
		super();
		this.portConfiguration = portConfiguration;
		this.portComponent = portComponent;
	}

	public ProvidedPortConfiguration getPortConfiguration() {
		return portConfiguration;
	}

	public void setPortConfiguration(ProvidedPortConfiguration portConfiguration) {
		this.portConfiguration = portConfiguration;
	}

	public ProvidedPortComponent getPortComponent() {
		return portComponent;
	}

	public void setPortComponent(ProvidedPortComponent portComponent) {
		this.portComponent = portComponent;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}