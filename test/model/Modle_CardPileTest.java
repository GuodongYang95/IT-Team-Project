package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class Modle_CardPileTest {
	Modle_CardPile cardpile;
	String fileName;
	
	@Before
	public void setup() { 
		cardpile = new Modle_CardPile();
		fileName = "./StarCitizenDeck.txt";
	}
	
	@Test
	void testInitializeCard() {
		
		cardpile.initializeCard(fileName);
		
		for (Model_Card card : cardpile.getCards()) {
			System.out.println(card.getDescription());
			System.out.println(card);
			System.out.println("-----------------");
		}
		System.out.println(cardpile.getCards().size());
	}

}
