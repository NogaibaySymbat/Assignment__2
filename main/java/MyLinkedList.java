public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class Node {
        T value;
        Node next;
        Node prev;
        Node(T value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size = 0;

    public void add(T item) {
        Node node = new Node(item);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void set (int index, T item) {
        Node node = getNode(index);
        node.value = item;
    }
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addFirst(item);
        } else {
            Node nextNode = getNode(index);
            Node newNode = new Node(item);
            nextNode.prev = newNode.prev;
            newNode.next = nextNode;
            nextNode.prev.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
    }

    public void addFirst(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T item) {
        add(item);
    }
    public T get(int index) {
        return getNode(index).value;
    }
    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T getFirst() {
        return head.value;
    }
    public T getLast() {
        return tail.value;
    }

    public void remove(int index) {
        Node node = getNode(index);
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
    }
    public void removeFirst() {
        remove(0);
    }
    public void removeLast() {
        remove(size - 1);
    }

    public void sort(){
        Object[] arr = toArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (((T) arr[j]).compareTo((T) arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        clear();
        for (Object o : arr) add ((T) o);
    }
    public int indexOf(Object object) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object){
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.value.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }
    public void clear() {
        head = tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
