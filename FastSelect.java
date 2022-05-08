// Tania Cao
// APCS2 pd2
// HW#17 -- So So Fast
// 2018-03-09

public class FastSelect {
    // swaps the element a and b in the given array
    public static void swap (int[] arr,int a, int b) {
	int i = arr[a];
	arr[a] = arr[b];
	arr[b] = i;
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
	for (int index = start; index <= end - 1; index++) {
	    if (arr[index] < partition) {
		swap(arr,storePos,index);
		storePos++;
	    }
	}
	swap(arr,end,storePos);
	return storePos;
    }

    /* ------------------------------------------------------------------
       Precondition: x-smallest value is valid
       Takes the given array and uses partition to help find the x-smallest
       value in the given array
       Best Case: given array is sorted in ascending order --> O(n)
       Worst Case: given array is unsorted --> O(nlogn)
       ------------------------------------------------------------------ */
    public static int FastSelect (int[] arr,int xSmallest) {
	// check whether xSmallest value is a valid value
	if (xSmallest < 1 || xSmallest >= arr.length) {
	    System.out.println("ERROR: INVALID X-SMALLEST VALUE");
	    return -999;
	}
	int start = 0,end = arr.length - 1,pivot = arr.length / 2;
	partition(arr,start,end,pivot);
	for (pivot = arr.length/2; pivot != xSmallest-1; pivot /= 2+start) {
	    if (xSmallest < pivot + 1)
		end = pivot - 1;
 	    if (xSmallest > pivot + 1)
		start = pivot + 1;
	}
	return arr[pivot];
    }
    
    // prints out the given array
    public static void print (int[] arr) {
	String s = "[";
	for (int i = 0; i < arr.length; i++)
	    s += arr[i] + ",";
        System.out.println(s.substring(0,s.length()-1) + "]");
    }
    
    public static void main (String[] args) {
	int[] arr1 = {1,3,5,7,9};
	print(arr1);
	System.out.println(FastSelect(arr1,0));
	System.out.println(FastSelect(arr1,1));
	System.out.println(FastSelect(arr1,2));
	System.out.println(FastSelect(arr1,3));
	System.out.println(FastSelect(arr1,4)); // doesn't work
	System.out.println(FastSelect(arr1,5));
	
	int[] arr2 = {9,1,5,3,7};
	print(arr2);
	System.out.println(FastSelect(arr2,0));
	System.out.println(FastSelect(arr2,1));
	System.out.println(FastSelect(arr2,2));
	System.out.println(FastSelect(arr2,3));
	System.out.println(FastSelect(arr2,4)); // doesn't work
	System.out.println(FastSelect(arr2,5));
    }
}
