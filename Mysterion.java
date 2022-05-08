// Tania Cao
// APCS2 pd2
// HW#16 -- ABout Face
// 2018-03-07

public class Mysterion {
    public static void swap (int[] arr,int a, int b) {
	int i = arr[a];
	arr[a] = arr[b];
	arr[b] = i;
    }

    /* ----------------------------------------------------------
       Takes the given array and reorders the array so that all the integers
       less than the integer in element c are to the right and all the
       integers larger than the integer in element c are to the left.
       @a = order elements starting from element a
       @b = order elements up to element b
       @c = use element c as a partition to separate values
       ------------------------------------------------------------- */
    public static int partition (int a,int b,int c,int[] arr) {
	int partition = arr[c]; // store middle value
	swap(arr,c,b);
	int start = a; // start ordering from element a
	for (int index = a; index <= b - 1; index++) {
	    if (arr[index] < partition) {
		swap(arr,start,index);
		start++;
	    }
	}
	swap(arr,b,start);
	return start;
    }
    
    public static void print (int[] arr) {
	String s = "[";
	for (int i = 0; i < arr.length; i++)
	    s += arr[i] + ",";
        System.out.println(s.substring(0,s.length()-1) + "]");
    }
    
    public static void main (String[] args) {
	int[] arr1 = {9,1,5,3,7};
	print(arr1);
	partition(0,4,2,arr1);
	print(arr1);
        System.out.println();
	int[] arr2 = {1,3,5,7,9};
	print(arr2);
	partition(0,4,2,arr2);
	print(arr2);
        System.out.println();
	int[] arr3 = {9,7,5,1,3};
	print(arr3);
	partition(0,4,2,arr3);
	print(arr3);
        System.out.println();
	int[] arr4 = {9,5,7,1,3};
	print(arr4);
	partition(0,4,2,arr4);
	print(arr4);
        System.out.println();
	int[] arr5 = {5,1,9,7,3};
	print(arr5);
	partition(0,4,2,arr5);
	print(arr5);
    }
}
