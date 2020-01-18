package commandline;

import java.util.ArrayList;
import java.util.Random;

public class DBConnected {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	private ArrayList<Integer> gameRecord = new ArrayList<Integer>();

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
	
	public Card randomCard() {
		int randomNumCard = new Random().nextInt(cards.size());
		Card pickCard = cards.get(randomNumCard);
		cards.remove(randomNumCard);
		return pickCard;
	}
	
	
	
	
}



