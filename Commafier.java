// Tania Cao
// APCS1 pd1
// HW#21 -- Karmacomma
// 2017-10-24

public class Commafier {
    // commafy() methods takes a non-negative integer input and returns the number as a String with commas inserted appropriately

    public static String commafyR (int i) {
	String retStr = "";
	String iStr = i + "";
	int length = iStr.length();
	if (length <= 3) {
	    return iStr;
	}
	else {
	    i = i / 1000; // updates i with the numbers before the comma
	    return commafyR(i) + "," + iStr.substring (length - 3);
	}
    }
	
    public static String commafyF (int i) {
	String retStr = "";
	String iStr = i + "";
	int length = iStr.length();
	if (length <= 3) {
	    return iStr;
	}
	else {
	    for (; length > 3; length -= 3) {
		retStr += "," + iStr.substring (length - 3);
	    }
	    return (i / 1000) + retStr;
	}
    }

    public static void main (String[] args) {	
	for (String s : args) {
	    int i = Integer.parseInt (s);
	    System.out.println("commafyR(" + i + "): " + commafyR(i));
	    System.out.println("commafyF(" + i + "): " + commafyF(i));
	}
	System.out.println("-----commafyR Tests-----");
	System.out.println(commafyR(1));
	System.out.println(commafyR(10));
	System.out.println(commafyR(100));
	System.out.println(commafyR(1000));
	System.out.println(commafyR(12345));
	System.out.println("-----commafyF Tests-----");
	System.out.println(commafyF(1));
	System.out.println(commafyF(10));
	System.out.println(commafyF(101));
	System.out.println(commafyF(1000));
	System.out.println(commafyF(12345));
    }
}
