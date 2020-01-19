package commandline;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.sun.crypto.provider.RC2Parameters;
import com.sun.media.sound.AiffFileReader;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class GameManager {
	private int totalcard = 40; //this should be 40 cards totally
	private int roundCount; //record the round
	private int drawTimes; //record how many times of draw happened during a game.
	private boolean userWin; //true/false attribute.if it is true, it means user wins at a game; false means AI wins the game.
	private Player[] players; //this is player array, store the user object and AI objects. The number of AI is decided by user.
	private ArrayList<Card> commonCardPile; //this attribute will store card while a draw round.
	private int numOfGames = 0;
	private Player roundWinPlayer; // this attribute will record the winner for each round
	
	
	public void startGame(DBConnected db) {
		/*
		 * This method  will create the AI and user players.
		 * The user will be stored in player[0] and the AI players will be stored in player[] 
		 * from player[1] to player[numOfAI] with their names
		 * Then initialize roundCount, drawTimes and userWin.
		 * Distribute cards to every player.
		 */
		
		int choice = gameOrStatistics(); 
		if (choice == 1) {
			statistics(db);
		}
		if (choice == 2) {
			System.out.println("How many AI do you want to play with?");
			Scanner s = new Scanner(System.in);
			int numOfAI = s.nextInt();
			s.close();
			
			
			// Create the Player Group:
			players = new Player[numOfAI+1];
			players[0] = new User("YOU");
			
			for (int i = 1; i <= numOfAI; i++) {
				String aIName = "AI" + i;
				players[i] = new AI(aIName);
			}
			
			//initialize the gameData at the start of the game
			
			roundCount = 1;
			drawTimes = 0;
			userWin = false;
			
			//Distribute the card to each Player(User and AI)
			cardDistribute(db);
			
			//Active one player
			activePlayerSelector();
		}
		
	}
	
	public int gameOrStatistics() {
		System.out.println("Do you want to see past results of play a game?");
		System.out.println("1. Print Game Statistics");
		System.out.println("2. Play game");
		Scanner s = new Scanner(System.in);
		int userChoice = s.nextInt();
		System.out.println("Enter the number for your selection:" + userChoice);
		s.close();// it should be closed at the end
		return userChoice;
	}
	
	// Get history record method
	public void statistics(DBConnected db) {
		System.out.println("Number of Games: " + numOfGames);
		System.out.println("Number of Human Wins: " + db.getNumOfHumanWins());
		System.out.println("Number of AI Wins: " + db.getNumOfAIWins());
		System.out.println("Average number of Draws: " + db.getAvgNumOfDraws());
		System.out.println("Longest Game: " + roundCount);
		
	}
	
	public void cardDistribute(DBConnected db) { 
		/*
		 * this method will distribute the card averagely according to the number of players
		 * it will also get the property of each card from DBConnected instance.
		 * And put them into player's cardPile.
		 */
		int numOfCard = totalcard / players.length;
		if (players.length == 3) { 
			/*
			 * When the user choose 2 AI, which means there are 3 players playing with 40 cards.
			 * then draw a card randomly to the communal pile before the round 1.
			 * It will be taken by the winner of this round.
			 */
			commonCardPile.add(	db.randomCard());// this randomCard() method is going to draw a card and remove it from the Whole pile.
			}
		for (int i = 0; i < players.length; i++) {
			for (int j = 0; j < numOfCard; j++) {
				players[i].getCardPile().add(db.randomCard());
			}
		}
		
	}
	
	public void activePlayerSelector() {
		//if it is first time, the system will randomly select a player to be active
		if(roundCount==1) {
			players[new Random().nextInt(players.length)].setActive(true);
		}
	}
		
	//-----------------------these function will be used in each round----------------------------------
	//-------------------------------when a round start---------------------draw card, select catogory--------
	public void roundStart() {
		//increase the roundcount
		this.roundCount++;
		System.out.println("Round "+roundCount);
		
		//each user should randomly picked a card;
		for (Player player : players) {
			player.takeCard();
		}
		
		System.out.println("You drew "+"\""+players[0].getHandCardDescription()+"\"");
		System.out.println(players[0].getHand());
		System.out.println("There are '"+players[0].getNumberOfCard()+" in your deck");
	
		//	This part can decide who have right to choose the category
		//----------------------------
			//when the user is active
		if(players[0].isActive()) {
			
			System.out.println("It is your turn to select a category, the categories are:");
				
			  //System.out.println("Enter the number for your attribute: "); this should put in the selectCategory() function.
			
			//should display the card here!!!!!!!!!!! method needed!!!
			
			String string = new User("user").selectCategory(); 
			
			players[0].setActive(false); //if player have chance to select, set false after selecting
			
			players[0].getHand().setSelectedAttributeString(string);
			
			// Other Player should select the category automatically
			for(int i =0; i<players.length; i++) {
					players[i].selectCategory(string);
				}
			
			
		}
		else {
			//when the user is not active
			
			String aISelectedAttribute = "";
			//find the active AI and let it select category
			for (Player player : players) {
				if(player.isActive()) {
					aISelectedAttribute = new AI("ai").selectCategory();//AI will choose the biggest value
					
					player.setActive(false); // set false after selecting
				}
			}
			// set it to all player
			for (Player player : players) {
				player.getHand().setSelectedAttributeString(aISelectedAttribute);
				
			}
			
		}
		//--------------------------------- round start -------------
		
	}
	
	//-------------------------------when a round got to end---------------------
	//--------------------------------- find winner or it is draw, distribute card -------------
	public void showRoundResult() {
		//find the winner:
		int maxValue = findMaxCatagoryValue();
		
		ArrayList<Player> maxValuePlayerList = hasMaxValuePlayerList(maxValue);
		
		selectWinner(maxValuePlayerList);
		
		// active the player for next round
		
		activePlayerSelector(maxValuePlayerList);
		
		
		// distribute the card
		distributeCardToWinner(maxValuePlayerList);
		
		//Judge a layer should be out  or the game should over
		
		
	}
	

	
	public void activePlayerSelector(ArrayList<Player> maxValuePlayerList) {
		
		if(isDraw(maxValuePlayerList)) {
			//it is draw
			if(maxValuePlayerList.contains(players[0])) {
				// if user is included
				players[0].setActive(true);
			}else {
				//randomly select an ai in the maxlist
				int randomNumber = new Random().nextInt(maxValuePlayerList.size());
				maxValuePlayerList.get(randomNumber).setActive(true);
			}
		}
		else { 
			// it is not draw, so set the winner active
				roundWinPlayer.setActive(true);
		}
				
	}
	
	 public boolean isDraw(ArrayList<Player> playerList) {
		 
		 	if(playerList.size() >1) {
				//it is draw
			 	return true;
			 	
			}
			else { // it is not draw, so there is only one player in the list
				return false;
			}
	 }
	/***
	 * This method will return a list of the player who has max value
	 * if maxValueAIList.size() >1, it is draw
	 * else: it is not draw
	 * @return maxValueAIList
	 */
	

	
	
	public int findMaxCatagoryValue() {
		//default user has the max value
		int maxValue = players[0].getHand().getSelectedCategoryValue();
		
			for (Player player : players) {
				int tempvalue = player.getHand().getSelectedCategoryValue();
				if(tempvalue > maxValue)
					maxValue = tempvalue;
			}
			
		return maxValue;
	}
	public ArrayList<Player> hasMaxValuePlayerList(int maxValue) {
		
		ArrayList<Player> maxValuePlayerList = new ArrayList<Player>();
		
		for (Player player : players) {
			int tempvalue = player.getHand().getSelectedCategoryValue();
			if(maxValue == tempvalue) { //find how many max value,min is 1

				maxValuePlayerList.add(player);
				
				
			}
		}
		return maxValuePlayerList;
	}
	
	
	// this method is going to find winner for each round
	public void selectWinner(ArrayList<Player> maxValuePlayerList) {
		System.out.print("Round "+roundCount+":");
		if(isDraw(maxValuePlayerList)) {
			System.out.println("This round was a Draw, common pile now has "+ commonCardPile.size()+" cards");
			roundWinPlayer = null;
		}else {
			//if it is not draw, means that there are only one Player in the list
			roundWinPlayer = maxValuePlayerList.get(0);
			System.out.println("Player "+ roundWinPlayer.getName() +" won this round");
			
			// add a score to the winner
			int winnerscore = roundWinPlayer.getNumberOfCard();
			winnerscore++;
			roundWinPlayer.setScore(winnerscore);
		}
		
	}
	
	public void distributeCardToWinner(ArrayList<Player> maxValuePlayerList) {
		
		// declare a distributedCardList
		ArrayList<Card> distributedCardList = new ArrayList<Card>();
		
		// add the commonCardPile to the distributedCardLis at first
			if(commonCardPile.size() != 0) {
				for (Card card : commonCardPile) {
					distributedCardList.add(card);
				}
			}
			
		//then add all the player card to the distributedCardList
			for (Player player : players) {
				Card playerHold = player.getHand();
				distributedCardList.add(playerHold);
			}
		//then judge it is draw or not
			
		if(isDraw(maxValuePlayerList)) {

			for (Card card : distributedCardList) {
				commonCardPile.add(card);
			}
		}else {
		// if it is not draw
			for (Card card : distributedCardList) {
				roundWinPlayer.getCardPile().add(card);
				
			}
			
		}
	}
	//-------------------------ending Game-------------------------
	
	public void infoRecord(DBConnected db) {
		/*
		 * This method will store information including roundCount, 
		 * drawTimes and userWin to the DBConnected instance.
		 */
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].getName() + " : " + players[i].getScore());
		}
		
	}
	
	public void winOrOut() {
		/*
		 * If a player has 40 cards on his pile, the he will win the game. 
		 * Game over, recording game information.
		 * If a player got 0 cards on his pile, then he is out.
		 */
		for (int i = 0; i < players.length; i++) {
			if (players[i].getCardPile().size() == 0) {
				players[i].setOut(true); 
			}
			if (i == 0 && players[i].getCardPile().size() == 40) {
				userWin = true;
				endGame();
			}
			if (i != 0 && players[i].getCardPile().size() == 40) {
				endGame();
			}
		}
		
	}
	
	public void endGame(Player p, DBConnected db) {
		numOfGames++;
		System.out.println("Game Over");
		System.out.println("The overall winnder was " + p);
		System.out.println("Scores: ");
	
		infoRecord(db);
		int choice = gameOrStatistics();
		if (choice == 1) {
			statistics();
		}
		if (choice == 2) {
			startGame(db);
		}
		
	}
	
	
	
	
	
}
