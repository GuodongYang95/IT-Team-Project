package model;

import java.util.ArrayList;

public class Model_PlayerManager {
	
	//Attributes
	
	private Model_Player[] players; //this is player array, store the user object and AI objects. The number of AI is decided by user.
	
	
	
	
	
	//Contributor
	public Model_PlayerManager() {
		
	}
	
	
	//Getter and Setter
	
	public Model_Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Model_Player[] players) {
		this.players = players;
	}

	
	
	
	
	// Method
	
	public void cardDistribute(Model_CardPile cardPile, Model_RoundManager rm) { 
		/*
		 * this method will distribute the card averagely according to the number of players
		 * it will also get the property of each card from DBConnected instance.
		 * And put them into player's cardPile.
		 */
		
		// numOfCard present the number of card that each player should have at first round.
		int numOfCard = cardPile.getCards().size() / players.length;
		
		// if there are three players, cardpile cannot be exactly divided
		
		if (players.length == 3) { 
			/*
			 * When the user choose 2 AI, which means there are 3 players playing with 40 cards.
			 * then draw a card randomly to the communal pile before the round 1.
			 * It will be taken by the winner of this round.
			 */
			
			// add one to the common pile at first
			rm.getCommonCardPile().add(cardPile.extractCard());// this randomCard() method is going to draw a card and remove it from the Whole pile.
			}
		
		for (int i = 0; i < players.length; i++) {  //traverse each player in the game
			
			for (int j = 0; j < numOfCard; j++) {
				
				players[i].getCardPile().add(cardPile.extractCard());
				
			}
		}
		
	}
	
	
	public void distributeCardToWinner(Model_RoundManager rm) {
		
		// declare a distributedCardList
		ArrayList<Model_Card> distributedCardList = new ArrayList<Model_Card>();
		
		// add the commonCardPile to the distributedCardLis at first
			if(rm.getCommonCardPile().size() != 0) {
				for (Model_Card card : rm.getCommonCardPile()) {
					distributedCardList.add(card);
				}
			}
			
		//then add all the player card to the distributedCardList including winner owned card
			for (Model_Player player : players) {
				
				Model_Card playerHold = player.getOwnedCard();
				
				distributedCardList.add(playerHold);
			}
			
		//then judge it is draw or not
			
		if(rm.isDraw()) {

			for (Model_Card card : distributedCardList) {
				rm.getCommonCardPile().add(card);
			}
		}else {
		// if it is not draw
			for (Model_Card card : distributedCardList) {
				rm.getRoundWinPlayer().getCardPile().add(card);
				
			}
			
		}
	}
	
	
}
