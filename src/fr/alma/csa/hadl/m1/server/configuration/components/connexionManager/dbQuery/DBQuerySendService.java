package fr.alma.csa.hadl.m1.server.configuration.components.connexionManager.dbQuery;

import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPort;
import fr.alma.csa.hadl.m2.Interfaces.service.ProvidedService;

public class DBQuerySendService extends ProvidedService{

	public DBQuerySendService(DBQuerySend port) {
		super(port);
	}
	
	public void sendQuery(Object o){
		super.getPort().setO(o);
	}
	
	@Override
	public ProvidedPort getPort() {
		return super.getPort();
	}
}
