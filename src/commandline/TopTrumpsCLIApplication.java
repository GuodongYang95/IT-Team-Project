package commandline;


/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
	public static void main(String[] args) {

		boolean writeGameLogsToFile = false; // Should we write game logs to file?

		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection

		
		//State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		
		View_CommandLine view = new View_CommandLine();
		
		
		Model_GameManager gm = new Model_GameManager();
		
		LogManager logger = new LogManager("toptrumps");
		

		CMLController controller = new CMLController(gm,view,logger,writeGameLogsToFile);
		
		
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {
			
			
			if(controller.getMenuChoice()) {
				userWantsToQuit = true;
			}else {
				userWantsToQuit = false;
			}
			
			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			controller.startRound();
				
				
			
			
			
		}


	}

}
