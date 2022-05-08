/**
   driver file for testing class RunMed
   (RunMed provides for calculating a running median of a stream of input ints)
   
   USAGE: Runnable as-is.
   Uncomment RunMed-specific lines below once RunMed is implemented.
   Compile, run fr same dir as RunMed.java
   
   to feed numbers manually:
   $ java RunMed
   
   to feed in prepared set:
   $ java RunMed < input.nums
   (input.nums provided; must be in same dir)
*/

import java.util.Scanner;

public class RunMedDriver {
    public static void main (String[] args) {
	RunMed pile = new RunMed();
	int count = 0;
	
	pile.add(2);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(4);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(6);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(8);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(10);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(1);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(3);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(5);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(7);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
	System.out.println();

	pile.add(9);
	count++;
	System.out.println("Number of Integers: " + count + "\n" + pile);
	System.out.println("Median: " + pile.getMedian());
    } // end main
} // end class
