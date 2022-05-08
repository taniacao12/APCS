// Tania Cao
// APCS1 pd1
// HW#50 -- Dat Bubbly Tho
// 2017-12-08

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate (int size, int lo, int hi) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while (size > 0) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add (lo + (int) (Math.random() * (hi - lo + 1)));
	    size --;
	}
	return retAL;
    }

    // randomly rearrange elements of an ArrayList
    public static void shuffle (ArrayList al) {
	int randomIndex;
	// setup for traversal fr right to left
	for (int i = al.size() - 1; i > 0; i --) {
	    // pick an index at random
	    randomIndex = (int) (Math.random() * (i * 1));
	    // swap the values at position i and randomIndex
	    al.set (i,al.set(randomIndex,al.get(i)));
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV (ArrayList<Comparable> data) {
	// make n-1 passes across the collection
	for (int passes = 1; passes < data.size(); passes ++) {
	    // iterate from the first to next-to-last element
	    for (int index = 0; index < data.size() - 1; index ++) {
		// if element at index > element at index + 1, swap
		if (data.get(index).compareTo(data.get(index + 1)) > 0) {
		    data.set(index,data.set(index + 1,data.get(index)));
		}
		//System.out.println(data); // show current state of list
	    }
	}
    }
    
    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort (ArrayList<Comparable> input) {
	ArrayList output = new ArrayList<Comparable>();
	for (Comparable element:input) {
	    output.add(element);
	}
	bubbleSortV(output);
	return output;
    }


    public static void main (String [] args) {
	/*===============for VOID methods=============
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  bubbleSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );
	  
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  bubbleSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  ============================================*/
	
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = bubbleSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bubbleSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
    }//end main
}//end class BubbleSort
