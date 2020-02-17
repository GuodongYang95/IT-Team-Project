package test;
import commandline.*;

public class test {
	public static void main(String[] args) {
		Model_CardPile cardpile = new Model_CardPile();
		String fileName = "./StarCitizenDeck.txt";
		
		cardpile.initializeCard(fileName);
		
		for (Model_Card card : cardpile.getCards()) {
			System.out.println(card.getDescription());
			System.out.println(card);
			System.out.println("-----------------");
		}
		System.out.println(cardpile.getCards().size());
	}
}
