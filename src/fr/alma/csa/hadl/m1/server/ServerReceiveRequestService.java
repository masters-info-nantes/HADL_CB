package fr.alma.csa.hadl.m1.server;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class ServerReceiveRequestService extends RequiredService{

	public ServerReceiveRequestService(ServerReceiveRequestPort port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.getPort()){
			System.out.println("Passage dans ServerReceiveRequestService, update : " + ((ConnexionPoint) o).getO().toString());
		}
	}

}
