package model;

import java.util.ArrayList;
import java.util.Random;

public class Model_Database {
	
	
	private ArrayList<Integer> gameRecord = new ArrayList<Integer>();
	
	private int numOfHumanWins;
	
	private int numOfAIWins;
	
	private int averageNumOfDraws;
	
	private int numOfTotalGames;
	
	private int longetGame;

	public ArrayList<Integer> getGameRecord() {
		return gameRecord;
	}

	public void setGameRecord(ArrayList<Integer> gameRecord) {
		this.gameRecord = gameRecord;
	}

	public int getNumOfHumanWins() {
		return numOfHumanWins;
	}

	public void setNumOfHumanWins(int numOfHumanWins) {
		this.numOfHumanWins = numOfHumanWins;
	}

	public int getNumOfAIWins() {
		return numOfAIWins;
	}

	public void setNumOfAIWins(int numOfAIWins) {
		this.numOfAIWins = numOfAIWins;
	}

	public int getAverageNumOfDraws() {
		return averageNumOfDraws;
	}

	public void setAverageNumOfDraws(int averageNumOfDraws) {
		this.averageNumOfDraws = averageNumOfDraws;
	}

	public int getNumOfTotalGames() {
		return numOfTotalGames;
	}

	public void setNumOfTotalGames(int numOfTotalGames) {
		this.numOfTotalGames = numOfTotalGames;
	}

	public int getLongetGame() {
		return longetGame;
	}

	public void setLongetGame(int longetGame) {
		this.longetGame = longetGame;
	}
	

	
	
	
	
}



