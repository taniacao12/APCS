// Tania Cao
// APCS1 pd1
// HW#38 -- Put It Together
// 2017-11-21

/* --------------------------------------------------
   My Swapper class allows you to let the user choose two elements in a given array, and swap each others location. In order to do this, the user is given a coordinates for each elements. The user is then told to input the row and column for the elements they want to swap. If any of the given coordinates are out of bounds, an error is printed.
   -------------------------------------------------- */

/* --------------------------------------------------
   In this version of Swapper I have changed the entire function of the class to correctly match the assignment.  
   -------------------------------------------------- */

import cs1.Keyboard; // import Keyboard.java

public class Swapper {
    
    // instance variables
    public String[][] a = new String[(int) (Math.random() * 10) + 2][(int) (Math.random() * 10) + 2]; // create an array with a random number of rows and columns;
    private int row1;
    private int col1;
    private int row2;
    private int col2;
    
    // default constructor
    public Swapper() {
	populate();
	row1 = 0;
	col1 = 0;
	row2 = 0;
	col2 = 0;
	start();
    }

    // populate() randomly populates array[] a with its string elements
    public void populate () {
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	for (int row = 0; row < a.length; row ++) {
	    for (int col = 0; col < a[row].length; col ++) {
		String s = "";
		int character = (int) (Math.random() * 2) + 3; // number of characters in the string
		for (int counter = 0; counter != character; counter ++) {
		    int letter = (int) (Math.random() * 26);
		    s += alphabet.substring(letter, letter + 1); // creates string
		}
		a[row][col] = s;
	    }
	}
    }
    
    // getA() returns a string used to display the object's array
    public String getA() {
	String s = "";
	int c = a[0].length;
	int count = 1;
	while (count <= c) {
	    s += "      " + count;
	    count ++;
	}
	for (int row = 1; row <= a.length; row ++) {
	    s += "\n " + row + "   ";
	    for (int col = 1; col <= a[row - 1].length; col ++) {
		if (a[row - 1][col - 1].length() == 4) {
		    s += a[row - 1][col - 1] + "   ";
		}
		else {
		    s += a[row - 1][col - 1] + "    ";
		}
	    }
	}
	return s;
    }
    
    // start() gathers all required information (user input) to begin swap()
    public void start() {
	String s;
	s = "Hello user! What would you like to swap in the following given list? \n" + getA()+ "\n\n";
        System.out.print (s);
	try {
	    System.out.print("Input the row of the first element: ");
	    row1 = Keyboard.readInt() - 1;
	    System.out.print("Input the column of first element: ");
	    col1 = Keyboard.readInt() - 1;
	    System.out.print("Input the row of the second element: ");
	    row2 = Keyboard.readInt() - 1;
	    System.out.print("Input the column of the second element: ");
	    col2 = Keyboard.readInt() - 1;
	}
	catch (Exception e) {}
    }
    
    // swap(obj) takes an object as a parameter and switches the its array with this' array
    public void swap() {
	if ((row1 > a.length) || (row2 > a.length) || (col1 > a[row1].length) || (col2 > a[row2].length)) {
	    System.out.println("ERROR: Inputs are out of bounds");
	}
	else {
	    String first = a[row1][col1]; // store first element
	    String second = a[row2][col2]; // store second element
	    a[row1][col1] = second;
	    a[row2][col2] = first;
	    System.out.println("\n" + getA());
	}
    }

    // main() tests each method's functionality
    public static void main (String[] args) {
	Swapper s = new Swapper();
	s.swap();
    }
}
