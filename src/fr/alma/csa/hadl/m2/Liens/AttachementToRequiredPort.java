package fr.alma.csa.hadl.m2.Liens;

import java.util.Observable;

import fr.alma.csa.hadl.m2.Interfaces.ConnexionPoint;
import fr.alma.csa.hadl.m2.Interfaces.port.RequiredPort;
import fr.alma.csa.hadl.m2.Interfaces.role.ProvidedRole;

public class AttachementToRequiredPort extends Attachement{

	public AttachementToRequiredPort(RequiredPort port, ProvidedRole role) {
		super(port, role);
		this.role.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == this.getRole()){
			System.out.println("Passage dans AttachementToRequiredPort, update : " + ((ConnexionPoint)o).getO().toString());
			this.getPort().setO(((ConnexionPoint)o).getO());
		}
	}
}
