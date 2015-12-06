package fr.alma.csa.hadl.m1.client;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class ClientReceiveRequestService extends RequiredService{

	public ClientReceiveRequestService(RequiredPort port) {
		super(port);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o == this.getPort()){
			System.out.println("Passage dans ClientReceiveRequestService : " + ((ConnexionPoint) o).getO().toString());
		}
	}
}
