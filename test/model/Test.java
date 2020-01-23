package model;

public class Test {
	public static void main(String[] args) {
		Modle_CardPile cardpile = new Modle_CardPile();
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
