package commandline;

import java.util.ArrayList;

/**
 * This attribute will be used to store the card 
 * gotten from GameManager
 */
public class CardPile {
	
//	private Card[] cards; // The card that we generated in the Database
	
//	public CardPile () {
//		
//		this.cards = new Card[0];
//	}
	
}

//    /**
//     * Get the size of pile
//     */
//    public int getPileSize() {
//        
//        return this.cards.length;
//    }
//    
//    /**
//     * Adds a given card to the end of a players hand.
//     */
//    public void giveCard(Card newCard) {
//        
//        Card[] newHand = new Card[this.cards.length+1];
//        
//        for (int i = 0; i < cards.length; i++) {
//            newHand[i] = this.cards[i];
//        }
//        
//        newHand[cards.length] = newCard;
//        
//        this.cards = newHand;
//    }
//    
//    /**
//     * Removes the first card from a player's hand and returns it.
//     */
//    public Card takeCard() {
//        
//        Card takenCard = this.cards[0];        
//        Card[] newHand = new Card[this.cards.length-1];
//        
//        for (int i = 0; i < newHand.length; i++) {
//            
//            newHand[i] = this.cards[i+1];
//        }
//        this.cards = newHand;
//        
//        return takenCard;
//    }    
//    
//    /**
//     * Returns the Card at a given index.
//     */
//    public Card getCardAtIndex(int index) {
//        
//        return this.cards[index];
//    }
//}