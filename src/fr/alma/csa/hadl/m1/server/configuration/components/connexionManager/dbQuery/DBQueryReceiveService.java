package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class DBQueryReceiveService extends RequiredService{

	public DBQueryReceiveService(RequiredPort port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.port){
			System.out.println("Passage dans DBQueryReceiveService, setO : " + ((ConnexionPoint) o).getO().toString());
		}
	}

}
