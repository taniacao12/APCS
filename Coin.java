// Tania Cao
// APCS1 pd1
// HW#15 -- Wayne's World
// 2017-10-09

public class Coin {
    // instance variables
    public double  value;
    public double bias;
    public String face;
    public String name;
    public int flipCtr;
    public int headsCtr;
    public int tailsCtr;
    
    // methods
    // default constructor that sets the the default face to be "heads"
    public Coin () {
	reset ("heads", 0.5);
    }

    // 1st overloaded constructor that sets the value of coin to be either "penny", "nickel", "dime", "quarter", "half dollar", or "dollar"
    public Coin (String newName) {
    	this ();
	name = newName;
	assignValue(newName);
    }

    // 2nd overloaded constructor that resets the face of the coin if there's a change
    public Coin (String newValue,String newFace) {
	this ();
	face = newFace;
    }

    // reset () sets the default values for all instance variables
    public void reset (String newFace,double newBias) {
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	face = newFace;
	bias = newBias;
    }
    
    // assignValue () assigns the coin's value according it it's name and returns the value assigned
    public double assignValue (String newName) {
	if (name.equals ("penny")) {
	    value = 0.01;
	}
	else if (name.equals ("nickel")) {
	    value = 0.05;
	}
	else if (name.equals ("dime")) {
	    value = 0.1;
	}
	else if (name.equals ("quarter")) {
	    value = 0.25;
	}
	else if (name.equals ("half dollar")) {
	    value = 0.5;
	}
	else if (name.equals ("dollar")) {
	    value = 1;
	}
	return value;
    }

    // flip () simulates a coin flip, updates the corresponding face counters (+1), updates the face value with the new face of the flipped coin (1.0 represents heads and 0.0 represents tails), and returns the new face value
    public String flip () {
	if (Math.random() > bias) {
	    face = "heads";
	    headsCtr += 1;
	}
	else {
	    face = "tails";
	    tailsCtr += 1;
	}
	flipCtr += 1;
	return face;
    }

    // equals () returns boolean after checking to see if 2 coins have the same face up
    public boolean equals (Coin other) {
        return face.equals(other.face);
    }

     // toString () overrides the toString provided by Java and returns a string with the coin's name and current face
    public String toString () {
	return name + " -- " + face;
    }
}
