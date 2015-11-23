package fr.alma.csa.hadl.m2.other;

public class Property {
	private String name;
	private String property;	
	
	public Property(String name, String property) {
		super();
		this.name = name;
		this.property = property;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	
}
