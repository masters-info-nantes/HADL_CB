package fr.alma.csa.hadl.m2.Liens;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPort;
import fr.alma.csa.hadl.m2.Interfaces.role.RequiredRole;

public class AttachementToRequiredRole extends Attachement{
	
	public AttachementToRequiredRole(ProvidedPort port, RequiredRole role) {
		super(port, role);
		this.port.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.getPort()){
			System.out.println("Passage dans AttachementToRequiredRole, update : " + ((ConnexionPoint)o).getO().toString());
			this.getRole().setO(((ConnexionPoint)o).getO());
		}
	}
}
