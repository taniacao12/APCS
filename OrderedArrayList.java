// Tania Cao
// APCS1 pd1
// HW#49 -- Halving the Halves
// 2017-12-07

// ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList {    
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> array;

    // default constructor initializes instance variable array
    public OrderedArrayList() {
	array = new ArrayList<Comparable>();
    }

    public String toString() {
	return array.toString();
    }

    public Comparable remove (int index) {
	return array.remove(index);
    }

    public int size() {
	return array.size();
    }

    public Comparable get (int index) { 
	return array.get(index); 
    }

    // Assuming the array is a 100 item array...
    // The add() is the best case if there is no known information about the array. However, it is the worst case if there is some known information because it will take n number of passes (n = index of value being added) in order to find the location we already know of.
    // The addBin() is the best case if there is some known information about the array because it will save the most time. However, it is the worst case if there is no known information because it will take a 100 passes in order to find the location of the new value by guessing.
    
    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    public void add (Comparable newVal) {
	for (int index = 0; index < array.size(); index ++) {
	    if (newVal.compareTo(array.get(index)) < 0) {
		array.add(index,newVal);
		return;
	    }
	}
	array.add(newVal);
    }

    public void addBin (int newVal) {
	int lower = 0;
	int upper = array.size() - 1;
	int index = (upper - lower) / 2;
	while (!(array.get(index).compareTo(newVal) == 0) && !(array.get(index + 1).compareTo(newVal) == 0)) {
	    if (array.get(index).compareTo(newVal) < 0) {
		lower = index + 1;
	    }
	    if (array.get(index).compareTo(newVal) > 0) {
		upper = index - 1;
	    }
	    index = ((upper - lower) / 2) + lower;
	    if ((upper == lower) ||(index == 0) || (index == array.size()) || (index == array.size() - 1)){
		System.out.println("break");
		break;
	    }
	}
	if (array.get(index).compareTo(newVal) > 0) {
	    System.out.println("postive");
	    array.add(index,newVal);
	}
	else {
	    System.out.println("negative");
	    array.add(index + 1,newVal);
	}
    }
    
    // main method solely for testing purposes
    public static void main (String[] args) {
	OrderedArrayList array = new OrderedArrayList();
	
	// testing linear search
	for (int index = 0; index < 5; index ++) {
	    array.add((int)(50 * Math.random()));
	}
	System.out.println(array);

	// testing binary adding
	array.addBin(7);
	System.out.println(array);
	//array.addBin(25);
	//System.out.println(array);
	array.addBin(49);
	System.out.println(array);
	
	// check for sorted-ness
	// if msg does not appear, list was sorted
	for (int index = 0; index < array.size() - 1; index ++) {
	    System.out.println("at index: " + array.get(index));
	    if (array.get(index).compareTo(array.get(index + 1)) > 0) {
		System.out.println(" *** NOT sorted *** ");
		break;
	    }
	}
    }//end main()
}//end class OrderedArrayList
