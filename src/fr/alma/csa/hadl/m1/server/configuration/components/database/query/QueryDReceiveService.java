package fr.alma.csa.hadl.m1.server.configuration.components.database.query;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class QueryDReceiveService extends RequiredService{

	public QueryDReceiveService(QueryDReceive port) {
		super(port);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.port){
			System.out.println("Passage dans QueryDReceiveService, update : " + ((ConnexionPoint) o).getO().toString());
			this.setO(((ConnexionPoint) o).getO());
		}
	}
	
	@Override
	public void setO(Object o) {
		System.out.println("Passage dans QueryDReceiveService, setO : " + o.toString());
		super.setO(o);
	}
}
