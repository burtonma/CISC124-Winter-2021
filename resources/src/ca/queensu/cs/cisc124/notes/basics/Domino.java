package ca.queensu.cs.cisc124.notes.basics;

/**
 * A class that represents domino tiles. A domino is a rectangular
 * tile with a line dividing its playing face into two sides.
 * Each side of the playing face is marked with pips (dots) similar
 * to a standard 6-sided die. The number of pips on each side
 * of the playing face ranges from Domino.MIN_VALUE to
 * Domino.MAX_VALUE (inclusive).
 * 
 * <p>
 * In simpler terms, each domino tile has two integer values
 * that range from Domino.MIN_VALUE to Domino.MAX_VALUE (inclusive).
 *
 */
public class Domino {

	/**
	 * The smallest possible value for a side of a domino.
	 */
	public static final int MIN_VALUE = 0;
	
	/**
	 * The largest possible value for a side of a domino. 
	 */
	public static final int MAX_VALUE = 6;

	/**
	 * The two values on the domino.
	 */
	private int val1;
	private int val2;

	/**
	 * Initializes this domino so that both of its values are
	 * equal to <code>Domino.MIN_VALUE</code>.
	 */
	public Domino() {
		this(0, 0);
	}

	/**
	 * Initializes this domino to have the specified values.
	 * 
	 * @param value1
	 *            a value
	 * @param value2
	 *            another value
	 * @pre. value1 is a legal domino value and value2 is a legal domino value
	 * @throws IllegalArgumentException
	 *             if value1 or value2 is not a legal domino value
	 */
	public Domino(int value1, int value2) {
		if (!isValueOK(value1) || !isValueOK(value2)) {
			throw new IllegalArgumentException();
		}
		this.val1 = value1;
		this.val2 = value2;
	}

	/**
	 * Initializes this domino so that its values are the same as the specified
	 * other domino.
	 * 
	 * @param other
	 *            a domino
	 */
	public Domino(Domino other) {
		this(other.val1, other.val2);
	}

	/**
	 * Returns true if the specified value is a legal domino value, and false
	 * otherwise.
	 * 
	 * @param value
	 *            a value to check
	 * @return true if the specified value is a legal domino value, and false
	 *         otherwise
	 */
	public static boolean isValueOK(int value) {
		return value >= MIN_VALUE && value <= MAX_VALUE;
	}
	
	/**
	 * Returns the smaller of the two values of this domino. If both
	 * values of this domino are equal to the same value then that
	 * value is returned.
	 * 
	 * @return the smaller of the two values of this domino
	 */
	public int getSmallerValue() {
		int result = this.val1 <= this.val2 ? this.val1 : this.val2;
		return result;
	}

	/**
	 * Returns the larger of the two values of this domino. If both
	 * values of this domino are equal to the same value then that
	 * value is returned.
	 * 
	 * @return the larger of the two values of this domino
	 */
	public int getLargerValue() {
		int result = this.val1 >= this.val2 ? this.val1 : this.val2;
		return result;
	}

	/**
	 * Compares this domino to the specified object. The result is
	 * true if and only if the argument is a Domino object having the
	 * same values as this domino object. Note that the side on which
	 * a value appears is not considered for the purposes of equals;
	 * for instance, <code>eq</code> will be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 1);
	 * boolean eq = a.equals(b);
	 * </pre>
	 * 
	 * @param obj an object to compare
	 * @return true if this domino is equal to the specified object,
	 *         and false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Domino other = (Domino) obj;
		if (this.getSmallerValue() == other.getSmallerValue() &&
				this.getLargerValue() == other.getLargerValue()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Returns a hash code for this domino. The hash code value
	 * is equal to the smaller value of this domino plus eleven times
	 * the larger value of this domino.
	 * 
	 * @return the smaller value of this domino plus eleven times
	 * the larger value of this domino
	 */
	@Override
	public int hashCode() {
		return this.getSmallerValue() + 11 * this.getLargerValue();
	}
	
	/**
	 * Returns a string representation of this domino. The returned
	 * string is the smaller value of this domino followed by
	 * a space, a colon, a space, and finally the larger value of
	 * this domino all inside a pair of square brackets; for example,
	 * if {@code d = new Domino(5, 3)} then {@code d.toString()} returns
	 * the string {@code "[3 : 5]"}.  
	 * 
	 * @return a string representation of this domino
	 */
	@Override
	public String toString() {
		return "[" + this.getSmallerValue() + " : " + this.getLargerValue() + "]";
	}
	
	
	/**
	 * Returns a new domino with values given by the specified string.
	 * The argument string <code>s</code> is expected to have the same format
	 * as the one returned by <code>toString</code>.
	 *  
	 * @param s the string representation of a domino
	 * @return a new domino with values given by s
	 * @throws IllegalArgumentException if s is not a string representation of a domino
	 */
	public static Domino fromString(String s) {
		if (!s.startsWith("[")) {
			throw new IllegalArgumentException("leading [ expected");
		}
		if (!s.endsWith("]")) {
			throw new IllegalArgumentException("trailing ] expected");
		}
		String[] parts = s.split(":");
		if (parts.length != 2) {
			throw new IllegalArgumentException("expected int : int");
		}
		String first = parts[0].trim().replace("[", "");
		String second = parts[1].trim().replace("]", "");
		int val1;
		int val2;
		try {
			val1 = Integer.parseInt(first);
			if (!Domino.isValueOK(val1)) {
				throw new IllegalArgumentException(val1 + " out of range");
			}
		}
		catch (NumberFormatException x) {
			throw new IllegalArgumentException("non-int val1: " + first);
		}
		try {
			val2 = Integer.parseInt(second);
			if (!Domino.isValueOK(val2)) {
				throw new IllegalArgumentException(val2 + " out of range");
			}
		}
		catch (NumberFormatException x) {
			throw new IllegalArgumentException("non-int val2: " + second);
		}
		return new Domino(val1, val2);
	}
}
