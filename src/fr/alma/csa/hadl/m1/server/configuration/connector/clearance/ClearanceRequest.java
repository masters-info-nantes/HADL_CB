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
		super(new Glue(), provrole, reqrole);
		fromSecAuth = reqrole;
		toSecAuth = provrole;
		fromSecAuth.addObserver(this);
		
		fromSecCheck = new FromSecurityCheckSend();
		toSecCheck = new ToSecurityCheckReceive();
		fromSecCheck.addObserver(this);
	}
	
	public void doSomethingAuth(Object o){
		System.out.println("Passage dans ClearanceRequest, doSomethingAuth : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.toSecAuth.setO(temp);
	}
	
	public void doSomethingCheck(Object o){
		System.out.println("Passage dans ClearanceRequest, doSomethingCheck : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.toSecCheck.setO(temp);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == fromSecAuth){
			System.out.println("Passage dans ClearanceRequest, update : " + ((FromClientSendRequestPort)o).getO().toString());
			doSomethingAuth(fromSecAuth.getO());
		}
		else if(o == fromSecCheck){
			System.out.println("Passage dans ClearanceRequest, update : " + ((FromClientSendRequestPort)o).getO().toString());
			doSomethingCheck(fromSecCheck.getO());
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
