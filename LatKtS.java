/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/

public class LatKtS {
    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip (String s) {
	String ret = "";
	Latkes temp = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++)
	    temp.push(s.substring(i,i+1));
	while (temp.isEmpty() == false)
	    ret += temp.pop();
	return ret;
    } // end flip() 

    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched("({}[()])")    -> true
     *                allMatched("([)]")        -> false
     *                allMatched("")            -> true
     **********************************************************/
    public static boolean allMatched (String s) {
	if (s.length() % 2 == 1) return false;
	Latkes temp = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++) {
	    String current = s.substring(i,i+1);
	    if (current.equals("(") || current.equals("{") || current.equals("["))
		temp.push(current);
	    else if (temp.isEmpty()) return false;
	    else if (current.equals(")") && !temp.pop().equals("(") ||
		     current.equals("}") && !temp.pop().equals("{") ||
		     current.equals("]") && !temp.pop().equals("["))
		return false;
	}
	return temp.isEmpty();
    } // end allMatched()
    
    //main method to test
    public static void main (String[] args) {
	System.out.println(flip("stressed"));
	System.out.println(allMatched("({}[()])")); // true
	System.out.println(allMatched("([)]")); // false
	System.out.println(allMatched("(){([])}")); // true
	System.out.println(allMatched("](){([])}")); // false
	System.out.println(allMatched("(){([])}(")); // false
	System.out.println(allMatched("()[[]]{{{{((([])))}}}}")); // true
    }
} // end class LatKtS
