package model;

import java.util.ArrayList;
import java.util.Random;

public class DBConnected {
	
	private ArrayList<Model_Card> cards = new ArrayList<Model_Card>();
	
	private ArrayList<Integer> gameRecord = new ArrayList<Integer>();
	
	private int numOfHumanWins;
	
	private int numOfAIWins;
	
	private int avgNumOfDraws;
	
	
	public ArrayList<Integer> getGameRecord() {
		return gameRecord;
	}

	public void setGameRecord(ArrayList<Integer> gameRecord) {
		this.gameRecord = gameRecord;
	}

	public ArrayList<Model_Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Model_Card> cards) {
		this.cards = cards;
	}
	
	
	
	
	public int getNumOfHumanWins() {
		return numOfHumanWins;
	}

	public int getNumOfAIWins() {
		return numOfAIWins;
	}

	public int getAvgNumOfDraws() {
		return avgNumOfDraws;
	}

	public Model_Card randomCard() {
		int randomNumCard = new Random().nextInt(cards.size());
		Model_Card pickCard = cards.get(randomNumCard);
		cards.remove(randomNumCard);
		return pickCard;
	}
	
	
	
	
}



