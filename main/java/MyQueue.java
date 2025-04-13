public class MyQueue <T extends Comparable<T>>{
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }
    public T dequeue() {
        T value = list.getFirst();
        list.removeFirst();
        return value;
    }
    public T peek() {
        return list.getFirst();
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public int size() {
        return list.size();
    }
}
