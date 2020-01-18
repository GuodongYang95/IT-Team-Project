package commandline;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.sun.crypto.provider.RC2Parameters;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class GameManager {
	private int totalcard = 40; //this should be 40 cards totally
	private int roundCount; //record the round
	private int drawTimes; //record how many times of draw happened during a game.
	private boolean userWin; //true/false attribute.if it is true, it means user wins at a game; false means AI wins the game.
	private Player[] players; //this is player array, store the user object and AI objects. The number of AI is decided by user.
	private ArrayList<Card> commonCardPile; //this attribute will store card while a draw round.
	private int numOfGames = 0;
	
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
			statistics();
		}
		if (choice == 2) {
			System.out.println("How many AI do you want to play with?");
			Scanner s = new Scanner(System.in);
			int numOfAI = s.nextInt();
			players = new Player[numOfAI+1];
			players[0] = new User("YOU");
			
			for (int i = 1; i <= numOfAI; i++) {
				String aIName = "AI" + i;
				players[i] = new AI(aIName);
			}
			roundCount = 1;
			drawTimes = 0;
			userWin = false;
			cardDistribute(db);
		}
		
	}
	
	public int gameOrStatistics() {
		System.out.println("Do you want to see past results of play a game?");
		System.out.println("1. Print Game Statistics");
		System.out.println("2. Play game");
		Scanner s = new Scanner(System.in);
		int userChoice = s.nextInt();
		System.out.println("Enter the number for your selection:" + userChoice);
		return userChoice;
	}
	
	public void statistics(DBConnected db) {
		System.out.println("Number of Games: " + numOfGames);
		System.out.println("Number of Human Wins: " + db.numOfHumanWins);
		System.out.println("Number of AI Wins: " + db.numOfAIWins);
		System.out.println("Average number of Draws: " + avgNumOfDraws);
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
			commonCardPile.add(	db.randomCard());
			}
		for (int i = 0; i < players.length; i++) {
			for (int j = 0; j < numOfCard; j++) {
				players[i].getCardPile().add(db.randomCard());
			}
		}
		
	}
	
	public void infoRecord(DBConnected db) {
		/*
		 * This method will store information including roundCount, 
		 * drawTimes and userWin to the DBConnected instance.
		 */
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].GetName() + " : " + players[i].GetScore());
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
				players[i].isOut() = true;
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
