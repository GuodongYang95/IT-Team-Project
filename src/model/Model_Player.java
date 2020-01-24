package model;

import java.util.ArrayList;
import java.util.Random;


public class Model_Player {
    
	// Player class is the parent of User and AI Class
	
	//Attributes
	
	
    private Model_Card ownedCard; // the Card shown at each round
    
    private String name;
    
    private ArrayList<Model_Card> cardPile; // the card pile each player has.
    
    private int score; // this attribute will record the times that each player win at the game.
    
    private boolean isOut = false; 
    
    
    
    //Getter and Setter
    
    
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Model_Player(String name) {
        
        this.name = name;
    }
	
    public ArrayList<Model_Card> getCardPile() {
    	return cardPile;
    }
    
    public Model_Card getOwnedCard() {
    	return ownedCard;
    }
	
    public String getName() {

        return name;
    }
    
    public int getNumberOfCard() {
        
        return this.cardPile.size();
    }
	
    public String getOwnedCardDescription() {
    	return this.ownedCard.getDescription();
    }
    
    
	//Method



    
//    /**
//     * Returns the Card a Player has at a given index in their array of Cards.
//     * 
//     * @param index, int
//     * @return the Card at that index
//     */
//    public Card getCardAtIndex(int index) {      
//        return this.hand[index];
//    }
    
    
    /**
     * Adds a given card to the end of a players hand.
     * 
     * @param newCard 
     */
//    public void giveCard(Card newCard) {
//        
//        Card[] newHand = new Card[this.hand.+1];
//        
//        for (int i = 0; i < hand.length; i++) {
//            
//            newHand[i] = this.hand[i];
//        }
//        
//        newHand[hand.length] = newCard;
//        
//        this.hand = newHand;
//    }
//    

	/**
     * Removes the first card from a player's hand and returns it.
     * 
     * modified -- Ken
     * 	Pick a card from Player Pile
     * 
     * @return Card, takenCard
     */
    public Model_Card pickCard() {
    	if(isOut == false) {
    	
    	int randomCard = new Random().nextInt(cardPile.size());
    	//Get the random card
    	Model_Card pickedCard = cardPile.get(randomCard);
    	
	    	//the card showing.
	    	this.ownedCard = pickedCard;
    	//remove the card if it is picked
    	cardPile.remove(randomCard);
    	return pickedCard;  //The reason why return this card is to show it when in online mode.
    	}
    	else {
    		return null;
    	}
    }
    
    /**
     * Returns the Player's top card, without removing that card from 
     * the ones they hold
     * 
     * @return the top Card
     */
//    public Card viewTopCard() {
//        
//        return this.hand[0];
//    }
    public void setOut(boolean outOrNot) {
    	isOut = outOrNot;
    }
    public boolean isOut() {
    	return isOut;
    }
    
    // This method will let Player selected the Category which is decided by active Player.
    
	public void selectCategory(String selectedCategory){
		
		Model_Card ownedCard = this.pickCard();
		ownedCard.setSelectedCategoryName(selectedCategory);
	
	}
    
}