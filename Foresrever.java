// Tania Cao
// APCS1 pd1
// HW#20 -- For the Lulz Love of Strings
// 2017-10-19

public class Foresrever {
    // fenceF() returns a String representation of a fence with a given number of posts using a for loop
    public static String fenceF (int posts) {
	String fence = "";
	int counter = 0;
	if (posts == 0) {
	    return fence;
	}
	else if (posts == 1) {
	    fence = "|";
	}
	for (fence = "|"; counter < posts - 1; counter += 1) {
		fence += "--|";
	}
	return fence;
    }

    // reverseF () takes a given string and returns a string with the reverse order of the letters in the given string using a for loop
    public static String reverseF (String s) {
	String retStr = "";
	int length = s.length();
	int index;
	for (index = 1; index <= length; index += 1) {
	    retStr += s.substring(length - index,length - index + 1);
	}
	return retStr;
    }

    // reverseR takes a given string and recursively returns a string with the reverse order of the letters in the given
    public static String reverseR (String s) {
	if ((s == "") || (s.length() <= 1)) {
	    return s;
	}
	return reverseR(s.substring(1)) + s.substring(0,1);
    }
    
    // main() tests the methods
    public static void main (String[] args) {
	System.out.println ("fenceF Tests:");
	System.out.println (fenceF(0));
	System.out.println (fenceF(1));
	System.out.println (fenceF(2));
	System.out.println (fenceF(3));
	System.out.println ("\nreverseF Tests:");
	System.out.println (reverseF("hi"));
	System.out.println (reverseF("stressed"));
	System.out.println ("\nreverseR Tests:");
	System.out.println (reverseR("hi"));
	System.out.println (reverseR("stressed"));
    }
}
