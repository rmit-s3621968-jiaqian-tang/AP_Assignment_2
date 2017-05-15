package com.ap.ozlympic.model;


import java.util.Random;

public class Sprinter extends Athlete {

	public Sprinter(String ID, String type, String name, int age, String state) {
		super(ID, type, name, age, state);

	}

	// Range 10~20
	final int range = 11;
	final int start = 10;

	public int compete(String gameType) {
		int seconds;
		Random R = new Random();
		seconds = R.nextInt(range) + start;
		return seconds;
	}
}
