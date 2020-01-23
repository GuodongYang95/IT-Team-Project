package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Modle_CardPile {
	// This class will generate the card from the "StarCitizenDeck.txt"
	
	private List<Model_Card> cards; 
	
	//Constructor
	public Modle_CardPile() {
		cards = new ArrayList<Model_Card>();
	}
	
	//Getter and Getter
	public List<Model_Card> getCards() {
		return cards;
	}


	//After testing, this cards will generate 40 cards, and all category will be stored correctly. 
	public void initializeCard(String fileName) {
		File src = new File(fileName);
		//  "./StarCitizenDeck.txt"
		BufferedReader input = null;
		try {
			// extract the first line of the file, these are the category for each card. 
			input = new BufferedReader(new FileReader(src));
			String firstLine = input.readLine();
			//store them into an array
			String[] categoryArray = firstLine.split(" ");// categoryArray[0] is description
			
			//This is used to extract the value from the file through each line
			String valueString = null;
			while((valueString=input.readLine())!=null) {
				//split them in an array; 
				String[] valueArray = valueString.split(" ");
				
				//instant the Model_Card
				Model_Card card = new Model_Card();
				
				for (int i = 0; i < valueArray.length; i++) {
					if(i==0) {
						// when i=0, this is the card description
						card.setDescription(valueArray[0]); //set the card description
					}
					else {
						//when i!=0, it will related to the card category
						String key = categoryArray[i];
						int value = Integer.parseInt(valueArray[i]);
						
						//put key and value to the card map;
						card.giveCategory(key, value);
					}
				}
				
				//add the card into the cardPile Arraylist
				this.cards.add(card);
				
				//reset the valueString for next readline()
				valueString = "";
			}
			
		} catch (Exception e) {
			
			System.out.println("file not found");
			
			
		}
		
	}
}
