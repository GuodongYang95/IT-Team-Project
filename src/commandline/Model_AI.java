package commandline;

import java.util.LinkedHashMap;
import java.util.Map;



public class Model_AI extends Model_Player{

	public Model_AI(String name) {
		super(name);
	}
	
	
	// AI will select the biggest vaule of each category
	
	public String selectCategory(){
		// Get all category set of owned card
		LinkedHashMap<String, Integer> ownedCardCategores = this.getOwnedCard().getCategores();
		
		
    	int maxValue = 0;
    	String selectedCategory = ""; // need to find the category name which has max value
    		
    		//check each key (each category) orderly
    		for (String key : ownedCardCategores.keySet()) {
    			
    			if(ownedCardCategores.get(key) >= maxValue) {
    				
    				maxValue = ownedCardCategores.get(key);
    				
    				selectedCategory = key;
    				
    			}
    		}
    	// After for loop, the category name of Max Value has been found
    		//assign it to the ownedCard attributes(selectedCategoryName)
    	this.getOwnedCard().setSelectedCategoryName(selectedCategory);
    	
    	return selectedCategory;
	}
	
}
