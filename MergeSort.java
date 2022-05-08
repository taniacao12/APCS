// Tania Cao
// APCS2 pd2
// HW#5 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2018-02-06

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  sort() sorts the given array so that the smallest int is in element 0.
  merge() merges the 2 given arrays assuming that both arrays have 
  already been sorted
  ======================================*/

public class MergeSort {

    /******************************************************
     * int[] add(int)
     * Adds given int to array
     * Returns array with int at the end
     ******************************************************/
    public static int[] add (int[] a,int x) {
	int[] b = new int[a.length + 1];
	for (int i = 0; i < a.length; i ++) {
	    b[i] = a[i];
	}
	b[a.length] = x;
	return b;
    }
    
    /******************************************************
     * int[] remove(int)
     * Removes element in given index
     * Returns array without given index
     ******************************************************/
    public static int[] remove (int[] a,int x) {
	int[] b = new int[a.length - 1];
	int c = 0;
	for (int i = 0; i < a.length; i ++) {
	    if (i != x) {
		b[c] = a[i];
		c ++;
	    }
	}
	return b;
    }

    /******************************************************
     * int[] merge(int[],int[])
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge (int[] a,int[] b) {
        int[] c = {};
	while ((a.length > 0) && (b.length > 0)) {
	    if (a[0] <= b[0]) {
		c = add(c,a[0]);
		a = remove(a,0);
	    }
	    if (a.length > 0) {
		if (a[0] > b[0]) {
		    c = add(c,b[0]);
		    b = remove(b,0);
		}
	    }
	}
	if (b != null) {
	    for (int x : b) {
		c = add(c,x);
	    }
	}
	if (a != null) {
	    for (int x : a) {
		c = add(c,x);
	    }
	}
	return c;
    } // end merge()

    /******************************************************
     * int[] sort(int[])
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort (int[] arr) {
	int max;
	for (int pass = arr.length - 1; pass > 0; pass --) {
	    max = 0;
	    for (int i = 1; i <= pass; i ++) {
		if (arr[i] > arr[max]) {
		    max = i;
		}
		int save = arr[pass];
		arr[pass] = arr[max];
		arr[max] = save;
	    }
	}
	return arr;
    } // end sort()

    // -------------------HELPERS-------------------------
    // tester function for exploring how arrays are passed
    // usage: print array, mess(array), print array. Whaddayasee?
    public static void mess (int[] a) {
	for (int i = 0; i < a.length; i++)
	    a[i] = 0;
    }

    // helper method for displaying an array
    public static void printArray (int[] a) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    // ---------------------------------------------------


    // main method for testing
    public static void main (String[] args) {
	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray(arr3);
	mess(arr3);
	printArray(arr3);

	System.out.println("\nMerging arr1 and arr0: ");
	printArray(merge(arr1,arr0));

	System.out.println("\nMerging arr4 and arr6: ");
	printArray(merge(arr4,arr6));

	System.out.println("\nSorting arr4-7...");
	printArray(sort(arr4));
	printArray(sort(arr5));
	printArray(sort(arr6));
	printArray(sort(arr7));
    } // end main()
} // end class MergeSort
