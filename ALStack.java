import java.util.ArrayList;

public class ALStack<T> implements Stack<T> {
    private ArrayList<T> _stack;

    public ALStack() {
	_stack = new ArrayList<T>();
    }
    
    // Return true if this stack is empty, otherwise false.
    public boolean isEmpty() {
	return _stack.size() == 0;
    }

    // Return top element of stack without popping it.
    public T peek() {
	if (isEmpty()) return null;
	T ret = _stack.get(_stack.size() - 1);
	return ret;
    }

    // Pop and return top element of stack.
    public T pop() {
	if (isEmpty()) return null;
	T ret = _stack.remove(_stack.size - 1);
	return ret;
    }

    // Push an element onto top of this stack.
    public void	push (T x) {
	_stack.add(x);
    }
}
