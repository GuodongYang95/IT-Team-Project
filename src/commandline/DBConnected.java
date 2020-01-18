package commandline;

import java.util.ArrayList;
import java.util.Random;

public class DBConnected {
	
	private ArrayList<Card> cards = new ArrayList<Card>();

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



