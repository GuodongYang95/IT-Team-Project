package commandline;

import java.util.Scanner;




public class CMLController {
	
	private Model_GameManager gm;
	private View_CommandLine view;
	private LogManager logger;
	private boolean logOrNot;
	
	public CMLController(Model_GameManager gm, View_CommandLine view, LogManager logger, boolean logOrNot) {
		
		this.gm = gm;
		this.view = view;
		this.logger = logger;
		this.logOrNot = logOrNot;
		
	}
	
	public boolean getMenuChoice() {
		view.gameOrStatistics();
		
		int menuChoice = view.getMenuInput().userChoiceOfMenu();
		
		// if user choose 1, then load data
		
		if(menuChoice == 1) {
			
			//connect to database
			
			return false;
			
		}else {
		
			// if user type 2, start game
			
			view.numOfAi();
		
		int numberOfAI = new Scanner(System.in).nextInt();
		
		 gm.whenstart(numberOfAI);
		 
		 if(logOrNot) {
		 
			 logger.startGame(gm.getPm().getCardPile(), gm.getPm());
			 
			 logger.deckReadConstructed(gm.getPm().getCardPile());
		 }
		 
		 // distrubted the card
		  gm.getPm().cardDistribute(gm.getRm());
		  
		 return true;
		 
		}
	}
	
	public boolean startRound() {
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
		 gm.getRm().selectWinner();
		 gm.getPm().distributeCardToWinner(gm.getRm());
		 
		 view.showResult(gm.getRm());
		 if(logOrNot) {
			 
			 logger.logRoundWinner(gm.getRm());
			 logger.playerDeck(gm.getPm());
		 }
		 
		 if(gm.ifWantEndGame()){
			 
			 return false; // return false means the game will not continue, player want game
		 }
		 
		 if(gm.getRm().winOrOut(gm.getPm(), gm) == false) { 
			 	// winOrOut(gm.getPm(), gm) == false means no player win the game (no one has 40 cards)
			 if (gm.userHaveLast(gm.getRm(), gm.getPm()) == true) {
				 view.youHaveLast();
			 }
			 return true; //return true means the game will continue
		 }else {
			 view.endGame(gm.getPm(), gm);
			 if(logOrNot) {
				 
				 logger.logWinner(gm);
				 logger.closeWriter();
			 }
			 return false;
		 }
		 

		
		
	}

}
