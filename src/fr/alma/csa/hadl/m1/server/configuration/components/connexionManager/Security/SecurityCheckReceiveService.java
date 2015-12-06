package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.Security;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class SecurityCheckReceiveService extends RequiredService{
	
	public SecurityCheckReceiveService(SecurityCheckReceive port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.port){
			System.out.println("Passage dans SecurityCheckReceiveService, update : " + ((ConnexionPoint) o).getO().toString());
		}
	}
}
