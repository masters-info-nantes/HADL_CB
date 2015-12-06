package fr.alma.csa.hadl.m1.server.configuration.connector.sqlQuery;

import java.util.Observable;

import fr.alma.csa.hadl.m1.clientserver.FromClientSendRequestPort;
import fr.alma.csa.hadl.m2.connector.Glue;
import fr.alma.csa.hadl.m2.connector.SimpleConnector;

public class SQLQuery extends SimpleConnector{
	FromDBQuerySend fromDBQuery;
	ToDBQueryReceive toDBQuery;
	
	FromQueryDSend fromQueryD;
	ToQueryDReceive toQueryD;
	
	public SQLQuery(ToDBQueryReceive provrole, FromDBQuerySend reqrole) {
		super(new Glue(), provrole, reqrole);
		fromDBQuery = reqrole;
		toDBQuery = provrole;
		fromDBQuery.addObserver(this);
		
		fromQueryD = new FromQueryDSend();
		toQueryD = new ToQueryDReceive();
		fromQueryD.addObserver(this);
	}
	
	public void doSomethingQueryD(Object o){
		System.out.println("Passage dans SQLQuery, doSomethingQueryD : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.toQueryD.setO(temp);
	}
	
	public void doSomethingDBQuery(Object o){
		System.out.println("Passage dans SQLQuery, doSomethingDBQuery : " + o.toString());
		Object temp = this.getGlue().doNothing(o);
		this.toDBQuery.setO(temp);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o == fromQueryD){
			System.out.println("Passage dans SQLQuery, update : " + ((FromClientSendRequestPort)o).getO().toString());
			doSomethingQueryD(fromQueryD.getO());
		}
		else if(o == fromDBQuery){
			System.out.println("Passage dans SQLQuery, update : " + ((FromClientSendRequestPort)o).getO().toString());
			doSomethingDBQuery(fromDBQuery.getO());
		}
	}

	public FromDBQuerySend getFromDBQuery() {
		return fromDBQuery;
	}

	public void setFromDBQuery(FromDBQuerySend fromDBQuery) {
		this.fromDBQuery = fromDBQuery;
	}

	public ToDBQueryReceive getToDBQuery() {
		return toDBQuery;
	}

	public void setToDBQuery(ToDBQueryReceive toDBQuery) {
		this.toDBQuery = toDBQuery;
	}

	public FromQueryDSend getFromQueryD() {
		return fromQueryD;
	}

	public void setFromQueryD(FromQueryDSend fromQueryD) {
		this.fromQueryD = fromQueryD;
	}

	public ToQueryDReceive getToQueryD() {
		return toQueryD;
	}

	public void setToQueryD(ToQueryDReceive toQueryD) {
		this.toQueryD = toQueryD;
	}
}
