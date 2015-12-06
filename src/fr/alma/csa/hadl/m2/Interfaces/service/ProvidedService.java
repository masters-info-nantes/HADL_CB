package fr.alma.csa.hadl.m2.Interfaces.service;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPort;

public abstract class ProvidedService extends Service{

	protected ProvidedPort port;

	public ProvidedService(ProvidedPort port) {
		super();
		this.port = port;
	}

	public ProvidedPort getPort() {
		return port;
	}

	public void setPort(ProvidedPort port) {
		this.port = port;
	}	
}
