package fr.alma.csa.hadl.m1.server.configuration.components.security.auth;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class SecurityAuthReceiveService extends RequiredService{

	public SecurityAuthReceiveService(SecurityAuthReceive port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.port){
			System.out.println("Passage dans SecurityAuthReceiveService, update : " + ((ConnexionPoint) o).getO().toString());
		}
	}
}
