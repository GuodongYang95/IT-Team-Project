package model;

import java.util.ArrayList;
import java.util.Random;

public class Model_RoundManager {
	
	//Attributes
	
	private int roundCount; //record the round
	
	private Model_Player roundWinPlayer;
	
	private ArrayList<Model_Card> commonCardPile; //this attribute will store card while a draw round.
	
	private Model_Player activePlayer; // This attribute record the activePlayer who have right to select category at each round
	
	private ArrayList<Model_Player> maxValuePlayerList; // this attribute stores the player who has max value at each round
	
	
	
	public Model_RoundManager() {
		
	}
	
	
	// getter and setter
	
	public ArrayList<Model_Card> getCommonCardPile() {
		return commonCardPile;
	}

	public void setCommonCardPile(ArrayList<Model_Card> commonCardPile) {
		this.commonCardPile = commonCardPile;
	}
	
	public Model_Player getRoundWinPlayer() {
		return roundWinPlayer;
	}
	
	public int getRoundCount() {
		return roundCount;
	}
	
	public Model_Player getActivePlayer() {
		return activePlayer;
	}
	
	public void setActivePlayer(Model_Player activePlayer) {
		this.activePlayer = activePlayer;
	}
	
	
	
	//Method
	
	// identify the maxValue at first



	public int findMaxCatagoryValue(Model_PlayerManager pm) {
		
		//default user has the max value
		int maxValue = pm.getPlayers()[0].getOwnedCard().getSelectedCategoryValue();
		
			for (Model_Player player : pm.getPlayers()) {
				int tempvalue = player.getOwnedCard().getSelectedCategoryValue();
				if(tempvalue > maxValue)
					maxValue = tempvalue;
			}
			
		return maxValue;
	}
	
	
	
	
	public void hasMaxValuePlayerList(Model_PlayerManager pm) {
		
		int maxValue = findMaxCatagoryValue(pm);
		
		for (Model_Player player : pm.getPlayers()) {
			
			int tempvalue = player.getOwnedCard().getSelectedCategoryValue();
			
			if(maxValue == tempvalue) { //find how many max value,min is 1
				
				maxValuePlayerList.add(player);
			}
		}
	}
	
	
	 public boolean isDraw() {
		 
		 	if(maxValuePlayerList.size() >1) {
				//it is draw
			 	return true;
			 	
			}
			else { // it is not draw, so there is only one player in the list
				return false;
			}
	 }
	 
	 
	 
	 public void activePlayerSelector(Model_PlayerManager pm) {
		 //if it is first time, the system will randomly select a player to be active
		 if(roundCount==1) {
			 int ramdomNumber = new Random().nextInt(pm.getPlayers().length);
			 
			 this.activePlayer = pm.getPlayers()[ramdomNumber];
			 
		 }
		 
		 if(isDraw()) {
			 //it is draw
			 if(maxValuePlayerList.contains(pm.getPlayers()[0])) {
				 // if user is included
				 activePlayer = pm.getPlayers()[0];
			 }else {
				 //randomly select an ai in the maxlist
				 int randomNumber = new Random().nextInt(maxValuePlayerList.size());
				 
				 activePlayer = maxValuePlayerList.get(randomNumber);
			 }
		 }
		 else { 
			 // it is not draw, so set the winner active
			 activePlayer = roundWinPlayer;
		 }
		 
	 }
	 
	 
	 
	 
		// this method is going to find winner for each round
		public void selectWinner() {
			if(isDraw()) {
				roundWinPlayer = null;
			}else {
				
				//if it is not draw, means that winner Player in the list
				roundWinPlayer = maxValuePlayerList.get(0);
				
				// add one score to the winner
				//get the score first
				int winnerscore = roundWinPlayer.getScore();
				//increase the score
				winnerscore++;
				//set the score to the player
				roundWinPlayer.setScore(winnerscore);
			}
			
		}
		
		
		
		
		public void winOrOut(Model_PlayerManager pm,Model_GameManager gm) {
			/*
			 * If a player has 40 cards on his pile, the he will win the game. 
			 * Game over, recording game information.
			 * If a player got 0 cards on his pile, then he is out.
			 */
			for (int i = 0; i < pm.getPlayers().length; i++) {
				if (pm.getPlayers()[i].getCardPile().size() == 0) {
					pm.getPlayers()[i].setOut(true);
				}
				if (i == 0 && pm.getPlayers()[i].getCardPile().size() == 40) {
					
					gm.setWinner(pm.getPlayers()[i]);
//					endGame();
				}
//				if (i != 0 && players[i].getCardPile().size() == 40) {
//					endGame();
//				}
			}
			
		}

}
