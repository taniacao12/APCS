// Tania Cao
// APCS2 pd2
// HW#7 -- A Man, A Plan, A Canal: Panama!
// 2018-02-13

public class Resrever {
    // reverseA(String) returns the String in reverse order in O(n) time
    public static String reverseA (String s) {
	String ret = "";
	int i = 0;
	while (i < s.length()) {
	    ret = s.substring(i,i+1) + ret;
	    i ++;
	}
	return ret;
    }

    // reverseB(String) returns the String in reverse order in O(log2n) time
    public static String reverseB (String s) {
	String ret = "";
	int l = s.length();
	int i = l / 2 ;
	while (i >= 0) {
	    if ((i == l / 2) && (l % 2 == 1)) {
		ret = s.substring(l-i-1,l-i);
	    }
	    if (i != l / 2) {
		ret = s.substring(l-i-1,l-i) + ret + s.substring(i,i+1);
	    }
	    i --;
	}
	return ret;
    }

    // tests
    public static void main (String[] args) {
	String s = "stressed";
	System.out.println(s);
	s = reverseA(s);
	System.out.println(s);
	s = reverseB(s);
	System.out.println(s);
    }
}
