package com.ap.ozlympic.model;


import java.util.ArrayList;
import java.util.List;

public abstract class Game {
	private String ID;
	private String type;
	private Official referee;
	private List<Athlete> athletes;
	private List<Athlete> resultList;

	public Game(String ID, String type, List<Athlete> athletes, Official referee) {
		this.ID = ID;
		this.type = type;
		this.referee = referee;
		this.athletes=athletes;
		
	}
	public void start(){		
		referee.initNewGame();
		
		//athletes list to start the game
		for(Athlete athlete : athletes){
			int result = athlete.compete(type);
			referee.rank(athlete, result);
		}
		// summarise scored of the top three winners
		referee.summarise();
		resultList = referee.getResult();

	}
	
	public List<String> getPrintResult() {
		List<String> pList = new ArrayList<String>();
		pList.add(referee.getID());
		pList.add(resultList.get(0).getID());
		pList.add(resultList.get(1).getID());
		pList.add(resultList.get(2).getID());
		return pList;
	}
	
	public List<String> getPrintName(){
		List<String> nList =new ArrayList<String>();
		nList.add(referee.getName());
		nList.add(resultList.get(0).getName());
		nList.add(resultList.get(1).getName());
		nList.add(resultList.get(2).getName());
		return nList;
		
	}

	
	public String getID() {
		return ID;
	}

	public String getType() {
		return type;
	}

	public Official getReferee() {
		return referee;
	}

	public List<Athlete> getAthletes() {
		return athletes;
	}

	public List<Athlete> getResult() {
		return resultList;
	}
	
}