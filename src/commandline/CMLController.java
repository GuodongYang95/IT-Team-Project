package commandline;

import java.util.Scanner;




public class CMLController {
	
	private Model_GameManager gm;
	private View_CommandLine view;
	private LogManager logger;
	private boolean logOrNot;
	private DB_Model_Database db;
//	private DB_Model_DbResponce response;
	
	public CMLController(Model_GameManager gm, View_CommandLine view, LogManager logger, boolean logOrNot) {
		
		this.gm = gm;
		this.view = view;
		this.logger = logger;
		this.logOrNot = logOrNot;
		
	}
	
	public boolean getMenuChoice() {
		// if the game is not end by user, it will judge whether the menu should pop up.
		
		// if this method return false, means this game will not end.
		if(gm.isStart() == false) {
			
			view.gameOrStatistics();
			
			int menuChoice = view.getMenuInput().userChoiceOfMenu();
			
			// if user choose 1, then load data
			
				if(menuChoice == 1) {
					gm.viewStatistics();
					//gm.viewStatistics();
//				db.getConn();
//				DB_Model_DbResponce response = db.getDatabaseInfo();				
//				System.out.println("Game Stats!:");
//				System.out.println("Total games played: " + response.getGameCount());
//				System.out.println("Total games users won: " + response.getNumberOfHumanWin());
//				System.out.println("Total games computers won: " + response.getNumberOfAIWin());
//				System.out.println("Average draws per game: " + response.getAverageDraw());
//				System.out.println("Largest Number of rounds in a game: " + response.getMaxRound());
//				System.out.println("\n\n");
//				db.disconnectDB();
				//connect to database
					gm.viewStatistics();
				
					return getMenuChoice();
				
				
				}else if(menuChoice == 2){
				
					// if user input 2, start game
					gm.setGame(true);
					
					view.numOfAi();
					
					int numberOfAI = new Scanner(System.in).nextInt();
					
					gm.whenstart(numberOfAI);
					
					// Log the game or not?
					
					if(logOrNot) {
						
						logger.startGame(gm.getPm().getCardPile(), gm.getPm());
						
						logger.deckReadConstructed(gm.getPm().getCardPile());
					}
				
					// distrubted the card
					gm.getPm().cardDistribute(gm.getRm());
				
					return false;
				
			}else {
				
				//this means user choose 3
				//player exit the game
				return true;
				
				
			}
		}
		else {
		// game is starting 
		return false;
		}
	}
	
	public void startRound() {
		
		if(gm.isStart() == true) {
			
				//tell model and view what to do
				view.roundStart(gm.getRm(), gm.getPm());
				
				//logger
				if(logOrNot) {
					
					logger.roundStart(gm.getRm());
					logger.communalPile(gm.getRm());
				}
				// select active player
				gm.getRm().activePlayerSelector(gm.getPm());
				
				
				// each player will draw the cards
				gm.getPm().playersDrawCard();
				
				if (gm.getRm().userOut(gm.getPm()) == false) {
					view.showUsercard(gm.getRm(), gm.getPm());
				}
				
				
				
				//active player will select category
				view.selectCategory(gm.getRm(), gm.getPm());
				gm.getPm().playersSelectCategory(gm.getRm());
				if(logOrNot) {
					
					logger.cardInPlay(gm.getPm());
					
					logger.selectedCategory(gm.getPm());
				}
	//		 view.selectCategory(gm.getRm(), gm.getPm());
				
				// compare the value and select winner
				
				gm.getRm().resetMaxValuePlayerList(gm.getPm());//find the maxvalue player again
				gm.getRm().selectWinner(gm);
				gm.getPm().distributeCardToWinner(gm.getRm());
				
				view.showResult(gm.getRm());
				if(logOrNot) {
					
					logger.logRoundWinner(gm.getRm());
					logger.playerDeck(gm.getPm());
				}
				
				if(gm.ifWantEndGame()){
					
						return; // return false means the game will not continue
				}
				
				// this will judge that view should show the user is lost or not
				if(gm.getRm().winOrOut(gm.getPm(), gm) == false) { 
					// winOrOut(gm.getPm(), gm) == false means no player win the game (no one has 40 cards)
					if (gm.userHaveLost(gm.getRm(), gm.getPm()) == true) {
						view.youHaveLost();
					}
						return; //return true means the game will continue
						
				}
				else {
						view.endGame(gm.getPm(), gm);
						
						gm.writeDBAfterGame();

						if(logOrNot) {
							
							logger.logWinner(gm);
							logger.closeWriter();
						}
						gm.setGame(false);
						
						return;
					}
					
			}else{
					
				return;
					
		}
		 

		
		
	}

}
