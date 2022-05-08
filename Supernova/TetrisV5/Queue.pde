class Queue<T> {
  private ArrayList<T> q;

  public Queue() {
    q = new ArrayList<T>();
  }

  public boolean isEmpty() {
    return q.isEmpty();
  }
  public int size() {
    return q.size();
  }

  public T peekFront() {
    return q.get(0);
  }

  public void pushBack(T i) {
    q.add(i);
  }

  public T popFront() {
    T i = q.get(0);
    q.remove(0);
    return i;
  }
}
