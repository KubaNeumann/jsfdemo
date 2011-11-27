package com.example.jsfdemo.domain;

import javax.validation.constraints.Min;

public class Person {
	
	private String name = "unknown";
	private int yob = 1900;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Min(value=1900)
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}

}
