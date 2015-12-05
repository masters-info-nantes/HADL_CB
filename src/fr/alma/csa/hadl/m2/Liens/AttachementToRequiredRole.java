package fr.alma.csa.hadl.m2.Liens;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPort;
import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;

public class AttachementToRequiredRole extends Attachement{
	
	public AttachementToRequiredRole(ProvidedPort port, RequiredRole role) {
		super(port, role);
		this.role.addObserver(this);
	}
}
