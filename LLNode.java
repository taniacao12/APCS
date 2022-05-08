/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode<T> {
    // instance vars
    private T cargo;
    private LLNode<T> next;

    // constructor
    public LLNode (T x,LLNode<T> y) {
        cargo = x;
	next = y;
    }
    
    // --------------v  ACCESSORS  v--------------
    public T getCargo() {
	return cargo;
    }

    public LLNode<T> getNext() {
	return next;
    }
    // --------------^  ACCESSORS  ^--------------
    
    // --------------v  MUTATORS  v--------------
    public T setCargo(T x) {
	T temp = getCargo();
	cargo = x;
	return temp;
    }

    public LLNode setNext(LLNode y) {
	LLNode temp = getNext();
	next = y;
        return temp;
    }
    // --------------^  MUTATORS  ^--------------

    // override inherited toString
    public String toString() {
	return cargo.toString();
    }

    // main method for testing
    public static void main (String[] args) {
	LLNode first = new LLNode ("cat",null);
	
	// Create a new node after the first
	first.setNext(new LLNode("dog",null));

	// Create a third node after the second
	first.getNext().setNext(new LLNode("cow",null));
    } // end main
} // end class LLNode
