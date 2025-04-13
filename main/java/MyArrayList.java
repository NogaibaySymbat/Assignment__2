public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] array = new Object[10];
    private int size = 0;

    private void grow(){
        Object[] newArray = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void add(T item){
        if (size == array.length){
            grow();
        }
        array[size++] = item;
        size++;
    }

    public void set(int index, T item){
        array[index] = item;
    }

    public void add(int index, T item){
        if (size == array.length){
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    public void addFirst(T item){
        add(0, item);
    }
    public void addLast(T item){
        add(item);
    }
    public T get(int index){
        return (T) array[index];
    }
    public T getFirst(){
        return get(0);
    }
    public T getLast(){
        return get(size-1);
    }

    public void remove(int index){
        for (int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
    }

    public void removeFirst(){
        remove(0);
    }
    public void removeLast(){
        remove(size-1);
    }

    public void sort(){
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - 1 - i; j++){
                if (((T) array[j]).compareTo((T) array[j + 1]) > 0){
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public int indexOf(Object object){
        for (int i = 0; i < size; i++){
            if (array[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object){
        for (int i = size - 1; i >= 0; i--){
            if (array[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object){
        return indexOf(object) != -1;
    }

    public Object[] toArray(){
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public void clear(){
        array = new Object[10];
        size = 0;
    }
    public int size(){
        return size;
    }

    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>() {
            int index = 0;
            public boolean hasNext(){
                return index < size;
            }
            public T next(){
                return (T) array[index++];
            }
        };
    }
}
