package fr.alma.csa.hadl.m2.Interfaces;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.port.Interface;

public abstract class ConnexionPoint extends Observable implements Interface{
	
	enum ConnexionMode { SYNCHRONE, ASYNCHRONE, CONTINU};
	
	ConnexionMode connexion;

	public ConnexionMode getConnexion() {
		return connexion;
	}

	public void setConnexion(ConnexionMode connexion) {
		this.connexion = connexion;
	}

}
