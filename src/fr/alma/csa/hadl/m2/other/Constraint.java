package fr.alma.csa.hadl.m2.other;

public class Constraint {
	private String name;
	private String constraint;
	
	public Constraint(String name, String constraint) {
		super();
		this.name = name;
		this.constraint = constraint;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getConstraint() {
		return constraint;
	}
	
	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}
	
}
