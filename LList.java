/*****************************************************
 * class LList v6
 * Implements a linked list of DLLNodes.
 * Version 06 is iterable via FOREACH loop
 * (...because modifications were made to local List interface.)
 *****************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList<T> implements List<T> {
    // instance variables
    private DLLNode head, tail;
    private int size;

    // constructor
    public LList() {
	head = tail = null; // at birth, a list has no elements
	size = 0;
    }

    // list interface methods
    public boolean add (T x) {
	addLast(x);
	return true;
    }

    public void add (int i,T s) {
	if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
	else if (i == size()) addLast(s);
	DLLNode<T> newNode = new DLLNode<T>(s,null,null);
	if (i == 0) addFirst(s);
    	else {
	    DLLNode<T> tmp1 = head;
	    for (int index = 0; index < i - 1; index++)
		tmp1 = tmp1.getNext();
	    DLLNode<T> tmp2 = tmp1.getNext();
	    newNode.setNext(tmp2);
	    newNode.setPrev(tmp1);
	    tmp1.setNext(newNode);
	    tmp2.setPrev(newNode);
	    size++;
	}
    }
    
    public T remove (int i) {
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();
	if (i == 0) return removeFirst();
	else if (i == size() - 1) return removeLast();
	else {
	    DLLNode<T> tmp1 = head;
	    for (int index = 0; index < i - 1; index++)
		tmp1 = tmp1.getNext();
	    T ret = tmp1.getNext().getCargo();
	    tmp1.setNext(tmp1.getNext().getNext());
	    tmp1.getNext().setPrev(tmp1);
	    size--;
	    return ret;
	}
    }

    public T get (int index) {
	if (index < 0 || index >= size())
	    throw new IndexOutOfBoundsException();
	T retVal;
	DLLNode<T> temp = head;
	for (int i = 0; i < index; i++)
	    temp = temp.getNext();
	retVal = temp.getCargo();
	return retVal;
    }

    public T set (int index,T x) {
	if (index < 0 || index >= size())
	    throw new IndexOutOfBoundsException();
	DLLNode temp = head;
	for (int i = 0; i < index; i++)
	    temp = temp.getNext();
	T oldVal = temp.getCargo();
	return oldVal;
    }

    public int size() {
	return size;
    }

    public Iterator<T> iterator() { 
	return new MyIterator();
    }
    
    // helper methods
    public void addFirst (T x) { 
	head = new DLLNode<T>(x,null,head);
	if (size == 0) tail = head;
	else head.getNext().setPrev(head);
	size++;
    }

    public void addLast (T x) { 
	tail = new DLLNode<T>(x,tail,null);
	if (size == 0) head = tail;
	else tail.getPrev().setNext(tail);
	size++;
    }
  
    public T getFirst() {
	return head.getCargo();
    }
    
    public T getLast() {
	return tail.getCargo();
    }

    public T removeFirst() { 
	T ret = getFirst();
	if (size() == 1) head = tail = null;
	else {
	    head = head.getNext();
	    head.setPrev(null);
	}
	size--;
	return ret;
    }

    public T removeLast() { 
	T ret = getLast();
	if (size() == 1) head = tail = null;
	else {
	    tail = tail.getPrev();
	    tail.setNext(null);
	}
	size--;
	return ret;
    }

    // override default toString
    public String toString() {
	String retStr = "HEAD->";
	DLLNode<T> temp = head;
	while (temp != null) {
	    retStr += temp.getCargo() + "->";
	    temp = temp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    /*****************************************************
     * inner class MyIterator
     * Adheres to specifications given by Iterator interface.
     * Uses dummy node to facilitate iterability over LList.
     *****************************************************/
    private class MyIterator implements Iterator<T> {
	private DLLNode<T> dummy;
	private boolean okToRemove;
	
	// constructor 
	public MyIterator() {
	    dummy = new DLLNode<T>(null,null,head);
	    okToRemove = false;
	}

	// iterator interface methods
	// return true if iteration has more elements.
	public boolean hasNext() {
	    return dummy.getNext() != null;
	}

	// return next element in this iteration
	public T next() {
	    dummy = dummy.getNext();
	    if (dummy == null) throw new NoSuchElementException();
	    okToRemove = true;
	    return dummy.getCargo();
	}

	// return last element returned by this iterator (from last next() call)
	// postcondition: maintains invariant that _dummy always points to a node
	//               (...so that hasNext() will not crash)
	public void remove() {
	    if (!okToRemove)
		throw new IllegalStateException("must call next() beforehand");
	    okToRemove = false;
	    if (head == tail)
		head = tail = null;
	    else if (head == dummy) {
		head = head.getNext();
		head.setPrev(null);
	    }
	    else if (tail == dummy) {
		tail = tail.getPrev();
		tail.setNext(null);
	    }
	    else {
		dummy.getNext().setPrev(dummy.getPrev());
		dummy.getPrev().setNext(dummy.getNext());
	    }
	    size--;
	}
    }
    // *************** end inner class MyIterator ***************
    
    public static void main( String[] args ) {
	LList james = new LList();

	System.out.println("initially: " );
	System.out.println(james + "\tsize: " + james.size());

	james.add("beat");
	System.out.println(james + "\tsize: " + james.size());

	james.add("a");
	System.out.println(james + "\tsize: " + james.size());
	
	james.add("need");
	System.out.println(james + "\tsize: " + james.size());
	
	james.add("I");
	System.out.println(james + "\tsize: " + james.size());
	
	System.out.println("2nd item is: " + james.get(1));
	System.out.println("...and now 2nd item is: " + james.set(1,"got"));
	System.out.println(james + "\tsize: " + james.size());

	james.add(0,"whut");
	System.out.println("...after add(0,whut): ");
	System.out.println(james + "\tsize: " + james.size());

	james.add(4,"phat");
	System.out.println("...after add(4,phat): ");
	System.out.println(james + "\tsize: " + james.size());
	
	System.out.println("...after remove last: " + james.remove(james.size - 1));
	System.out.println(james + "\tsize: " + james.size());
	
	System.out.println("...after remove(0): " + james.remove(0));
	System.out.println(james + "\tsize: " + james.size());
	
	System.out.println("...after remove(0): " + james.remove(0));
	System.out.println(james + "\tsize: " + james.size());

	System.out.println("...after remove(0): " + james.remove(0));
	System.out.println(james + "\tsize: " + james.size());
    }
} // end interface
    
