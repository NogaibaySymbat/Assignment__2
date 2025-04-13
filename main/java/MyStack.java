public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.addLast(item);
    }
    public T pop() {
        T value = list.getLast();
        list.removeLast();
        return value;
    }
    public T peek() {
        return list.getLast();
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public int size() {
        return list.size();
    }
}
