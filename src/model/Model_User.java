package model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Model_User extends Model_Player{

	public Model_User(String name) {
		super(name);
	}
	
	
	
	// this selectedNumber is something like the id of each the category;
	//User can select a catagory
	public String selectCategory(int selectedNumber){
		
		// Get all category set of owned card
		LinkedHashMap<String, Integer> ownedCardCategores = this.getOwnedCard().getCategores();
		
		  String selectedCategory = "";
		  
		  for(int i = 0; i< selectedNumber; i++) {
			  
			  Map.Entry<String, Integer> entry = (Entry<String, Integer>) ownedCardCategores.entrySet();
			  
			  selectedCategory = entry.getKey();
		  }
		
		  this.getOwnedCard().setSelectedCategoryName(selectedCategory);
		
		return selectedCategory;
		
	
	}

}
