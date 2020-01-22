package Model;

import java.util.ArrayList;
import java.util.Random;

public class DBConnected {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
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

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
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

	public Card randomCard() {
		int randomNumCard = new Random().nextInt(cards.size());
		Card pickCard = cards.get(randomNumCard);
		cards.remove(randomNumCard);
		return pickCard;
	}
	
	
	
	
}



