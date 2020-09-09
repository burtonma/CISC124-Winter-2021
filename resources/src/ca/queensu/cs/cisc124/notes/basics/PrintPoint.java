package ca.queensu.cs.cisc124.notes.basics;

import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;

public class PrintPoint {

	public static void main(String[] args) {
		// create a point
		Point2 p = new Point2();
		
		// set its coordinates
		p.set(-1.0, 1.5);
		
		// print the point
		System.out.println(p.toString());
	}

}
