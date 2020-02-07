package commandline;

import java.util.Scanner;

public class View_UserMenuChoice {
	
	public int userChoiceOfMenu() {
		Scanner scanner = new Scanner(System.in);
		int menuChoice = scanner.nextInt();
		// change to nextline
		scanner.nextLine();
//		scanner.close();
//		cmlController.actionControll(e);
		return menuChoice;
		
	}

}
