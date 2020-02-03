package commandline;

import java.util.ArrayList;
import java.util.Scanner;

public class Model_PlayerManager {
	
	//Attributes
	
	private Model_Player[] players; //this is player array, store the user object and AI objects. The number of AI is decided by user.
	
	private Model_CardPile cardPile; 
	
	
	
	//Contributor
	public Model_PlayerManager(int numberOfAI) {
		
		players = new Model_Player[numberOfAI+1];
		players[0] = new Model_User("You");
		for (int i = 1; i < players.length; i++) {
			String aiName = "Player AI "+i;
			players[i] = new Model_AI(aiName);
			
		}
		
		this.cardPile = new Model_CardPile();
		
	}
	
	
	//Getter and Setter
	
	public Model_Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Model_Player[] players) {
		this.players = players;
	}
	
	public Model_CardPile getCardPile() {
		return cardPile;
	}
	
	

	
	
	
	
	// Method
	
	/*
	 * this method will distribute the card averagely according to the number of players
	 * it will also get the property of each card from DBConnected instance.
	 * And put them into player's cardPile.
	 */


	public void cardDistribute(Model_RoundManager rm) { 
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
				// clear the commonPile;
				rm.getCommonCardPile().clear();
			}
			
		//then add all the player card to the distributedCardList including winner owned card
			//out player will be passed
			for (Model_Player player : players) {
				if(player.isOut()==false) {
				Model_Card playerHold = player.getOwnedCard();
				
				distributedCardList.add(playerHold);
				}else {
					continue;
				}
			}
			
		//After that, then judge it is draw or not
			
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
	
	public void playersDrawCard() {
		for (Model_Player player : players) {
			if(player.isOut() == false) {
			player.pickCard();
			}
		}
	}
	public void playersSelectCategory(Model_RoundManager rm) {
		Model_Player activePlayer = rm.getActivePlayer();
		String selectedCategory = "";
		
		if(activePlayer instanceof Model_User) {
			int selectedCategoryNumber = playerInput();
			selectedCategory = ((Model_User) activePlayer).userSelectCategory(selectedCategoryNumber);
		}else if(activePlayer instanceof Model_AI ) {
			selectedCategory = ((Model_AI) activePlayer).selectCategory();
		}
		
		for (Model_Player player : players) {

				player.selectCategory(selectedCategory);

		}
		
	}
	
	public int playerInput() {
		Scanner scanner = new Scanner(System.in);
		int playerinput = scanner.nextInt();
		return playerinput;
	}
	
	public String playersCardPileDetails() {
		String output = "";
		
		for (Model_Player player : players) {
			
			if(player.isOut() == false)
			output +=player.playerCardPileDetails();
			output += "\n";
		}
		
		return output;
	}
	
	//this method is used to return the selectedCardDetail of each player
	public String selectedCategoryDetails() {
		String output = "";
		for (Model_Player player : players) {
			if(player.isOut()==false)
			output += player.getName() + " : " + player.getOwnedCard().selectedCategoryDetail() + "\n";
		}
		return output;
	}
	
	
}
