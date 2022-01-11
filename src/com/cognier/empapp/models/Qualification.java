package com.cognier.empapp.models;

public class Qualification {
	private String name;
	private boolean isExpired;

	public Qualification(String name, boolean isExpired) {
		this.name = name;
		this.isExpired = isExpired;
	}

	public String getName() {
		return name;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	
	

}
