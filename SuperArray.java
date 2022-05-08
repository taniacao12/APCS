// Tania Cao
// APCS1 pd1
// HW45 -- In America, the Driver Sits on the Left
// 2017-12-03

/***************************
 * class SuperArray version 4.0
 * Wrapper class for array. Facilitates resizing,
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * local List interface. (List.java must be in same dir as this file)
 ***************************/

public class SuperArray implements List {
    // instance variables
    private Object[] _data;  // underlying container
    private int _size;    // number of important elements in this SuperArray

    // default constructor – initializes 10-item array
    public void SuperArray() {
	_data = new Object[10];
	_size = 0;
    }
    
    // output SuperArray in [a,b,c] format
    public String toString() {
	String s = "[";
	for (int index = 0; index < _size; index ++) {
	    s += _data[index] + ",";
	}
	if (s.length() > 1) {
	    // shave off trailing comma
	    s = s.substring(0,s.length() - 1);
	}
	s += "]";
	return s;
    }

    // double capacity of SuperArray
    private void expand() {
	Object[] A = new Object[_data.length * 2]; // create new array
	// copy all items in _data to array
	for (int index = 0; index <_data.length; index ++) {
	    A[index] = _data[index];
	}
	_data = A; // replace _data with array
    }

    // accessor -- return value at specified index
    public Object get (int index) {
	if ((index < 0) || (index >= size())) {
	    throw new IndexOutOfBoundsException("ERROR: illegal index");
	}
	return _data[index];	
    }


    // mutator -- set value at index to newVal,
    //            return old value at index
    public Object set (int index, Object newVal) {
	if ((index < 0) || (index >= size())) {
	    throw new IndexOutOfBoundsException("ERROR: illegal index");
	}
	Object oldValue = _data[index]; // store old value
	_data[index] = newVal; // set new value
	return oldValue;
    }

    // adds an item after the last item
    public boolean add (Object newVal) {
	//first expand if necessary
	if (_size >= _data.length) {
	    expand();
	}
	_data[_size] = newVal; // set the value of the inserted index
	_size ++; // update the number of important elements in SuperArray
	return true;
    }

    // inserts an item at index
    public void add (int index,Object newVal) {
	if ((index < 0) || (index >= size())) {
	    throw new IndexOutOfBoundsException("ERROR: illegal index");
	}
	//first expand if necessary
	if (_size >= _data.length) {
	    expand();
	}
	// copy all items in _data to array
	for (int i = _size; i > index; i --) {
	    _data[i] = _data[i - 1]; //each slot gets value of left neighbor
	}
	_data[index] = newVal; // set the value of the inserted index
	_size ++; // update the number of important elements in SuperArray
    }
    
    // removes the item at index
    // shifts elements left to fill in newly-empted slot
    public Object remove (int index) {
	if ((index < 0) || (index >= size())) {
	    throw new IndexOutOfBoundsException("ERROR: illegal index");
	}
	Object obj = _data[index];
	// copy all items in _data to array
	for (int i = index; i < _size - 1; i ++) {
	    _data[i] = _data[i + 1];
	}
	_size --; // update the number of important elements in SuperArray
	return obj;
    }
    
    // return number of meaningful items in _data
    public int size() {
	return _size;
    }
    
    // main method for testing
    public static void main (String[] args) {
	List mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);
	
	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	try {
	    // this should throw IOOB exception now in v4...
	    mayfield.add(3,99);
	    System.out.println("Printing SuperArray mayfield post-insert...");
	    System.out.println(mayfield);
	}
	catch (IndexOutOfBoundsException ioobe) {
	    // catch most specific first
	    System.out.println("IOOB exception caught.");
	    System.out.println(ioobe.getMessage());
	}
	catch (Exception e) {
	    // ...or catch any
	    System.out.println("General exception caught.");
	    System.out.println(e.getMessage());
	}
	
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
    }//end main()
}//end class
