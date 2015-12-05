package fr.alma.csa.hadl.m2.Liens;

import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;
import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;

public class AttachementToRequiredPort extends Attachement{

	public AttachementToRequiredPort(RequiredPort port, ProvidedRole role) {
		super(port, role);
		this.port.addObserver(this);
	}
}
