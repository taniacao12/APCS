// Tania Cao
// APCS2 pd2
// HW18 -- QuickSort
// 2018-03-12
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Iterate through the given array and use partition to sort
 *             until the array is completely sorted or until you reach the
 *             end of the array.
 *
 * 2a. Worst pivot choice and associated runtime: O(n^2)
 *
 * 2b. Best pivot choice and associated runtime: O(n)
 *
 * 3. Approach to handling duplicate values in array: works the same way as
 *    an array without duplicates.
 *****************************************************/

public class QuickSort {
    // --------------v  HELPER METHODS  v--------------
    // check whether array arr is sorted
    public static boolean sorted (int[] arr) {
	for (int i = 0; i < arr.length - 1; i++) {
	    if (arr[i] > arr[i + 1])
		return false;
	}
	return true;
    }

    // swap values at indices x, y in array o
    public static void swap (int[] o,int x,int y) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    /* ------------------------------------------------------------------
       Takes the given array and rearranges the array so that all the
       integers less than the pivot are to the right and all the integers
       larger than the pivot are to the left
       ------------------------------------------------------------------ */
    public static int partition (int[] arr,int start,int end,int pivot) {
	int partition = arr[pivot];
	swap(arr,pivot,end);
	int storePos = start;
	for (int index = start; index <= end - 1; index++)
	    if (arr[index] < partition) {
		swap(arr,storePos,index);
		storePos++;
	    }
        swap(arr,end,storePos);
	return storePos;
    }
    
    // print input array 
    public static void printArr (int[] a) {
	for (int o : a)
	    System.out.print(o + " ");
	System.out.println();
    }

    // shuffle elements of input array
    public static void shuffle (int[] d) {
	int tmp;
	int swapPos;
	for (int i = 0; i < d.length; i++) {
	    tmp = d[i];
	    swapPos = i + (int) ((d.length - i) * Math.random());
	    swap(d,i,swapPos);
	}
    }

    // return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray (int s,int maxVal) {
	int[] retArr = new int[s];
	for (int i = 0; i < retArr.length; i++)
	    retArr[i] = (int) (maxVal * Math.random());
	return retArr;
    }
    // --------------^  HELPER METHODS  ^--------------


    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort (int[] d) {
	for (int index = 0; index < d.length-1; index ++) {
	    partition(d,0,d.length - 1,index);
	    if (sorted(d) == true)
		return;
	}
    }
    
    // main method for testing
    public static void main (String[] args) {
	// get-it-up-and-running, static test case:
	int[] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: ");
	printArr(arr1);
	qsort(arr1);
	System.out.println("arr1 after qsort: ");
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for (int i = 0; i < arrN.length; i++)
	    arrN[i] = i;
       	System.out.println("\narrN init'd to: ");
	printArr(arrN);
	shuffle(arrN);
	System.out.println("arrN post-shuffle: ");
	printArr(arrN);
	qsort(arrN);
	System.out.println("arrN after sort: ");
	printArr(arrN);

	// get-it-up-and-running, static test case w/ dupes:
	int[] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: ");
	printArr(arr2);
	qsort(arr2);
	System.out.println("arr2 after qsort: ");
	printArr(arr2);

	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for (int i = 0; i < arrMatey.length; i++)
	    arrMatey[i] = (int) (48 * Math.random());
       	System.out.println("\narrMatey init'd to: ");
	printArr(arrMatey);
	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: ");
	printArr(arrMatey);
	qsort(arrMatey);
	System.out.println("arrMatey after sort: ");
	printArr(arrMatey);
    } // end main
} // end class QuickSort
