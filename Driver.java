public class Driver {
    public static void main (String[] args) {
	// build Objects from blueprint specified by class Coin
	
	// test default constructor
	Coin mine = new Coin();
	  
	// test 1st overloaded constructor
	Coin yours = new Coin ("quarter");
	
	// test 2nd overloaded constructor
	Coin wayne = new Coin ("dollar","heads");
	
	// test toString() methods of each Coin
	System.out.println ("mine: " + mine);
	System.out.println ("yours: " + yours);
	System.out.println ("wayne: " + wayne);
	
        // test flip() method
	System.out.println ("\nAfter flipping...");
	yours.flip();
	wayne.flip();
	System.out.println ("yours: " + yours);
	System.out.println ("wayne: " + wayne);
	
	// test equals() method
	if (yours.equals(wayne)) {
	    System.out.println( "Matchee matchee!" );
	}
	else {
	    System.out.println( "No match. Firestarter you can not be." );
	}

	// run a series of coin pair flips until 7 heads have come up and print out summary information
	String retStr1 = "\nFaces: ";
	while (mine.headsCtr < 7) {
	    mine.flip ();
	    retStr1 += " " + mine.face;
	}
	System.out.println (retStr1);
	System.out.println ("Number of Flips: " + mine.flipCtr);
	System.out.println ("Number of Heads: " + mine.headsCtr);
	System.out.println ("Number of Tails: " + mine.tailsCtr);

	// run a series of coin pair flips until 10 matches have occured and print out summery information
	String retStr2 = "\nFaces: " + yours.face;
	while (yours.flipCtr < 10) {
	    yours.flip ();
	    retStr2 += " " + yours.face;
	}
	System.out.println (retStr2);
	System.out.println ("Number of Flips: " + yours.flipCtr);
	System.out.println ("Number of Heads: " + yours.headsCtr);
	System.out.println ("Number of Tails: " + yours.tailsCtr);

	// run a series of coin pair flips until 14007 matches have occured and print out summery information
	String retStr3 = "\nFaces: " + wayne.face;
	while (wayne.flipCtr < 14007) {
	    wayne.flip ();
	    retStr3 += " " + wayne.face;
	}
	System.out.println (retStr3);
	System.out.println ("Number of Flips: " + wayne.flipCtr);
	System.out.println ("Number of Heads: " + wayne.headsCtr);
	System.out.println ("Number of Tails: " + wayne.tailsCtr);
	
    } // end main()
} // end class
