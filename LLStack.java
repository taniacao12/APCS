import java.util.LinkedList;

public class LLStack<T> implements Stack<T> {
    private LinkedList<T> _stack;

    public LLStack() {
	_stack = new LinkedList<T>();
    }
    
    // Return true if this stack is empty, otherwise false.
    public boolean isEmpty() {
	return _stack.size() == 0;
    }

    // Return top element of stack without popping it.
    public T peek() {
	if (isEmpty()) return null;
	T ret = _stack.getLast();
	return ret;
    }

    // Pop and return top element of stack.
    public T pop() {
	if (isEmpty()) return null;
	T ret = _stack.removeLast();
	return ret;
    }

    // Push an element onto top of this stack.
    public void	push (T x) {
	_stack.add(x);
    }
}
