public class DLLNode<T> {
    private T cargo; // cargo may only be of type String
    private DLLNode<T> next, prev; // pointers to next, prev DLLNodes
    
    // constructor
    public DLLNode(T x,DLLNode<T> y,DLLNode<T> z) {
        cargo = x;
	next = y;
	prev = z;
    }

    // accessors
    public T getCargo() {
	return cargo;
    }

    public DLLNode<T> getNext() {
	return next;
    }

    public DLLNode<T> getPrev() {
	return prev;
    }

    // mutators
    public T setCargo(T x) {
	T temp = getCargo();
	cargo = x;
	return temp;
    }

    public DLLNode<T> setNext(DLLNode<T> y) {
	DLLNode temp = getNext();
	next = y;
        return temp;
    }

    public DLLNode<T> setPrev(DLLNode<T> y) {
	DLLNode temp = getPrev();
	prev = y;
        return temp;
    }

    // override default toString()
    public String toString() {
	return cargo.toString();
    }
} // end class DLLNode
