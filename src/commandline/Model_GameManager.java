package commandline;


import java.util.Scanner;



public class Model_GameManager {
	
	//Attrivutes
	
	private int drawTimes; //record how many times of draw happened during a game.
	
	private Model_Player winner; // this is the overall game winner
	private Model_PlayerManager pm;
	private Model_RoundManager rm;
	
	private DB_Model_Database db;
//	private DB_GameStat stats;
//	private Model_Player[] players;

	
	private boolean flag = false; // this will be used to judge whether the user lose the game, and display user lose the game.
	private boolean gameStarting = false; // judge whether the game should be continuing

	
	public void whenstart(int numberOfAI) {
		
		pm = new Model_PlayerManager(numberOfAI);
		rm = new Model_RoundManager();
		db= new DB_Model_Database();

//		pm.cardDistribute(rm);


	}
	
	
	// if user wants to end game, they can use ESC
	public boolean ifWantEndGame() {
		System.out.println("if you want to end game, please input \"Exit\", the winner will be the player who has the most cards");
		System.out.println("if you want to continue, please press enter");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if(userInput.equals("Exit")) {

			gameStarting = false;
				return true;
		}else {
			gameStarting = true;
			return false;
		}
	}
	
	public void viewStatistics() {


		DB_Model_Database database=new DB_Model_Database();
		System.out.println("\n" + "\n");
		System.out.println("Game Statistics:");
		System.out.println("Number of Games: " + database.getGameCount());
		System.out.println("Total games users won: " + database.getNumberOfHumanWin());
		System.out.println("Total games computers won: " + database.getNumberOfAIWin());
		System.out.println("Average draws per game: " + database.getAverageDraw());
		System.out.println("Largest Number of rounds in a game: " + database.getMaxRound());
		System.out.println("\n\n");

	}

	public void writeDBAfterGame() {
		// Game is over
		
//		stats.setWinner(getWinner());
			DB_GameStat stats= new DB_GameStat(pm, rm, this);
		try {
			db.CreateTable();
			db.insertInDB(stats);

			System.out.println("Successful to write to database.");

		} catch(Exception e) {
			System.out.println("Unable to write to database.");
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


	
	public boolean isStart() {
		return gameStarting;
	}
	
	public void setGame( boolean startOrEnd) {
		this.gameStarting = startOrEnd;
	}
	
	
	
	
	
	
}
