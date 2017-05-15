package com.ap.ozlympic.model;


public abstract class Athlete extends Participants {

	private int points = 0;

	public Athlete(String ID, String type, String name, int age, String state) {
		super(ID, type, name, age, state);
		// TODO Auto-generated constructor stub
	}

	public abstract int compete(String gameType);

	public void addPoints(int points) {
		this.points += points;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
