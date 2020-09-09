package ca.queensu.cs.cisc124.notes.enums.cards;

import java.util.Objects;

/**
 * A class for representing playing cards in a standard 52-card French deck.
 * 
 * <p>
 * A card has a non-null <code>Rank</code> and <code>Suit</code>.
 *
 */
public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;
	
	/**
	 * Initializes this card to have the given rank and suit.
	 * 
	 * @param rank the rank of this card
	 * @param suit the suit of this card
	 * @throws NullPointerException if rank or suit is null
	 */
	public Card(Rank rank, Suit suit) {
		rank = Objects.requireNonNull(rank);
		suit = Objects.requireNonNull(suit);
		this.rank = rank;
		this.suit = suit;
	}
	
	
	/**
	 * Returns the rank of this card.
	 * 
	 * @return the rank of this card
	 */
	public Rank rank() {
		return this.rank;
	}
	
	/**
	 * Returns the suit of this card.
	 * 
	 * @return the suit of this card
	 */
	public Suit suit() {
		return this.suit;
	}
	
	/**
	 * Returns the color of this card.
	 * 
	 * @return the color of this card
	 */
	public Colour color() {
		return this.suit.color();
	}
	
	/**
	 * Compares this card to another card for order. This method imposes the
	 * following order on cards:
	 * 
	 * <ol>
	 * <li>Cards are first compared by rank. If the rank of this card is
	 * less than the rank of the other card then <code>-1</code> is returned.
	 * If the rank of this card is greater than the rank of the other card
	 * then <code>1</code> is returned. If the ranks of the two cards are
	 * equal then the method proceeds to the next step. The ranks are
	 * compared using the <code>compareTo</code> method from the
	 * <code>Rank</code> enum.
	 * 
	 * <li>Cards are compared by suit. If the suit of this card is
	 * less than the suit of the other card then <code>-1</code> is returned.
	 * If the suit of this card is greater than the suit of the other card
	 * then <code>1</code> is returned. If the suits of the two cards are
	 * equal then the method returns <code>0</code>. The suits are
	 * compared using the <code>compareTo</code> method from the
	 * <code>Suit</code> enum.
	 * 
	 * </ol>
	 * 
	 * @param other the card to compare against this card
	 * @return -1, 0, 1 if this card is less than, equal to, or greater than
	 * the other card
	 */
	@Override
	public int compareTo(Card other) {
		if (this.rank.compareTo(other.rank) < 0) {
			return -1;
		}
		else if (this.rank.compareTo(other.rank) > 0) {
			return 1;
		}
		else if (this.suit.compareTo(other.suit) < 0) {
			return -1;
		}
		else if (this.suit.compareTo(other.suit) > 0) {
			return 1;
		}
		return 0;
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
		return this.rank.equals(other.rank) && this.suit.equals(other.suit);
	}
	
	/**
	 * Returns a hash code for this card.
	 * 
	 * @return a hash code for this card
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.rank, this.suit);
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
	
	
	public static void main(String[] args) {
		for (Rank r : Rank.values()) {
			System.out.println(r);
		}
		Card c = new Card(Rank.ACE, Suit.DIAMONDS);
		Card d = new Card(Rank.ACE, Suit.CLUBS);
		System.out.println(c.compareTo(d));
	}

}
