package commandline;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JButton;

import model.*;
import listener.*;
import controller.*;

import com.sun.javafx.collections.MappingChange.Map;

public class View_CommandLine {
	
	private View_UserCategoryChoice categoryChoice;
	private View_UserMenuChoice menuInput;
	
	
//	private CMLController cmlController;
	
	public View_CommandLine( ) {
		categoryChoice = new View_UserCategoryChoice();
		menuInput = new View_UserMenuChoice();

	}
	
	public View_UserCategoryChoice getCategoryChoice() {
		return categoryChoice;
	}


	public View_UserMenuChoice getMenuInput() {
		return menuInput;
	}


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
		System.out.println("Number of AI Wins: " + db.getNumOfAIWins());
		System.out.println("Average number of Draws: " +db.getAverageNumOfDraws());
		System.out.println("Longest Game: " +db.getLongetGame());
	}
	
	//The view of the round started
	public void roundStart(Model_RoundManager r, Model_PlayerManager p) {
		System.out.println("\n" + "\n");
		if (r.getRoundCount() == 1) {
			System.out.println("Game Start");
		}
//		else {
			System.out.println("Round " + r.getRoundCount());
			System.out.println("Round " + r.getRoundCount() + ": " + "Players have drawn their cards");
	}
	public void showUsercard(Model_RoundManager r, Model_PlayerManager p) {
		
	
			System.out.println("You drew " + "'" + p.getPlayers()[0].getOwnedCard().getDescription() + "'" + " :");
			System.out.println(p.getPlayers()[0].getOwnedCard()); 
			System.out.println("There are '" + p.getPlayers()[0].getNumberOfCard() + " cards in your deck");
//		}
	}
	
	//The view of game results 
	
	//User selectCategory
	public void selectCategory(Model_RoundManager r, Model_PlayerManager p) {
		LinkedHashMap<String, Integer> hm = p.getPlayers()[0].getOwnedCard().getCategores();
//		Iterator hmIterator = hm.entrySet().iterator();
		if (r.getActivePlayer() == p.getPlayers()[0]) {
			System.out.println("It is your turn to select a category, the categories are:");
//			while(hmIterator.hasNext()) {
//				int number = 1;
//				String c = (String)hmIterator.next();
//				System.out.println(number + ": " + c);
//				number++;
//			}
	    	 String outcome = "";
	    	 int i = 1;
	    	 
	    	 for (String key : hm.keySet()) {
	             
	             outcome += i+ ":" + key + "\n";
	             i++;
	         }
	    	 
	    	 System.out.println(outcome);
	    	
	    
			
			System.out.println("Enter the number for your attribute: ");
		}else {
			return;
		}
	}
	 public void showResult(Model_RoundManager r){
		 if(r.isDraw() == false){
			 
			 System.out.println("Round " + r.getRoundCount() + ": " + "Player " + r.getRoundWinPlayer().getName() + " won this round");
			 System.out.println("The winner card was '" + r.getRoundWinPlayer().getOwnedCard().getDescription() + "':");
			 displayWinnerCard(r.getRoundWinPlayer().getOwnedCard());
		 }else {
			 System.out.println("This round was a Draw, common pile now has " + r.getCommonCardPile().size() +" cards");
			 System.out.println("the winning card is");
			 displayWinnerCard(r.getMaxValuePlayerList().get(0).getOwnedCard());
		 }
		 
	 }	
//		 System.out.println("Round " + r.getRoundCount() + ": " + "Player " + r.getWinnerName() + " won this round");
//		 p.getWinnerCardDisplay();
	 
		 
	 
	//The view of display players' final score
	public void endGame(Model_PlayerManager pm,Model_GameManager gm) {
		System.out.println("\n" + "\n");
		System.out.println("Game Over");
		System.out.println("\n");
		System.out.println("The overall winner was " + gm.getWinner());
		System.out.println("Scores:");
		for (int i = 0; i < pm.getPlayers().length; i++) {
			
			System.out.println(pm.getPlayers()[i].getName() + ": " + pm.getPlayers()[i].getScore());
		}
	}
	
	public void displayWinnerCard(Model_Card winnercard) {
		LinkedHashMap<String, Integer> winnerCardCategories = winnercard.getCategores();
		String output = "";
   	 	for (String key : winnerCardCategories.keySet()) {
		 
         int value = winnerCardCategories.get(key);
         
         output += "> "+ key + ": " + value; 
         if(winnercard.getSelectedCategoryName() == key) {
        	 output += " <--\n";
         }else {
        	 output += "\n";
         }
     }
   	 	System.out.println(output);
	}


	
}
