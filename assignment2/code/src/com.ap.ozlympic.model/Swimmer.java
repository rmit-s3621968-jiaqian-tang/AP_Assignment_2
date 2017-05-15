package com.ap.ozlympic.model;

import java.util.Random;

public class Swimmer extends Athlete {

	public Swimmer(String ID, String type, String name, int age, String state) {
		super(ID, type, name, age, state);
		// TODO Auto-generated constructor stub
	}

	// Range 100~200
	final int range = 101;
	final int start = 100;

	// implement compete
	public int compete(String gameType) {
		int seconds;
		Random R = new Random();
		seconds = R.nextInt(range) + start;
		return seconds;
	}

}
