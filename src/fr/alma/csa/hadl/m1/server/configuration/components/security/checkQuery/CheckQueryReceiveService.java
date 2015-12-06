package fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class CheckQueryReceiveService extends RequiredService{

	public CheckQueryReceiveService(CheckQueryReceive port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.port){
			System.out.println("Passage dans CheckQueryReceiveService, update : " + ((ConnexionPoint) o).getO().toString());
		}
	}
}
