package com.ap.ozlympic.model;


public abstract class Participants {
	private String ID;
	private String type;
	private String name;
	private int age;
	private String state;

	// Constructor
	public Participants(String ID, String type, String name, int age, String state) {
		this.ID = ID;
		this.type = type;
		this.name = name;
		this.age = age;
		this.state = state;

	}

	public String getID() {
		return ID;
	}

	public String getType() {
		return type;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "ID: " + ID + ", Type: " + type + ", Name: " + name + ", Age: " + age + ", State: " + state;
	}
}
