package view;

import java.util.HashMap;
import java.util.Iterator;

import com.sun.javafx.collections.MappingChange.Map;

public class CommandLineView {
	
	//The view of asking user whether playing a game or showing the past game statistics
	public void gameOrStatistics() { 
		System.out.println("Do you want to see past results of play a game?");
		System.out.println("1. Print Game Statistics");
		System.out.println("2. Play game");
		System.out.print("Enter the number for your selection: ");
	}
	
	// The view of asking user to choose how many AI players 
	public void numOfAi() { 
		System.out.println("\n" + "\n");
		System.out.println("How many AI do you want to play with?");
	}
	
	//The view of past game statistics
	public void statistics(Model_Database db) {
		System.out.println("\n" + "\n");
		System.out.println("Game Statistics:");
		System.out.println("Number of Games: " + db.getNumOfTotalGames());
		System.out.println("Number of Human Wins: " + db.getNumOfHumanWins());
		System.out.println("Number of AI Wins: " + db.getNumOfAiWins());
		System.out.println("Average number of Draws: " +db.getAverageNumOfDraws());
		System.out.println("Longest Game: " +db.getLongetGame());
	}
	
	//The view of the round started
	public void roundStart(Model_GameManager r, Model_Player p) {
		System.out.println("\n" + "\n");
		if (mr.getRoundCount() == 1) {
			System.out.println("Game Start");
		}else {
			System.out.println("Round " + r.getRoundCount());
			System.out.println("Round " + r.getRoundCount() + ": " + "Players have drawn their cards");
			System.out.println("You drew " + "'" + p.getCardDescription() + "'" + " :");
			p.getCardDisplay(); 
			System.out.println("There are '" + p.getNumOfCardsLeft() + " cards in your deck");
		}
	}
	
	//The view of game results 
	public void selectCategory(MOdel_GameManager r, Model_Player p) {
		HashMap<String, Integer> hm = p.getCategories();
		Iterator hmIterator = hm.entrySet().iterator();
		if (p.whoCanSelectCategory() == p.players[0]) {
			System.out.println("It is your turn to select a category, the categories are:");
			while(hmIterator.hasNext()) {
				int number = 1;
				String c = (String)hmIterator.next();
				System.out.println(number + ": " + c);
				number++;
			}
			System.out.println("Enter the number for your attribute: ");
			System.out.println("Round " + r.getRoundCount() + ": " + "Player " + r.getWinnerName() + " won this round");
			System.out.println("The winner card was '" + p.getCardDescription() + "':");
			p.getWinnerCardDisplay();
			
		}else {
			System.out.println("Round " + r.getRoundCount() + ": " + "Player " + r.getWinnerName() + " won this round");
			p.getWinnerCardDisplay();
		}
	}
	//The view of display players' final score
	public void endGame(Model_GameManager r) {
		System.out.println("\n" + "\n");
		System.out.println("Game Over");
		System.out.println("\n");
		System.out.println("The overall winner was " + r.getWinner());
		System.out.println("Scores:");
		for (int i = 0; i < r.getPlayers.length; i++) {
			System.out.println(r.getPlayers[i] + ": " + r.getPlayers[i].getScore());
		}
	}
	
	
}
