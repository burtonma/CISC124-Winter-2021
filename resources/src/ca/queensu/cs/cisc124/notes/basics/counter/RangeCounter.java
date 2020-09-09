package ca.queensu.cs.cisc124.notes.basics.counter;

/**
 * The {@code RangeCounter} class represents a device used to incrementally
 * count upwards from a fixed specified minimum {@code int} value up to a fixed
 * maximum {@code int} value.
 *
 */
public class RangeCounter {

	/**
	 * The current value of this counter.
	 */
	private int value;

	/**
	 * The minimum value for this counter.
	 */
	private int min;

	/**
	 * The maximum value for this counter.
	 */
	private int max;

	/**
	 * Initializes this counter so that it has the specified minimum, maximum,
	 * and current value.
	 * 
	 * @param min the minimum value of this counter
	 * @param max the maximum value of this counter
	 * @param value the current value of this counter
	 * @throws IllegalArgumentException
	 *             if min is greater than max
	 * @throws IllegalArgumentException
	 *             if value is less than min or greater than max
	 */
	public RangeCounter(int min, int max, int value) {
		if (min > max) {
			throw new IllegalArgumentException("min must be less than or equal to max");
		}
		if (value < min || value > max) {
			throw new IllegalArgumentException("value must be in the range min to max");
		}
		this.min = min;
		this.max = max;
		this.value = value;
	}

	/**
	 * Returns the minimum value that this counter can represent.
	 * 
	 * @return the minimum value that this counter can represent
	 */
	public int min() {
		return this.min;
	}
	
	/**
	 * Returns the maximum value that this counter can represent.
	 * 
	 * @return the maximum value that this counter can represent
	 */
	public int max() {
		return this.max;
	}
	
	/**
	 * Returns the current value of this counter.
	 * 
	 * @return the current value of this counter
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Increment the value of this counter upwards by 1. If this method is
	 * called when the current value of this counter is equal to
	 * {@code Integer.MAX_VALUE} then the value of this counter is set to 0
	 * (i.e., the counter wraps around to 0).
	 */
	public void advance() {
		if (this.value != this.max) {
			this.value++;
		} else {
			this.value = this.min;
		}
	}

	/**
	 * Returns a string representation of this counter. The string
	 * representation is the string {@code "count: "} followed by the current
	 * value of this counter.
	 * 
	 * @return a string representation of this counter
	 */
	@Override
	public String toString() {
		return "count: " + this.value;
	}
}
