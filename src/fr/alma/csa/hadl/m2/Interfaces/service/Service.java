package fr.alma.csa.hadl.m2.Interfaces.service;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.port.Interface;

public abstract class Service extends Observable implements Interface{
	Object o;

	public Service() {
		this.o = null;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
		setChanged();
		notifyObservers();
	}
}
