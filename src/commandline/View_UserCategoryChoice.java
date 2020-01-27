package commandline;



import java.util.Scanner;

import listener.CMLEvent;
import listener.UserChoiceofSelectingListener;

public class View_UserCategoryChoice{

//	@Override
	public int userChoiceofSelectingCategoryListener() {
		Scanner scanner = new Scanner(System.in);
		int categoryChoice = scanner.nextInt();
		// change to nextline
		scanner.nextLine();
		scanner.close();
//		cmlController.actionControll(e);
		return categoryChoice;
	}

	
}
