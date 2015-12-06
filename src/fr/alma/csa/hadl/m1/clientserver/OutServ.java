package fr.alma.csa.hadl.m1.clientserver;

import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class OutServ extends ProvidedService{

	public OutServ(Out port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	public void sendRequest(Object o) {
		System.out.println("Passage dans OutServ, sendRequest : " + o.toString());
		this.getPort().setO(o);		
	}

}
