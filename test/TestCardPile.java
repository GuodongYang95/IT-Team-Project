import java.util.ArrayList;

import commandline.Model_Card;
import commandline.Model_CardPile;

public class TestCardPile {
	public static void main(String[] args) {
		Model_CardPile cardPile = new Model_CardPile();
		String fileName = "./StarCitizenDeck.txt";
		
		cardPile.initializeCard(fileName);
		System.out.println(cardPile.getCards().size());
		
	}
	
}
