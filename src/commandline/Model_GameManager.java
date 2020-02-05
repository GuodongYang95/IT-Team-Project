package commandline;


import java.util.Scanner;


public class Model_GameManager {
	
	//Attrivutes
	
	private int drawTimes; //record how many times of draw happened during a game.
	
	private Model_Player winner; // this is the overall game winner
	private Model_PlayerManager pm;
	private Model_RoundManager rm;
	private boolean flag = false; // this will be used to judge whether the user lose the game, and display user lose the game.
	private boolean gameStarting = false; // judge whether the game should be continuing
	
	public void whenstart(int numberOfAI) {
		
		pm = new Model_PlayerManager(numberOfAI);
		rm = new Model_RoundManager();
		
		
	}
	
	
	// if user wants to end game, they can use ESC
	public boolean ifWantEndGame() {
		System.out.println("if you want to end game, please input \"Exit\", the winner will be the player who has the most cards");
		System.out.println("if you want to continue, please press enter");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if(userInput.equals("Exit")) {
//			// end game, looking for the winner who has the most cards
//			int maxSize = pm.getPlayers()[0].getCardPile().size(); //assume the first Player has the most cards
//			winner = pm.getPlayers()[0]; //assume the first Player win the game
//			//check other player
//				for (Model_Player player : pm.getPlayers()) { 
//					if(player.getCardPile().size() > maxSize) {
//						
//						maxSize = player.getCardPile().size();
//						winner = player;
//						
//					}
//					
//				}
//			// game over menu!!!!!
			gameStarting = false;
				return true;
		}else {
			gameStarting = true;
			return false;
		}
	}
	
	public boolean userHaveLost(Model_RoundManager mr, Model_PlayerManager mp) {
		if (mr.oneCardLeftAndLose(mp) == true) {
			flag = true;
			return false;
		}
		if (flag == true) {
			if(mr.oneCardLeftAndLoseAgain(mp) == true) {
				flag = false;
				return true;
			}
		}
		flag = false;
		return false;
	}
	
	
	// getter and setter

	public void setWinner(Model_Player winner) {
		this.winner = winner;
	}
	
	
	
	public int getDrawTimes() {
		return drawTimes;
	}
	
	
	
	public void setDrawTimes(int drawTimes) {
		this.drawTimes = drawTimes;
	}
	
	
	
	public Model_Player getWinner() {
		return winner;
	}
	
	
	
	public Model_PlayerManager getPm() {
		return pm;
	}
	
	
	
	
	public Model_RoundManager getRm() {
		return rm;
	}


	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public boolean isStart() {
		return gameStarting;
	}
	
	public void setGame( boolean startOrEnd) {
		this.gameStarting = startOrEnd;
	}
	
