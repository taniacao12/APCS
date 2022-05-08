// Tania Cao
// APCS1 pd1
// HW#46 -- Al<B> Sorted!.
// 2017-12-04

import java.util.ArrayList;

public class ALTester {
    public static void main (String[] args) {
	ArrayList<Comparable> array = new ArrayList<Comparable>();
	
	System.out.println(array);
	
	// populate array
	for (int index = 0; index < 23; index ++) {
	    array.add(index * 2);
	}
	
	System.out.println(array);
	
	array.set(5,100);

	System.out.println(array);		
	
	// determines whether array has been sorted or not
	for (int index = 0; index < array.size() - 1; index ++) {
	    System.out.println("At index: " + array.get(index));		
	    if (array.get(index).compareTo(array.get(index + 1)) > 0) {
		System.out.println("*** NOT SORTED ***");
		break;
	    }
	    System.out.println(" *** SORTED ***");
	}
    }
}
