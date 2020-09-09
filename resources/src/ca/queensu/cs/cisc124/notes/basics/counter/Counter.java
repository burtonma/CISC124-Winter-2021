package ca.queensu.cs.cisc124.notes.basics.counter;

/**
 * The {@code Counter} class represents a device used to incrementally count
 * upwards from zero up to {@code Integer.MAX_VALUE}.
 *
 */
public class Counter {

	/**
	 * The current value of this counter.
	 */
	private int value;
	
	/**
	 * Initializes this counter so that its current value is 0.
	 */
	public Counter() {
		this.value = 0;
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
	 * Increment the value of this counter upwards by 1. If this method
	 * is called when the current value of this counter is equal to
	 * {@code Integer.MAX_VALUE} then the value of this counter is
	 * set to 0 (i.e., the counter wraps around to 0).
	 */
	public void advance() {
		if (this.value != Integer.MAX_VALUE) {
			this.value++;
		}
		else {
			this.value = 0;
		}
	}
	
	/**
	 * Returns a string representation of this counter. The string
	 * representation is the string {@code "count: "} followed
	 * by the current value of this counter.
	 * 
	 * @return a string representation of this counter
	 */
	@Override
	public String toString() {
		return "count: " + this.value;
	}
	
} // end of Counter class
