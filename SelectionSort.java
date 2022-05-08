// Tania Cao
// APCS1 pd1
// HW#51 -- Selection
// 2017-12-11

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort {
    // ~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    // precond: lo < hi && size > 0
    // postcond: returns an ArrayList of random integers
    //           from lo to hi, inclusive
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
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV (ArrayList<Comparable> data) {
	for (int i = 0; i < data.size(); i ++) {
	    // set smallest value as the value in current index
	    Comparable min = data.get(i);
	    int minIndex = i;
	    for (int index = i + 1; index <data.size(); index ++) {
		// compare the smallest value with the value to the right
		// if the value to the right < smallest value
		if (data.get(index).compareTo(min) < 0) {
		    // update the smallest value with the value to the right
		    min = data.get(index);
		    minIndex = index;
		}
	    }
	    data.set(i,data.set(minIndex,data.get(i))); // swap the element in this index with the smallest value
	    //System.out.println(data);
	}
    } // end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort (ArrayList<Comparable> input) {
	ArrayList output = new ArrayList<Comparable>();
	for (Comparable element:input) {
	    output.add(element);
	}
	selectionSortV(output);
	return output;
    } // end selectionSort 


    public static void main (String[] args) {
	ArrayList glen = new ArrayList<Integer>();
	glen.add(3);
	glen.add(2);
	glen.add(5);
	glen.add(0);
	glen.add(1);
	System.out.println("ArrayList glen before sorting:\n" + glen);
	selectionSortV(glen);
	System.out.println("ArrayList glen after sorting:\n" + glen);
	
	/*===============for VOID methods=============
	  ArrayList coco = populate (10,1,1000);
	  System.out.println("ArrayList coco before sorting:\n" + coco);
	  selectionSortV(coco);
	  System.out.println("ArrayList coco after sorting:\n" + coco);
	  ============================================*/

	/*==========for AL-returning methods==========
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println("ArrayList glen before sorting:\n" + glen);
	  ArrayList glenSorted = selectionSort(glen);
	  System.out.println("sorted version of ArrayList glen:\n" + glenSorted);
	  System.out.println("ArrayList glen after sorting:\n" + glen);

	  ArrayList coco = populate (10,1,1000);
	  System.out.println("ArrayList coco before sorting:\n" + coco);
	  ArrayList cocoSorted = selectionSort(coco);
	  System.out.println("sorted version of ArrayList coco:\n" + cocoSorted);
	  System.out.println("ArrayList coco after sorting:\n" + coco);
	  System.out.println(coco);
	  ============================================*/

    } // end main
} // end class SelectionSort