	// ::::::::::::::::::::: the codes below has been deleted........
//	
//	//Methods
//	
////	public void startGame(CMLController controller) {
//		/*
//		 * This method  will create the AI and user players.
//		 * The user will be stored in player[0] and the AI players will be stored in player[] 
//		 * from player[1] to player[numOfAI] with their names
//		 * Then initialize roundCount, drawTimes and userWin.
//		 * Distribute cards to every player.
//		 */
////		
////		int choice = gameOrStatistics(); 
////		if (choice == 1) {
////			statistics(db);
////		}
////		if (choice == 2) {
////			System.out.println("How many AI do you want to play with?");
////			Scanner s = new Scanner(System.in);
////			int numOfAI = s.nextInt();
////			s.close();
////			
////			
////			// Create the Player Group:
////			players = new Model_Player[numOfAI+1];
////			players[0] = new Model_User("YOU");
////			
////			for (int i = 1; i <= numOfAI; i++) {
////				String aIName = "AI" + i;
////				players[i] = new Model_AI(aIName);
////			}
////			
////			//initialize the gameData at the start of the game
////			
////			roundCount = 1;
////			drawTimes = 0;
////			userWin = false;
////			
////			//Distribute the card to each Player(User and AI)
////			cardDistribute(db);
////			
////			//Active one player at first round
////			activePlayerSelector();
////		}
//		
////	}
//
//
////	public int gameOrStatistics() {
////		System.out.println("Do you want to see past results of play a game?");
////		System.out.println("1. Print Game Statistics");
////		System.out.println("2. Play game");
////		Scanner s = new Scanner(System.in);
////		int userChoice = s.nextInt();
////		System.out.println("Enter the number for your selection:" + userChoice);
////		s.close();// it should be closed at the end
////		return userChoice;
////	}
////	
//	// Get history record method
////	public void statistics(DBConnected db) {
////		System.out.println("Number of Games: " + numOfGames);
////		System.out.println("Number of Human Wins: " + db.getNumOfHumanWins());
////		System.out.println("Number of AI Wins: " + db.getNumOfAIWins());
////		System.out.println("Average number of Draws: " + db.getAvgNumOfDraws());
////		System.out.println("Longest Game: " + roundCount);
////		
////	}
//	
//	
//		
//	//-----------------------these function will be used in each round----------------------------------
//	//-------------------------------when a round start---------------------draw card, select category--------
////	public void roundStart() {
////		//increase the roundcount
////		this.roundCount++;
////		System.out.println("Round "+roundCount);
////		
////		//each user should randomly picked a card;
////		for (Model_Player player : players) {
////			player.takeCard();
////		}
////		
////		System.out.println("You drew "+"\""+players[0].getHandCardDescription()+"\"");
////		
////		// this will display the card property by using toString method in Card class
////		System.out.println(players[0].getHand());
////		
////		System.out.println("There are '"+players[0].getNumberOfCard()+" in your deck");
////	
////		//	This part can decide who have right to choose the category
////		//----------------------------
////			//when the user is active
////		if(players[0].isActive()) {
////			
////			System.out.println("It is your turn to select a category, the categories are:");
////				
////			  //System.out.println("Enter the number for your attribute: "); this should put in the selectCategory() function.
////			
////			//should display the card here!!!!!!!!!!! method needed!!!---------------
////			
////			String string = new Model_User("user").selectCategory(); 
////			
////			players[0].setActive(false); //if player have chance to select, set false after selecting
////			
////			players[0].getHand().setSelectedAttributeString(string);
////			
////			// Other Player should select the category automatically
////			for(int i =0; i<players.length; i++) {
////					players[i].selectCategory(string);
////				}
////			
////			
////		}
////		else {
////			//when the user is not active
////			
////			String aISelectedAttribute = "";
////			//find the active AI and let it select category
////			for (Model_Player player : players) {
////				if(player.isActive()) {
////					aISelectedAttribute = new Model_AI("ai").selectCategory();//AI will choose the biggest value
////					
////					player.setActive(false); // set false after selecting
////				}
////			}
////			// set it to all player
////			for (Model_Player player : players) {
////				player.getHand().setSelectedAttributeString(aISelectedAttribute);
////				
////			}
////			
////		}
////		//--------------------------------- round start -------------
////		
////	}
//	
//	//-------------------------------when a round got to end---------------------
//	//--------------------------------- find winner or it is draw, distribute card -------------
////	public void showRoundResult() {
////		//find the winner:
////		int maxValue = findMaxCatagoryValue();
////		
////		ArrayList<Model_Player> maxValuePlayerList = hasMaxValuePlayerList(maxValue);
////		
////		selectWinner(maxValuePlayerList);
////		
////		// active the player for next round
////		
////		activePlayerSelector(maxValuePlayerList);
////		
////		
////		// distribute the card
////		distributeCardToWinner(maxValuePlayerList);
//		
//		//Judge a layer should be out  or the game should over
//		
//		
////	}
//
//	//-------------------------ending Game-------------------------
//	
////	public void infoRecord(DBConnected db) {
////		/*
////		 * This method will store information including roundCount, 
////		 * drawTimes and userWin to the DBConnected instance.
////		 */
////		for (int i = 0; i < players.length; i++) {
////			System.out.println(players[i].getName() + " : " + players[i].getScore());
////		}
////		
////	}
////	
////	
////	public void endGame(Model_Player p, DBConnected db) {
////		numOfGames++;
////		System.out.println("Game Over");
////		System.out.println("The overall winnder was " + p);
////		System.out.println("Scores: ");
////	
////		infoRecord(db);
////		int choice = gameOrStatistics();
////		if (choice == 1) {
////			statistics();
////		}
////		if (choice == 2) {
////			startGame(db);
////		}
////		
////	}
	
	
	
	
	
}
