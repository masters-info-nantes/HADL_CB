package fr.alma.csa.hadl.m1.server.configuration.components.database.Security;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class SecurityManagementReceiveService extends RequiredService{

	public SecurityManagementReceiveService(SecurityManagementReceive port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.port){
			System.out.println("Passage dans SecurityManagementReceiveService, update : " + ((ConnexionPoint) o).getO().toString());
		}
	}
}
