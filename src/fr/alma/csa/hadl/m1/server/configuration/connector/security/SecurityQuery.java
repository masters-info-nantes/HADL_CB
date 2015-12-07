package fr.alma.csa.hadl.m1.server.configuration.connector.security;

import java.util.Observable;

import fr.alma.csa.hadl.m1.server.configuration.connector.clearance.ToSecurityAuthReceive;
import fr.alma.csa.hadl.m2.connector.Glue;
import fr.alma.csa.hadl.m2.connector.SimpleConnector;

public class SecurityQuery extends SimpleConnector{
	FromCheckQuerySend fromCheckQuery;
	ToCheckQueryReceive toCheckQuery;
	
	FromSecurityManagementSend fromSecAuth;
	ToSecurityManagementReceive toSecAuth;
	
	public SecurityQuery(ToCheckQueryReceive provrole, FromCheckQuerySend reqrole) {
		super(new Glue(), reqrole, provrole);
		fromCheckQuery = reqrole;
		toCheckQuery = provrole;
		toCheckQuery.addObserver(this);
		
		fromSecAuth = new FromSecurityManagementSend();
		toSecAuth = new ToSecurityManagementReceive();
		toSecAuth.addObserver(this);
	}
	
	public void doSomethingAuth(Object o){
		System.out.println("Passage dans SecurityQuery, doSomethingAuth : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.fromCheckQuery.setO(temp);
	}
	
	public void doSomethingCheck(Object o){
		System.out.println("Passage dans SecurityQuery, doSomethingCheck : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.fromSecAuth.setO(temp);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == toSecAuth){
			System.out.println("Passage dans SecurityQuery, update : " + ((ToSecurityAuthReceive)o).getO().toString());
			doSomethingAuth(((ToSecurityAuthReceive)o).getO());
		}
		else if(o == toCheckQuery){
			System.out.println("Passage dans SecurityQuery, update : " + ((ToCheckQueryReceive)o).getO().toString());
			doSomethingCheck(((ToCheckQueryReceive)o).getO());
		}
	}

	public FromCheckQuerySend getFromCheckQuery() {
		return fromCheckQuery;
	}

	public void setFromCheckQuery(FromCheckQuerySend fromCheckQuery) {
		this.fromCheckQuery = fromCheckQuery;
	}

	public ToCheckQueryReceive getToCheckQuery() {
		return toCheckQuery;
	}

	public void setToCheckQuery(ToCheckQueryReceive toCheckQuery) {
		this.toCheckQuery = toCheckQuery;
	}

	public FromSecurityManagementSend getFromSecManag() {
		return fromSecAuth;
	}

	public void setFromSecManag(FromSecurityManagementSend fromSecAuth) {
		this.fromSecAuth = fromSecAuth;
	}

	public ToSecurityManagementReceive getToSecManag() {
		return toSecAuth;
	}

	public void setToSecManag(ToSecurityManagementReceive toSecAuth) {
		this.toSecAuth = toSecAuth;
	}
}
