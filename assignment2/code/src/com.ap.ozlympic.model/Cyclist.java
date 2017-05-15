package com.ap.ozlympic.model;


import java.util.Random;

public class Cyclist extends Athlete {

	public Cyclist(String ID, String type, String name, int age, String state) {
		super(ID, type, name, age, state);
		// TODO Auto-generated constructor stub
	}

	// Range 500~800
	final int range = 301;
	final int start = 500;

	// implement compete
	public int compete(String gameType) {
		int seconds;
		Random R = new Random();
		seconds = R.nextInt(range) + start;
		return seconds;
	}

}
