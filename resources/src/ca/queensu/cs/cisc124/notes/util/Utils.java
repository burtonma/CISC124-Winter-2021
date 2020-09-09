package ca.queensu.cs.cisc124.notes.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Miscellaneous utility methods useful for creating example
 * code snippets.
 *
 */
public final class Utils {

	/**
	 * Suppress constructor creation by compiler to prevent instantiation.
	 */
	private Utils() {
		throw new AssertionError();
	}
	
	
	/**
	 * Returns a list containing the specified elements (in the order that
	 * the elements were specified in).
	 * 
	 * @param <T> the element type of the List
	 * @param elements the elements to be contained in the list
	 * @return a List containing the specified elements
	 */
	@SafeVarargs
	public static <T> List<T> listOf(T... elements) {
		List<T> t = new ArrayList<>();
		for (T e : elements) {
			t.add(e);
		}
		return t;
	}
	
	
	/**
	 * Returns an array of <code>n</code> random <code>int</code> values
	 * between <code>Integer.MIN_VALUE</code> (inclusive) and 
	 * <code>Integer.MAX_VALUE</code> (exclusive).
	 * 
	 * @param n the length of the returned array
	 * @return an array of <code>n</code> random <code>int</code> values
	 */
	public static int[] randomIntArray(int n) {
		return Utils.randomIntArray(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * Returns an array of <code>n</code> random <code>int</code> values
	 * between <code>origin</code> (inclusive) and 
	 * <code>bound</code> (exclusive).
	 * 
	 * @param n the length of the returned array
	 * @param origin the origin (inclusive) of each random value
	 * @param bound the bound (exclusive) of each random value
	 * @return an array of <code>n</code> random <code>int</code> values
	 */
	public static int[] randomIntArray(int n, int origin, int bound) {
		if (n < 0) {
			throw new IllegalArgumentException("n negative");
		}
		return ThreadLocalRandom.current().ints(n, origin, bound).toArray();
	}
	
	/**
	 * Returns a list of <code>n</code> random <code>int</code> values
	 * between <code>Integer.MIN_VALUE</code> (inclusive) and 
	 * <code>Integer.MAX_VALUE</code> (exclusive).
	 * 
	 * @param n the size of the returned list
	 * @return a list of <code>n</code> random <code>int</code> values
	 */
	public static List<Integer> randomIntList(int n) {
		return Utils.randomIntList(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * Returns a list of <code>n</code> random <code>int</code> values
	 * between <code>origin</code> (inclusive) and 
	 * <code>bound</code> (exclusive).
	 * 
	 * @param n the size of the returned list
	 * @param origin the origin (inclusive) of each random value
	 * @param bound the bound (exclusive) of each random value
	 * @return a list of <code>n</code> random <code>int</code> values
	 */
	public static List<Integer> randomIntList(int n, int origin, int bound) {
		if (n < 0) {
			throw new IllegalArgumentException("n negative");
		}
		return ThreadLocalRandom.current().ints(n, origin, bound).boxed().collect(Collectors.toList());
	}
	
	/**
	 * Returns an array of <code>n</code> random <code>double</code> values
	 * between <code>-1.0</code> (inclusive) and 
	 * <code>1.0</code> (exclusive).
	 * 
	 * @param n the length of the returned array
	 * @return an array of <code>n</code> random <code>double</code> values
	 */
	public static double[] randomDoubleArray(int n) {
		return Utils.randomDoubleArray(n, -1.0, 1.0);
	}
	
	/**
	 * Returns an array of <code>n</code> random <code>double</code> values
	 * between <code>origin</code> (inclusive) and 
	 * <code>bound</code> (exclusive).
	 * 
	 * @param n the length of the returned array
	 * @param origin the origin (inclusive) of each random value
	 * @param bound the bound (exclusive) of each random value
	 * @return an array of <code>n</code> random <code>double</code> values
	 */
	public static double[] randomDoubleArray(int n, double origin, double bound) {
		if (n < 0) {
			throw new IllegalArgumentException("n negative");
		}
		return ThreadLocalRandom.current().doubles(n, origin, bound).toArray();
	}
	
	/**
	 * Returns a list of <code>n</code> random <code>double</code> values
	 * between <code>-1.0</code> (inclusive) and 
	 * <code>1.0</code> (exclusive).
	 * 
	 * @param n the size of the returned list
	 * @return a list of <code>n</code> random <code>double</code> values
	 */
	public static List<Double> randomDoubleList(int n) {
		return Utils.randomDoubleList(n, -1.0, 1.0);
	}
	
	/**
	 * Returns a list of <code>n</code> random <code>double</code> values
	 * between <code>origin</code> (inclusive) and 
	 * <code>bound</code> (exclusive).
	 * 
	 * @param n the size of the returned list
	 * @param origin the origin (inclusive) of each random value
	 * @param bound the bound (exclusive) of each random value
	 * @return a list of <code>n</code> random <code>double</code> values
	 */
	public static List<Double> randomDoubleList(int n, double origin, double bound) {
		if (n < 0) {
			throw new IllegalArgumentException("n negative");
		}
		return ThreadLocalRandom.current().doubles(n, origin, bound).boxed().collect(Collectors.toList());
	}
	
	
	public static void main(String[] args) {
		System.out.println(listOf("one", "two", "three", "four"));
		
		System.out.println(Arrays.toString(randomIntArray(5)));
		System.out.println(Arrays.toString(randomIntArray(5, -3, 3)));
		System.out.println(randomIntList(5));
		System.out.println(randomIntList(5, -3, 3));
		
		System.out.println(Arrays.toString(randomDoubleArray(5)));
		System.out.println(Arrays.toString(randomDoubleArray(5, -3, 3)));
		System.out.println(randomDoubleList(5));
		System.out.println(randomDoubleList(5, -3, 3));
		
	}
}
