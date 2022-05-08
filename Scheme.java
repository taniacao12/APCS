/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split the expression into an array
 *   2. Begin at the right end of input expression
 *   3. Start pushing close parenthesis, numbers, and ops onto stack
 *      ... until you reach an open parenthesis
 *   4. Perform operation on stacked numbers, popping off one at a time
 *      ... until you encounter a close parenthesis
 *   5. Push result of calculations onto stack without parenthesis
 *   6. Repeat steps 3-6 until entire input expression has been traversed
 *
 * STACK OF CHOICE: Evaluate by LLStack because it takes less time to
 * evaluate an expression using LinkedList than ArrayList.
 ******************************************************/

public class Scheme {
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg:
     *         evaluate( "( + 4 3 )" ) -> 7
     *	       evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate (String expr) {
	String[] exprArr = expr.split("\\s+");
	LLStack<String> temp = new LLStack<String>();
	for (int i = exprArr.length - 1; i >= 0; i--) {
	    if (exprArr[i].equals("(")) {
		String op = temp.pop();
	        if (op.equals("+"))
		    temp.push(unload(1,temp));
		else if (op.equals("-"))
		    temp.push(unload(2,temp));
		else if (op.equals("*"))
		    temp.push(unload(3,temp));
	    }
	    else temp.push(exprArr[i]);
	}
	String ret = temp.pop();
	return ret;
    } // end evaluate()
    
    
    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload (int op, Stack<String> numbers) {
	int ret = Integer.parseInt(numbers.pop());
	while (!numbers.peek().equals(")")) {
	    int nextVal = Integer.parseInt(numbers.pop());
	    if (op == 1)
		ret += nextVal;
	    else if (op == 2)
		ret -= nextVal;
	    else if (op == 3)
		ret *= nextVal;
	}
	if (numbers.peek().equals(")"))
	    numbers.pop();
	return ret + "";
    } // end unload()
    
    // optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber (String s) {
	try {
	    Integer.parseInt(s);
	    return true;
	}
	catch (NumberFormatException e) {return false;}
    }
  
    //main method for testing
    public static void main (String[] args) {
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1)); // ... 7
	
	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2)); // ... 17
	
	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3)); // ... 29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4)); // ... -4
    } // main
} // end class Scheme
