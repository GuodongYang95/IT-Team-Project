	import java.sql.DriverManager;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;


	public class PostDBcon {
		public static void main(String args[]) {
			// load the JDBC driver
			Connection connection = null;
			Statement statement =null;
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find JDBC Driver");
				e.printStackTrace();
				return;
			} // try-catch exception
				// the driver is loaded...
			System.out.println("PostgreSQL JDBC Driver found!");
			// proceed with a database connection
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ITproject", "postgres",
						"postgres123");
				System.out.println("Connection Successed!");
			} catch (SQLException e) {
				System.out.println("Connection Failed!");
				e.printStackTrace();
				return;
			} // try-catch exception
				// connection to the database is done!
			
			try {
				statement = connection.createStatement();
		        String sql = "CREATE TABLE GameInformation " + 
		                     "(GameCount       INT PRIMARY KEY     NOT NULL ," + 
		                     " MaxRound        INT    , " + 
		                     " AverageDraw     INT    , " + 
		                     " NumberOfAIWin   INT    , " +
		                     " NumberOfHumanWin INT   , " +
		                     " Cards           INT )"; 
		        statement.executeUpdate(sql); 
		        System.out.println("Table created successfully");
				statement.close();
				connection.close();

			} catch (SQLException e) {		
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		}
	}

