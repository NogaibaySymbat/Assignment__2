public class MyMinHeap <T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void add(T item){
        list.add(item);
        heapifyUp();
    }
    public T poll(){
        if (list.size() == 0) return null;
        T result = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.removeLast();
        heapifyDown();
        return result;
    }
    public T peek(){
        if (list.size() == 0) return null;
        return list.get(0);
    }
    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void heapifyUp(){
        int index = list.size()-1;
        while (index > 0){
            int paternIndex = (index - 1) / 2;
            if (list.get(paternIndex).compareTo(list.get(index)) < 0) {
                swap(index, paternIndex);
                index = paternIndex;
            } else {
                break;
            }
        }
    }
    public void heapifyDown(){
        int index = 0;
        while (index < list.size()){
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;
            if (leftChild < list.size() && list.get(leftChild).compareTo(list.get(index)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < list.size() && list.get(rightChild).compareTo(list.get(index)) < 0) {
                smallest = rightChild;
            }
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }
    private void swap(int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
