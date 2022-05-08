public class NodeQueue<Quasar> implements Queue<Quasar>{
    Quasar front;
    LLNode next;
    
    public NodeQueue<Quasar>() {
	front == null;
	next = new 
    }
    
    public Quasar dequeue() {
	Quasar ret = getCargo();
	setCargo(getNext().getCargo());
	return ret;
    }

    public void enqueue( Quasar x ) {
        setNext.setCargo(getCargo());
	setCargo(x);
    }
	
    public boolean isEmpty() {
	return getCargo.equals(null);
    }
    
    public Quasar peekFront() {
	return getCargo();
    }
} // end NodeQueue
