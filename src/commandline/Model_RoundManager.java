package commandline;

import java.util.ArrayList;
import java.util.Random;

public class Model_RoundManager {
	
	//Attributes
	
	private int roundCount =1 ; //record the round
	
	private Model_Player roundWinPlayer;
	
	private ArrayList<Model_Card> commonCardPile; //this attribute will store card while a draw round.
	
	private Model_Player activePlayer; // This attribute record the activePlayer who have right to select category at each round
	
	private ArrayList<Model_Player> maxValuePlayerList; // this attribute stores the player who has max value at each round
	
	
	
	public Model_RoundManager() {
		commonCardPile = new ArrayList<Model_Card>();
		maxValuePlayerList = new ArrayList<Model_Player>();
		
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
	
	public ArrayList<Model_Player> getMaxValuePlayerList() {
		return maxValuePlayerList;
	}
	
	
	//Method
	
	// identify the maxValue at first



	public void name() {
		
	}

	public int findMaxCatagoryValue(Model_PlayerManager pm) {
		
		//default user has the max value
		int maxValue = 0;
		
			for (Model_Player player : pm.getPlayers()) {
				if(player.isOut() == false) {

					int tempvalue = player.getOwnedCard().getSelectedCategoryValue();
					if(tempvalue > maxValue)
						maxValue = tempvalue;
					
				}
			}
			
		return maxValue;
	}
	
	
	
	
	public void resetMaxValuePlayerList(Model_PlayerManager pm) {
		
		 //reset the maxValuePlayerList
		 maxValuePlayerList.clear();
		 
		int maxValue = findMaxCatagoryValue(pm);
		
		for (Model_Player player : pm.getPlayers()) {
			if(player.isOut() == false) {
				
				int tempvalue = player.getOwnedCard().getSelectedCategoryValue();
				
				if(maxValue == tempvalue) { //find how many max value,min is 1
					
					maxValuePlayerList.add(player);
				}
				
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
			 
//			 // reset the active player
//			 this.activePlayer = null  ::::fixed error
			 
			 return;
			 
		 }
		 
		 if(isDraw()) {
			 //it is draw
			 if(maxValuePlayerList.contains(pm.getPlayers()[0]) && (pm.getPlayers()[0].isOut() == false)) {
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
		public void selectWinner(Model_GameManager gm) {
			if(isDraw()) {
				roundWinPlayer = null;

				//increase the draw times here, if we cannot find winner
				int drawtimes = gm.getDrawTimes();
				gm.setDrawTimes(++drawtimes);

			}else {
				
				//if it is not draw, means that winner Player is only one in the list
			
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
		
		
		
		
		public boolean winOrOut(Model_PlayerManager pm,Model_GameManager gm) {
			/*
			 * If a player has 40 cards on his pile, the he will win the game. 
			 * Game over, recording game information.
			 * If a player got 0 cards on his pile, then he is out.
			 */
			for (int i = 0; i < pm.getPlayers().length; i++) {
				if (pm.getPlayers()[i].getCardPile().size() == 0) {
					pm.getPlayers()[i].setOut(true);
				
//					if(i == 0) {
//						//this means User lose the game, then set AI who has the most card win the game
//						int maxSize = pm.getPlayers()[1].getCardPile().size(); //assume the first AI has the most cards
//						gm.setWinner(pm.getPlayers()[1]); //assume the first AI win the game
//						//check other AI player
//							for (Model_Player player : pm.getPlayers()) { 
//								if(player.getCardPile().size() > maxSize) {
//									
//									maxSize = player.getCardPile().size();
//									gm.setWinner(player);
//								}
//								
//							}
//					}
				}
				if (pm.getPlayers()[i].getCardPile().size() == 40) {
					
					gm.setWinner(pm.getPlayers()[i]);
					
					return true; //this means this game will end, and User win the game
					
//					endGame();
				}
//				if (i != 0 && players[i].getCardPile().size() == 40) {
//					endGame();
//				}
			}
			roundCount++;
			
			return false;
			
		}
		
		// These three methods below are used to judge the user will be lose game or not
		// They will be actually used in Model_GameManager
		
		public boolean userOut(Model_PlayerManager mp) {
			if (mp.getPlayers()[0].isOut()) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean oneCardLeftAndLose(Model_PlayerManager mp) {
			if (mp.getPlayers()[0].getCardPile().size() == 1 && mp.getPlayers()[0] != roundWinPlayer) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean oneCardLeftAndLoseAgain(Model_PlayerManager mp) {
			if (mp.getPlayers()[0].getCardPile().size() == 0 && mp.getPlayers()[0] != roundWinPlayer) {
				return true;
			}else {
				return false;
			}
		}
		
		
		//This method will be used to write log
		public String commonPileDetails() {
			String output = "";
			
			for (Model_Card card : commonCardPile) {
				
				output += card.cardDetail()+"\n";
			}
			
			return output;
		}
		
		

}
