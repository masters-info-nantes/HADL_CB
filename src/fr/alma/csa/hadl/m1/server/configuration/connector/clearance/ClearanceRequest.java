package fr.alma.csa.hadl.m1.server.configuration.connector.clearance;

import java.util.Observable;

import fr.alma.csa.hadl.m1.clientserver.FromClientSendRequestPort;
import fr.alma.csa.hadl.m2.connector.Glue;
import fr.alma.csa.hadl.m2.connector.SimpleConnector;

public class ClearanceRequest extends SimpleConnector{

	FromSecurityAuthSend fromSecAuth;
	ToSecurityAuthReceive toSecAuth;
	
	FromSecurityCheckSend fromSecCheck;
	ToSecurityCheckReceive toSecCheck;
	
	public ClearanceRequest(ToSecurityAuthReceive provrole, FromSecurityAuthSend reqrole) {
		super(new Glue(), reqrole, provrole);
		fromSecAuth = reqrole;
		toSecAuth = provrole;
		toSecAuth.addObserver(this);
		
		fromSecCheck = new FromSecurityCheckSend();
		toSecCheck = new ToSecurityCheckReceive();
		toSecCheck.addObserver(this);
	}
	
	public void doSomethingAuth(Object o){
		System.out.println("Passage dans ClearanceRequest, doSomethingAuth : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.fromSecCheck.setO(temp);
	}
	
	public void doSomethingCheck(Object o){
		System.out.println("Passage dans ClearanceRequest, doSomethingCheck : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.fromSecAuth.setO(temp);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == toSecAuth){
			System.out.println("Passage dans ClearanceRequest, update : " + ((ToSecurityAuthReceive)o).getO().toString());
			doSomethingAuth(((ToSecurityAuthReceive)o).getO());
		}
		else if(o == toSecCheck){
			System.out.println("Passage dans ClearanceRequest, update : " + ((ToSecurityCheckReceive)o).getO().toString());
			doSomethingCheck(((ToSecurityCheckReceive)o).getO());
		}
	}

	public FromSecurityAuthSend getFromSecAuth() {
		return fromSecAuth;
	}

	public void setFromSecAuth(FromSecurityAuthSend fromSecAuth) {
		this.fromSecAuth = fromSecAuth;
	}

	public ToSecurityAuthReceive getToSecAuth() {
		return toSecAuth;
	}

	public void setToSecAuth(ToSecurityAuthReceive toSecAuth) {
		this.toSecAuth = toSecAuth;
	}

	public FromSecurityCheckSend getFromSecCheck() {
		return fromSecCheck;
	}

	public void setFromSecCheck(FromSecurityCheckSend fromSecCheck) {
		this.fromSecCheck = fromSecCheck;
	}

	public ToSecurityCheckReceive getToSecCheck() {
		return toSecCheck;
	}

	public void setToSecCheck(ToSecurityCheckReceive toSecCheck) {
		this.toSecCheck = toSecCheck;
	}
	
	
}
