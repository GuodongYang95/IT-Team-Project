package commandline;

import java.util.ArrayList;
import java.util.Random;

import org.omg.PortableInterceptor.ACTIVE;

public class Player {
    
	// Player class instance will present User or AI
	
	
    private Card hand; // the Card shown at each round
    private String name;
    
    private boolean active; // if a player is active, it means that he has chance to select a compared attribute
    
    private ArrayList<Card> cardPile; // the card pile each player has.
    
    private int score; // this attribute will record the times that each player win at the game.
    private boolean isOut = false; 
    
    
    public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player(String name) {
        
        this.name = name;
//        this.active = true;
    }

    /**
     * get the card array list
     * 
     * @return cardPile
     */

    public ArrayList<Card> getCardPile() {
    	return cardPile;
    }
    
    public Card getHand() {
    	return hand;
    }

	/**
     * The name of the Player.
     */
    public String getName() {

        return name;
    }
    
    /**
     * The number of Cards the Player has.
     */
    public int getNumberOfCard() {
        
        return this.cardPile.size();
    }
    
    /**
     * This method will tell user which Card is picked
     */
    public String getHandCardDescription() {
    	return this.hand.getDescribution();
    }
    /**
     * Return the player whether is active or not
   	 */
    public boolean isActive() {

        return active;
    }

    /**
     * Sets whether the Player is still in a game.
     */
    public void setActive(boolean active) {

        this.active = active;
    }
    
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
    public Card takeCard() {
        
//        Card takenCard = this.hand[0];        
//        Card[] newHand = new Card[this.hand.length-1];
//        
//        for (int i = 0; i < newHand.length; i++) {
//            
//            newHand[i] = this.hand[i+1];
//            
//        }
//        this.hand = newHand;
//        
//        if (this.getHandSize() == 0) {
//            
//            this.active = false;
//        }      
//        return takenCard;
    	
    	int randomCard = new Random().nextInt(cardPile.size());
    	//Get the random card
    	Card pickedCard = cardPile.get(randomCard);
    	
	    	//the card showing.
	    	this.hand = pickedCard;
    	//remove the card if it is picked
    	cardPile.remove(randomCard);
    	return pickedCard;  //The reason why return this card is to show it when in online mode.
    	
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
		
		Card handCard = this.getHand();
		handCard.setSelectedAttributeString(selectedCategory);
	
	}
    
}