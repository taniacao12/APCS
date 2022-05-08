// Tania Cao
// APCS1 pd1
// HW#17 -- Do I repeat myself?
// 2019-10-16

public class Repeater {
    // attributes
    public String fence;
    public int counter;

    // methods
    // reset () resets the Repeaters' attributes back to its default values
    public void reset () {
	fence = "";
	counter = 1;
    }
	
    // fenceW () takes non-negative integer posts and returns a String representation of a fence with the specified number of posts (while loop)
    public String fenceW (int numPosts) {
	if (numPosts == 1) {
	    fence = "|";
	    return fence;
	}
	else {
	    fence = "|";
	    while (counter < numPosts) {
		counter += 1;
		fence += "--|";
	    }
	    return fence;
	}
    }
    
    // fenceR () takes non-negative integer posts and returns a String representation of a fence with the specified number of posts (recursion)
    public String fenceR (int numPosts) {
    	if (numPosts == 1) {
    	    fence = "|";
    	    return fence;
    	}
    	else {
    	    fence = "|";
	    int newNumPosts = numPosts - 1;
    	    fenceR(newNumPosts);
	    fence += "--|";
	}
	return fence;
    }
    
    public static void main (String[] args) {
	Repeater test = new Repeater ();
	System.out.println ("Tests with while loop:");
	test.reset ();
	System.out.println (test.fenceW(1));
	test.reset ();
	System.out.println (test.fenceW(2));
	test.reset ();
	System.out.println (test.fenceW(3));
	System.out.println ("Tests with recursion:");
	test.reset ();
	System.out.println (test.fenceR(1));
	test.reset ();
	System.out.println (test.fenceR(2));
	test.reset ();
	System.out.println (test.fenceR(3));
    }
}
