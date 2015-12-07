package fr.alma.csa.hadl.m2.Liens;

import java.util.Observable;
import java.util.Observer;

import fr.alma.csa.hadl.m2.Interfaces.port.Port;
import fr.alma.csa.hadl.m2.Interfaces.role.Role;

public abstract class Attachement implements Observer{

	Port port;
	Role role;
	
	public Attachement(Port port, Role role) {
		this.port = port;
		this.role = role;
	}

	public Port getPort() {
		return port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	

	@Override
	public void update(Observable o, Object arg) {

	}
}
