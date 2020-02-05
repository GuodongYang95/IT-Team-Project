package commandline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import commandline.Model_AI;
import commandline.Model_Player;
import commandline.Model_User;
 
public class Model_Database {
	private Connection conn = null;
	private Statement stmt = null;
	/**
	 * @method getConn() 
	 * @return Connection
	 */
	public Connection getConn() {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/ITPproject";
		String username = "postgres";
		String password = "postgres123";
		//

		try {
			Class.forName(driver); // classLoader
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if (conn != null) {
			System.out.println("Successfully connected to database.");
		} else {
			System.out.println("Failed to connect to database.");
		}
		return conn;
	}

	/**
	 * disconnect severs with database
	 */
	public void disconnectDB() {
		try {
			conn.close();

		} catch (Exception e) {
			System.out.println("You could not disconnect the database.");
			//e.printStackTrace();
		}
	}

	/**
	 * create the table in the database
	 */
	public void CreateTable() {
		Connection connection=getConn();
		try {
			stmt = connection.createStatement();
	        String sql = "CREATE TABLE GameInfo " + 
	                     "(GameID       INT PRIMARY KEY     NOT NULL ," + 
	                     " NumberOfRound  INT    , " + 
	                     " GameWinner     INT    , " + 
	                     " NumberOfDraw   INT    , " +
	                     " p1Rounds int, " + " p2Rounds int, " +
	                     " p3Rounds int, " + " p4Rounds int, " +
	                     " p5Rounds int)"; 
	        stmt.executeUpdate(sql); 
	        System.out.println("Table created successfully");
			stmt.close();
		} catch (SQLException e) {		
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Writes to the database the number of draws, who won the game, number of
	 * rounds in the game and how many rounds each player won.
	 *
	 * @param stats This object holds the statistics of a game of Top Trumps which
	 *              has completed.
	 */

	public void inputGameStat(Model_GameStat gstats) {
		Model_Player[] players = gstats.getPlayerArray();
		Model_Player winner = gstats.getWinner();
		
		// gamestats will be added to database per game, and the first gameID is 1 in database 
		int gameID = getGameCount() + 1; 
		int nDraws = gstats.getNumOfDraws(); // number of draws in the game
		int nRounds = gstats.getNumOfRounds(); // number of rounds in the game
		int gWinner = 0; // gWinner This parameter is responsible for indicating which player win. 
						// if gWinner equal 1 means the human win, other number means AI win
		int p1RW = players[0].getScore(); // rounds won per player
		int p2RW = players[1].getScore();
		int p3RW = players[2].getScore();
		int p4RW = players[3].getScore();
		int p5RW = players[4].getScore();
		if (winner instanceof Model_User) {
			gWinner = 1;
		} else if (winner instanceof Model_AI) {
			if (winner == players[1]) {
				gWinner = 2;
			} else if (winner == players[2]) {
				gWinner = 3;
			} else if (winner == players[3]) {
				gWinner = 4;
			} else if (winner == players[4]) {
				gWinner = 5;
			}
		}
		String gameStats = "INSERT INTO GameInfo VALUES (" + gameID + ", " + nDraws + ", " + nRounds + ", " + gWinner + ", "
				+ p1RW + ", " + p2RW + ", " + p3RW + ", " + p4RW + ", " + p5RW + ");";

		insertInfo(gameStats);
	}
	
	/**
	 * take game information from the method writeGameStatistics() and uses
	 * the methods of string to insert game info into the database
	 * @param info
	 */
	public void insertInfo(String info) {

		if (conn != null) {
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(info);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Postsql: Queries database to count the number of games played.
	 * 
	 * @return total number of games played
	 */
	public int getGameCount() {
		Statement stmt = null;
		String sql = "Select Count(GameID) as totalCount From GameInfo";
		int totalGamesPlayed = 0;

		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(sql);
			while (results.next()) {
				totalGamesPlayed = results.getInt("totalCount");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalGamesPlayed;

	}

	/**
	 * Postsql: Queries database to get number of AI wins.
	 * 
	 * @return total number of games played
	 */
	public int getNumberOfAIWin() {
		Statement stmt = null;
		String sql = "Select Count(GameWinner) as AIWins From GameInfo Where GameWinner > 1 ";
		int getNumberOfAIWin = 0;

		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(sql);
			while (results.next()) {
				getNumberOfAIWin = results.getInt("AIWins");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getNumberOfAIWin;

	}

	/**
	 * Postsql: Queries database to get number of human wins.
	 * 
	 * @return total number of games played
	 */
	public int getNumberOfHumanWin() {
		Statement stmt = null;
		String sql = "SELECT COUNT(GameWinner) as humanWins FROM GameInfo WHERE GameWinner = 1 ";
		int NumberOfHumanWin = 0;

		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(sql);
			while (results.next()) {
				NumberOfHumanWin = results.getInt("humanWins");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return NumberOfHumanWin;

	}

	/**
	 * PostSql:Queries database to get average draws per game.
	 * 
	 * @return total number of games played
	 */
	public int getAverageDraw() {
		Statement stmt = null;
		String sql = "SELECT AVG(NumberOfDraw) as avgDraws FROM GameInfo ";
		int averageDraws = 0;

		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(sql);
			while (results.next()) {
				averageDraws = results.getInt("avgDraws");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return averageDraws;

	}

	/**
	 * PostSql: Queries database to get max number of rounds played in a game.
	 * 
	 * @return total number of games played
	 */
	public int getMaxRound() {
		Statement stmt = null;
		String sql = "SELECT MAX(NumberOfRound) as maxRounds FROM Gameinfo ";
		int getMaxRound = 0;

		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(sql);
			while (results.next()) {
				getMaxRound = results.getInt("maxTotalRounds");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getMaxRound;

	}

	/**
	 * Creates an object containing information about games which stored in
	 * the database these are then used by views to display this data to the user.
	 *
	 * @return contains overall statistics over all the games played.
	 */
	public Model_DbResponce getDatabaseInfo() {
		Model_DbResponce ginfo = new Model_DbResponce();
		
		int totalGameCount = 0;
		int totalAIWins = 0;
		int totalHumanWins = 0;
		int averageDraws= 0;
		int maxRound = 0;
		
		try {
		totalGameCount = getGameCount();
		totalAIWins = getNumberOfAIWin();
		totalHumanWins = getNumberOfHumanWin();
		averageDraws= getAverageDraw();
		maxRound = getMaxRound();
		} catch(Exception e) {
			System.out.println("Unable to get statistics from Database, default 0 values returned.\n\n");
		}
		ginfo.setGameCount(totalGameCount);;
		ginfo.setNumberOfAIWin(totalAIWins);
		ginfo.setNumberOfHumanWin(totalHumanWins);
		ginfo.setAverageDraw(averageDraws);
		ginfo.setMaxRound(maxRound);

		return ginfo;

	}

	}

