package com.ap.ass2.model;

import java.util.ArrayList;
import java.util.List;


public class Official extends Participants {

	ArrayList<Athlete> resultList = new ArrayList<>();
	ArrayList<Integer> scoreList = new ArrayList<>();
	final int firstrank = 1;
	final int secondrank = 2;
	final int thirdrank = 3;
	final int firstpoint = 5;
	final int secondpoint = 2;
	final int thirdpoint = 1;

	public Official(String ID, String type, String name, int age, String state) {
		super(ID, type, name, age, state);
		// TODO Auto-generated constructor stub
	}
	public void initNewGame(){
		resultList = new ArrayList<>();
		scoreList = new ArrayList<>();
	}
	
	public void rank(Athlete athlete, int result) {
		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i) < result) {
				continue;
			} else {
				resultList.add(i, athlete);
				scoreList.add(i, result);
				break;
			}
		}
		if (!resultList.contains(athlete)) {
			resultList.add(athlete);
			scoreList.add(result);
		}
	}

	public void summarise() {
		for (int rank = 1; rank <= 3; rank++) {
			Athlete athlete = resultList.get(rank);
			switch (rank) {
			case firstrank:
				athlete.addPoints(firstpoint);
				break;
			case secondrank:
				athlete.addPoints(secondpoint);
				break;
			case thirdrank:
				athlete.addPoints(thirdpoint);
				break;
			default:
				break;
			}
		}
	}

	public List<Athlete> getResult() {
		return resultList;
	}

	public List<Integer> getscoreList() {
		return scoreList;
	}
}
