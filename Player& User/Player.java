package commandline;


public class Player {
    
    private Card[] hand; // All of the cards held by a player
    private String name;
    private boolean active;
    
    public Player(String name) {
        
        this.name = name;
        this.hand = new Card[0];
        this.active = true;
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
    public int getHandSize() {
        
        return this.hand.length;
    }

    /**
     * Return the player whether is active or not
   	 */
    public boolean isactive() {

        return active;
    }

    /**
     * Sets whether the Player is still in a game.
     */
    public void setactive(boolean active) {

        this.active = active;
    }
    
    /**
     * Returns the Card a Player has at a given index in their array of Cards.
     * 
     * @param index, int
     * @return the Card at that index
     */
    public Card getCardAtIndex(int index) {      
        return this.hand[index];
    }
    
    
    /**
     * Adds a given card to the end of a players hand.
     * 
     * @param newCard 
     */
    public void giveCard(Card newCard) {
        
        Card[] newHand = new Card[this.hand.length+1];
        
        for (int i = 0; i < hand.length; i++) {
            
            newHand[i] = this.hand[i];
        }
        
        newHand[hand.length] = newCard;
        
        this.hand = newHand;
    }
    
    /**
     * Removes the first card from a player's hand and returns it.
     * 
     * @return Card, takenCard
     */
    public Card takeCard() {
        
        Card takenCard = this.hand[0];        
        Card[] newHand = new Card[this.hand.length-1];
        
        for (int i = 0; i < newHand.length; i++) {
            
            newHand[i] = this.hand[i+1];
            
        }
        this.hand = newHand;
        
        if (this.getHandSize() == 0) {
            
            this.active = false;
        }      
        return takenCard;
    }
    
    /**
     * Returns the Player's top card, without removing that card from 
     * the ones they hold
     * 
     * @return the top Card
     */
    public Card viewTopCard() {
        
        return this.hand[0];
    }
    
}