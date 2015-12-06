package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.externalSOcket;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class ExternalSocketInService extends RequiredService{
	
	public ExternalSocketInService(ExternalSocketIn port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.port){
			System.out.println("Passage dans ExternalSocketInService, update : " + ((ConnexionPoint) o).getO().toString());
		}
	}
}
