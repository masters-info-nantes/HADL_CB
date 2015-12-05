package fr.alma.csa.hadl.m2.Interfaces.service;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;

public abstract class RequiredService extends Service{
	
	protected RequiredPort port;

	public RequiredService(RequiredPort port) {
		super();
		this.port = port;
	}
	
	public RequiredPort getPort() {
		return port;
	}

	public void setPort(RequiredPort port) {
		this.port = port;
	}
}
