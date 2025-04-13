public class Main {
    public static void main(String[] args) {
        int[] numbers = {3,1,2};

        //MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        for (int num: numbers) arrayList.add(num);
        arrayList.sort();
        System.out.println("MyArrayList: ");
        for (Integer num:arrayList) System.out.print(num + " ");
        System.out.println();

        //MyLinkedList
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int num: numbers) linkedList.add(num);
        linkedList.sort();
        System.out.println("LinkedList: ");
        for (Integer num:linkedList) System.out.print(num + " ");
        System.out.println();

        //MyQueue
        MyQueue<Integer> queue = new MyQueue<>();
        for (int num: numbers) queue.enqueue(num);
        System.out.print("Queue: ");
        System.out.print("Dequeue: " + queue.dequeue() + " ");
        System.out.println("Peek: " + queue.peek());

        //MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        for (int num : numbers) heap.add(num);
        System.out.print("MinHeap: ");
        while (!heap.isEmpty()) System.out.print(heap.poll() + " ");
        System.out.println();
    }
}
