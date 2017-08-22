package com.ap.ozlympic.model;

public class Message {
	// ID "oz1234"
	private String ID;

	// Type "sptinter..."
	private String Type;

	// Name "Tony"
	private String Name;

	// Age "24"
	private int Age;

	// State "VIC"
	private String State;

	public Message() {
	};

	public Message(String ID, String Type, String Name, int Age, String State) {
		this.ID = ID;
		this.Type = Type;
		this.Name = Name;
		this.Age = Age;
		this.State = State;

	};

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public void setItems(Message table) {
		// TODO Auto-generated method stub

	}

}