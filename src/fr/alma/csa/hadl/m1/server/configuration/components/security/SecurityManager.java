package fr.alma.csa.hadl.m1.server.configuration.components.security;

import java.util.Observable;

import fr.alma.csa.hadl.m1.server.configuration.components.security.auth.SecurityAuthReceive;
import fr.alma.csa.hadl.m1.server.configuration.components.security.auth.SecurityAuthReceiveService;
import fr.alma.csa.hadl.m1.server.configuration.components.security.auth.SecurityAuthSend;
import fr.alma.csa.hadl.m1.server.configuration.components.security.auth.SecurityAuthSendService;
import fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery.CheckQueryReceive;
import fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery.CheckQueryReceiveService;
import fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery.CheckQuerySend;
import fr.alma.csa.hadl.m1.server.configuration.components.security.checkQuery.CheckQuerySendService;
import fr.alma.csa.hadl.m1.server.configuration.connector.clearance.ToSecurityAuthReceive;
import fr.alma.csa.hadl.m2.Interfaces.port.ProvidedPortComponent;
import fr.alma.csa.hadl.m2.Interfaces.service.Service;
import fr.alma.csa.hadl.m2.component.SimpleComponent;

public class SecurityManager extends SimpleComponent{

	SecurityAuthSendService secuAuthSend;
	SecurityAuthReceiveService secuAuthRcv;
	
	CheckQuerySendService checkQuerySend;
	CheckQueryReceiveService checkQueryRcv;
	
	public SecurityManager(SecurityAuthSendService service) {
		super((ProvidedPortComponent) service.getPort(), service);
		
		SecurityAuthReceive authP = new SecurityAuthReceive(); 
		secuAuthRcv = new SecurityAuthReceiveService(authP);
		this.addRequiredPort(authP);
		this.addRequiredService(secuAuthRcv);
		secuAuthRcv.addObserver(this);
		
		SecurityAuthSend authSP = new SecurityAuthSend(); 
		secuAuthSend = new SecurityAuthSendService(authSP);
		this.addProvidedPort(authSP);
		this.addProvidedService(secuAuthSend);
		
		CheckQuerySend checkP = new CheckQuerySend();
		checkQuerySend = new CheckQuerySendService(checkP);
		this.addProvidedService(checkQuerySend);
		this.addProvidedPort(checkP);
		
		CheckQueryReceive checkRP = new CheckQueryReceive();
		checkQueryRcv = new CheckQueryReceiveService(checkRP);
		this.addRequiredPort(checkRP);
		this.addRequiredService(checkQueryRcv);
		checkQueryRcv.addObserver(this);
	}

	public SecurityAuthSendService getSecuAuthSend() {
		return secuAuthSend;
	}

	public void setSecuAuthSend(SecurityAuthSendService secuAuthSend) {
		this.secuAuthSend = secuAuthSend;
	}

	public SecurityAuthReceiveService getSecuAuthRcv() {
		return secuAuthRcv;
	}

	public void setSecuAuthRcv(SecurityAuthReceiveService secuAuthRcv) {
		this.secuAuthRcv = secuAuthRcv;
	}

	public CheckQuerySendService getCheckQuerySend() {
		return checkQuerySend;
	}

	public void setCheckQuerySend(CheckQuerySendService checkQuerySend) {
		this.checkQuerySend = checkQuerySend;
	}

	public CheckQueryReceiveService getCheckQueryRcv() {
		return checkQueryRcv;
	}

	public void setCheckQueryRcv(CheckQueryReceiveService checkQueryRcv) {
		this.checkQueryRcv = checkQueryRcv;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == secuAuthRcv){
			
		}
		else if(o == checkQueryRcv){
			System.out.println("Passage dans SecurityManager, update : " + ((Service)o).getO().toString());
			goAway(((Service)o).getO());
		}
	}

	public void goAway(Object o){
		System.out.println("Passage dans SecurityManager, goAway : " + o.toString());
		secuAuthSend.sendSecurityAuth(o);
	}
}
