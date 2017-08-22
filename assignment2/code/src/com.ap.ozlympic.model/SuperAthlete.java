package com.ap.ozlympic.model;

import java.util.Random;

import com.ap.ozlympic.controller.Driver;

public class SuperAthlete extends Athlete {

	public SuperAthlete(String ID, String type, String name, int age, String state) {
		super(ID, type, name, age, state);
		// TODO Auto-generated constructor stub
	}

	private int range = 0;
	private int start = 0;

	public int compete(String gameType) {
		switch (gameType) {
		case Driver.RUN:
			range = 11;
			start = 10;
			break;
		case Driver.SWIM:
			range = 101;
			start = 100;
			break;
		case Driver.CYCLE:
			range = 301;
			start = 500;
			break;
		}

		int seconds;
		Random R = new Random();
		seconds = R.nextInt(range) + start;
		return seconds;

	}

}
