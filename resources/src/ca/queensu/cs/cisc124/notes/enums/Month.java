package ca.queensu.cs.cisc124.notes.enums;

/**
 * An enumeration for months of the Gregorian calendar. A month instance
 * can return the number of days in that month for a given year.
 *
 */
public enum Month {
	
	/**
	 * The month January.
	 */
	JANUARY(31),
	
	/**
	 * The month February. The number of days in February depends on whether
	 * or not the year is a leap year.
	 */
	FEBRUARY(28),
	
	/**
	 * The month March.
	 */
	MARCH(31), 
	
	/**
	 * The month April.
	 */
	APRIL(30),
	
	/**
	 * The month May.
	 */
	MAY(31),
	
	/**
	 * The month June.
	 */ 
	JUNE(30),
	
	/**
	 * The month July.
	 */
	JULY(31),
	
	/**
	 * The month August.
	 */ 
	AUGUST(31),
	
	/**
	 * The month September.
	 */
	SEPTEMBER(30),
	
	/**
	 * The month October.
	 */ 
	OCTOBER(31),
	
	/**
	 * The month November.
	 */ 
	NOVEMBER(30),
	
	/**
	 * The month December.
	 */ 
	DECEMBER(31);
	
	private final int days;
	
	/**
	 * Initializes this month to have the specified number of days.
	 * 
	 * @param days the number of days in this month
	 */
	private Month(int days) {
		this.days = days;
	}
	
	/**
	 * Returns the number of days in this month given the year.
	 * 
	 * @param year the year
	 * @return the number of days in this month
	 */
	public int days(int year) {
		if (this != Month.FEBRUARY) {
			return this.days;
		}
		if (year % 400 == 0 ||
			(year % 4 == 0 && year % 100 != 0)) {
			return this.days + 1;
		}
		return this.days;
	}
}
