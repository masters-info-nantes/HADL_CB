package fr.alma.csa.hadl.m1.server.configuration.connector.security;

import java.util.Observable;

import fr.alma.csa.hadl.m1.clientserver.FromClientSendRequestPort;
import fr.alma.csa.hadl.m1.server.configuration.connector.clearance.FromSecurityAuthSend;
import fr.alma.csa.hadl.m1.server.configuration.connector.clearance.ToSecurityAuthReceive;
import fr.alma.csa.hadl.m2.connector.Glue;
import fr.alma.csa.hadl.m2.connector.SimpleConnector;

public class SecurityQuery extends SimpleConnector{
	FromCheckQuerySend fromCheckQuery;
	ToCheckQueryReceive toCheckQuery;
	
	FromSecurityAuthSend fromSecAuth;
	ToSecurityAuthReceive toSecAuth;
	
	public SecurityQuery(ToCheckQueryReceive provrole, FromCheckQuerySend reqrole) {
		super(new Glue(), provrole, reqrole);
		fromCheckQuery = reqrole;
		toCheckQuery = provrole;
		fromCheckQuery.addObserver(this);
		
		fromSecAuth = new FromSecurityAuthSend();
		toSecAuth = new ToSecurityAuthReceive();
		fromSecAuth.addObserver(this);
	}
	
	public void doSomethingAuth(Object o){
		System.out.println("Passage dans SecurityQuery, doSomethingAuth : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.toSecAuth.setO(temp);
	}
	
	public void doSomethingCheck(Object o){
		System.out.println("Passage dans SecurityQuery, doSomethingCheck : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.toCheckQuery.setO(temp);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == fromSecAuth){
			System.out.println("Passage dans SecurityQuery, update : " + ((FromClientSendRequestPort)o).getO().toString());
			doSomethingAuth(fromSecAuth.getO());
		}
		else if(o == fromCheckQuery){
			System.out.println("Passage dans SecurityQuery, update : " + ((FromClientSendRequestPort)o).getO().toString());
			doSomethingCheck(fromCheckQuery.getO());
		}
	}

}
