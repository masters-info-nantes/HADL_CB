package fr.alma.csa.hadl.m1.clientserver;

import fr.alma.csa.hadl.m2.Interfaces.service.RequiredService;

public class InServ extends RequiredService{

	public InServ(In port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
	
	public void newRequest(Object o){
		this.port.setO(o);
	}

}
