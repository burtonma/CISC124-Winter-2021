package ca.queensu.cs.cisc124.notes.basics;

import java.util.Arrays;

/**
 * A class representing a playing card from a standard 52-card
 * French deck.
 * 
 * This class uses the string enum pattern to represent the valid
 * ranks and suits of a playing card.
 *
 */
public class Card {
    private String rank;
    private String suit;
    
    public static final String[] RANKS = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    };
    
    public static final String[] SUITS = {
        "CLUBS", "DIAMONDS", "HEARTS", "SPADES"
    };
    
    /**
     * Initializes this card to have the specified rank and suit.
     *
     * @param rank the rank of this card
     * @param suit the suit of this card
     */
    public Card(String rank, String suit) {
    	if (!Arrays.asList(RANKS).contains(rank)) {
    		throw new IllegalArgumentException();
    	}
    	if (!Arrays.asList(SUITS).contains(suit)) {
    		throw new IllegalArgumentException();
    	}
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
	 * Returns a string representation of this card. The returned string
	 * is the rank of this card followed by the string <code>" of "</code>
	 * followed by the suit of this card.
	 */
    @Override
    public String toString() {
    	return this.rank + " of " + this.suit;
    }
    
    /**
	 * Compares this card to the specified object for equality. The
	 * result is true if <code>obj</code> is a card having the same
	 * rank and the same suit as this card, false otherwise.
	 * 
	 * @return true if obj is a card having the same
	 * rank and the same suit as this card, false otherwise
	 */
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) {
    		return true;
    	}
    	if (!(obj instanceof Card)) {
    		return false;
    	}
    	Card other = (Card) obj;
    	if (this.rank.equals(other.rank) && this.suit.equals(other.suit)) {
    		return true;
    	}
    	return false;
    }
    
    /**
	 * Returns a hash code for this card.
	 * 
	 * @return a hash code for this card
	 */
    @Override
    public int hashCode() {
    	int result = this.rank.hashCode();
    	int c = this.suit.hashCode();
    	result = 31 * result + c;
    	return c;
    }
    
}
