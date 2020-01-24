package view;

import java.util.Scanner;

import listener.UserChoiceOfMenuListener;

public class View_UserMenuChoice implements UserChoiceOfMenuListener{
	
	@Override
	public int userChoiceOfMenu() {
		Scanner scanner = new Scanner(System.in);
		int menuChoice = scanner.nextInt();
		scanner.close();
		return menuChoice;
	}

}
