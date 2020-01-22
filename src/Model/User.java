package Model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class User extends Player{

	public User(String name) {
		super(name);
	}
	
	
	//User can select a catagory
	public String selectCategory(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number for your attribute: ");
		int selectedNumber = scanner.nextInt();
		// this selectedNumber is something like the id of each the category;
		Card handCard = this.getHand();
		
		LinkedHashMap<String, Integer> categoryMap = handCard.getClassAttribute();
		  String selectedCategory = "";
		  for(int i = 0; i< selectedNumber; i++) {
			  Map.Entry<String, Integer> entry = (Entry<String, Integer>) categoryMap.entrySet();
			  selectedCategory = entry.getKey();
		  }
		
		handCard.setSelectedAttributeString(selectedCategory);
		
		return selectedCategory;
		
	
	}

}
