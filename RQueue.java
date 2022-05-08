// Tania Cao
// APCS2 pd2
// HW#36 -- Now Let's Consider You Lot at Fake Terry's
// 2018-04-17

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/

public class RQueue<T> implements Queue<T> {
    // instance variables
    private LLNode<T> _front, _end;
    private int _size;

    // default constructor creates an empty queue
    public RQueue() {
	_front = _end = null;
	_size = 0;
    } // end default constructor

    public void enqueue (T enQVal) {
	_front.setNext(_front);
	_front.setCargo(enQVal);
	_size++;
    } // end enqueue()

    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() { 
	T ret = _front.getCargo();
	_front.setNext(_front.getNext().getNext());
	return ret;
    } // end dequeue()

    public T peekFront() {
	T ret = _front.getCargo();
	return ret;
    }

    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * ...
     * 
     ******************************************/
    public void sample() {
	int index = (int) Math.random() * (_size - 1);
	LLNode<T> temp;
	if (index == _size - 1)
	    LLNode<T> temp = new LLNode<T>(_end.getCargo(),_front);
	else if (index != 0) {
	    for (int count = 0; count <= index; count++)
		LLnode<T> temp = null;
	}    
    } // end sample()
    
    public boolean isEmpty() {
	return _front.equals(null);
    } // O(1)
    
    // print each node, separated by spaces
    public String toString() { 
	String retStr = "HEAD->";
	LLNode<T> temp = _front;
	while (temp != null) {
	    retStr += temp.getCargo() + "->";
	    temp = temp.getNext();
	}
	retStr += "NULL";
	return retStr;
    } // end toString()
    
    // main method for testing
    public static void main (String[] args) {
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...
	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
    } // end main
} // end class RQueue
