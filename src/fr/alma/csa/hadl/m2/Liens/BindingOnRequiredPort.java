package fr.alma.csa.hadl.m2.Liens;

import java.util.Observable;
import java.util.Observer;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPortConfiguration;

public class BindingOnRequiredPort extends Binding implements Observer{

	RequiredPortComponent portComponent;
	RequiredPortConfiguration portConfiguration;
	
	
	public BindingOnRequiredPort(RequiredPortComponent portComponent, RequiredPortConfiguration portConfiguration) {
		super();
		this.portComponent = portComponent;
		this.portConfiguration = portConfiguration;
		this.portConfiguration.addObserver(this);
	}


	public RequiredPortComponent getPortComponent() {
		return portComponent;
	}


	public void setPortComponent(RequiredPortComponent portComponent) {
		this.portComponent = portComponent;
	}


	public RequiredPortConfiguration getPortConfiguration() {
		return portConfiguration;
	}


	public void setPortConfiguration(RequiredPortConfiguration portConfiguration) {
		this.portConfiguration = portConfiguration;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o == this.portConfiguration){
			System.out.println("Passage dans BindingOnRequiredPort, update : " + ((ConnexionPoint)o).getO().toString());
			this.portComponent.setO(((ConnexionPoint)o).getO());
		}
	}

}
