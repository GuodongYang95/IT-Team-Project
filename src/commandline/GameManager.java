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
	private Player[] players; //this is player array, store the user object and AI objects, n is decided by user.
	private ArrayList<Card> commonCardPile; //this attribute will store card while a draw round.
	
	public void startGame(DBConnected db) {
		/*
		 * This 
		 */
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
	
	
	
	
}
