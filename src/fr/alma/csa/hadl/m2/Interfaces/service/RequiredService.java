package fr.alma.csa.hadl.m2.Interfaces.service;

import java.util.Observable;
import java.util.Observer;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;

public abstract class RequiredService extends Service implements Observer{
	
	protected RequiredPort port;

	public RequiredService(RequiredPort port) {
		super();
		this.port = port;
		this.port.addObserver(this);
	}
	
	public RequiredPort getPort() {
		return port;
	}

	public void setPort(RequiredPort port) {
		this.port = port;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
