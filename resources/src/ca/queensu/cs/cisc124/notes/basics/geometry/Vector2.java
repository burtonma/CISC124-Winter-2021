package ca.queensu.cs.cisc124.notes.basics.geometry;

/**
 * A vector in 2-dimensional Cartesian space having real coordinates.
 *
 */
public class Vector2 {

	/**
	 * The coordinates of this vector.
	 */
	private double x;
	private double y;

	/**
	 * Initializes the elements of this vector to {@code (0.0, 0.0)}.
	 */
	public Vector2() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	/**
     * Initializes the coordinates of this vector to {@code (x, y)} where
     * {@code x} and {@code y} are specified by the caller.
     *
     * @param x the x value of this vector
     * @param y the y value of this vector
     */
    public Vector2(double x, double y) {
            this.x = x;
            this.y = y;
    }

    /**
     * Initializes the coordinates of this vector by copying the coordinates
     * from {@code other}.
     *
     * @param other the vector to copy
     */
    public Vector2(Vector2 other) {
            this(other.x, other.y);
    }

		
	/**
	 * Returns the x coordinate.
	 * 
	 * @return the x coordinate
	 */
	public double x() {
		return this.x;
	}
	
	/**
	 * Returns the y coordinate.
	 * 
	 * @return the y coordinate
	 */
	public double y() {
		return this.y;
	}
	
	/**
	 * Sets the x coordinate to the specified value.
	 * 
	 * @param newX the new x coordinate
	 * @return a reference to this vector
	 */
	public Vector2 x(double newX) {
		this.x = newX;
		return this;
	}
	
	/**
	 * Sets the y coordinate to the specified value.
	 * 
	 * @param newY the new y coordinate
	 * @return a reference to this vector
	 */
	public Vector2 y(double newY) {
		this.y = newY;
		return this;
	}
	
	/**
	 * Sets the x and y coordinate to the specified values.
	 * 
	 * @param newX the new x coordinate
	 * @param newY the new y coordinate
	 * @return a reference to this vector
	 */
	public Vector2 set(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		return this;
	}
	
	/**
	 * Add a vector to this vector changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = v + w} where {@code v} is this vector and {@code w}
	 * is a second vector.
	 * 
	 * @param w the vector to add
	 * @return a reference to this vector
	 */
	public Vector2 add(Vector2 w) {
		this.x += w.x;
		this.y += w.y;
		return this;
	}
	
	/**
	 * Subtract a vector from this vector changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = v - w} where {@code v} is this vector and {@code w}
	 * is a second vector.
	 * 
	 * @param w the vector to subtract
	 * @return a reference to this vector
	 */
	public Vector2 subtract(Vector2 w) {
		this.x -= w.x;
		this.y -= w.y;
		return this;
	}
	
	/**
	 * Multiply this vector by a scalar value changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = s * v} where {@code v} is a point and {@code s}
	 * is a scalar.
	 * 
	 * @param s the scalar value to multiply this vector by
	 * @return a reference to this vector
	 */
	public Vector2 multiply(double s) {
		this.x *= s;
		this.y *= s;
		return this;
	}
	
	/**
	 * Divide this vector by a scalar value changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = v / s} where {@code v} is a vector and {@code s}
	 * is a scalar.
	 * 
	 * @param s the scalar value to divide this vector by
	 * @return a reference to this vector
	 * @pre. s != 0.0
	 * @throws IllegalArgumentException if s == 0.0 is true
	 */
	public Vector2 divide(double s) {
		if (s == 0.0) {
			throw new IllegalArgumentException("division by 0.0");
		}
		this.x /= s;
		this.y /= s;
		return this;
	}	
	
	/**
	 * Negate the coordinates of this vector changing the coordinates of this vector.
	 * 
	 * <p>
	 * Use this method when you want to write something like
	 * {@code v = -v} where {@code v} is this vector.
	 * 
	 * @return a reference to this vector
	 */
	public Vector2 negate() {
		this.x = -this.x;
		this.y = -this.y;
		return this;
	}
	
	/**
	 * Returns the dot product of this vector and the specified vector.
	 * 
	 * @param w a vector
	 * @return the dot product of this vector and {@code w}
	 */
	public double dot(Vector2 w) {
		return this.x() * w.x() + this.y() * w.y();
	}
	
	/**
	 * Returns the magnitude (length) of this vector without intermediate
	 * overflow or underflow.
	 * 
	 * @return the magnitude (length) of this vector without intermediate
	 * overflow or underflow
	 */
	public double mag() {
		return Math.hypot(this.x(), this.y());
	}
	
	/**
	 * Returns a new vector equal to {@code v + w}.
	 * 
	 * @param v a vector
	 * @param w a vector
	 * @return a new vector equal to {@code v + w}
	 */
	public static Vector2 add(Vector2 v, Vector2 w) {
		Vector2 result = new Vector2();
		result.set(v.x() + w.x(), v.y() + w.y());
		return result;
	}
	
	/**
	 * Returns a new vector equal to {@code v - w}.
	 * 
	 * @param v a vector
	 * @param w a vector
	 * @return a new vector equal to {@code v - w}
	 */
	public static Vector2 subtract(Vector2 v, Vector2 w) {
		Vector2 result = new Vector2();
		result.set(v.x() - w.x(), v.y() - w.y());
		return result;
	}
	
	/**
	 * Returns a new vector equal to {@code s * v}.
	 * 
	 * @param s a scalar
	 * @param v a vector
	 * @return a new vector equal to {@code s * v}
	 */
	public static Vector2 multiply(double s, Vector2 v) {
		Vector2 result = new Vector2();
		result.set(v.x() * s, v.y() * s);
		return result;
	}
	
	/**
	 * Returns a new vector equal to {@code v / s}.
	 * 
	 * @param s a scalar
	 * @param v a vector 
	 * @return a new vector equal to {@code v / s}
	 * @pre. s != 0
	 * @throws IllegalArgumentException if s == 0.0 is true
	 */
	public static Vector2 divide(Vector2 p, double s) {
		Vector2 result = new Vector2();
		result.divide(s);    // will throw if s == 0.0
		return result;
	}
	
	/**
	 * Returns a new vector equal to {@code -v}.
	 * 
	 * @param v a vector 
	 * @return a new vector equal to {@code -v}
	 */
	public static Vector2 negate(Vector2 v) {
		Vector2 result = new Vector2();
		result.set(-v.x(), -v.y());
		return result;
	}
	
	/**
	 * Returns a string representation of this vector. The string
	 * representation are the coordinates of the vector separated by
	 * a comma and space all inside a pair of parentheses.
	 * 
	 * @return a string representation of this vector
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("(");
		s.append(this.x).
			append(", ").
			append(this.y).
			append(")");
		return s.toString();
	}
}
