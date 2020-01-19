package commandline;

import java.util.Scanner;

public class User extends Player{

	public User(String name) {
		super(name);
	}
	
	
	//User can select a catagory
	public String selectCategory(){
		Scanner scanner = new Scanner(System.in);
		String selectedCategory = scanner.next();
		
		Card handCard = this.getHand();
		
		handCard.setSelectedAttributeString(selectedCategory);
		return selectedCategory;
		
	
	}

}
