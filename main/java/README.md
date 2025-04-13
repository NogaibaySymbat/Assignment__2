# OOP Assignment 2 

As part of this OOP assignment, several fundamental data structures were implemented manually in Java, without using standard collections from `java.util`** (except `Iterator`).
All classes were written using object-oriented programming principles such as:
- **Encapsulation**
- **Generics**
- **Interfaces**
- **Method overriding**

### Implemented Structures:

1. **MyList<T>**  
   Interface that defines common list operations: add, remove, search, sort, etc.

2. **MyArrayList<T>**  
   Array-based list implementation (`Object[]` internally). Provides fast access by index and supports dynamic resizing.

3. **MyLinkedList<T>**  
   Custom doubly linked list implementation. Efficient insertion and deletion operations with `head` and `tail` pointers.

4. **MyStack<T>**  
   Stack (LIFO) built on top of `MyArrayList`. Includes `push()`, `pop()`, `peek()`, and `isEmpty()` methods.

5. **MyQueue<T>**  
   Queue (FIFO) implemented using `MyLinkedList`. Supports `enqueue()`, `dequeue()`, `peek()`, and `isEmpty()`.

6. **MyMinHeap<T>**  
   Binary min-heap based on `MyArrayList`. Provides efficient `add()` and `poll()` operations to always retrieve the minimum element.

---

### Testing

All classes were tested in `Main.java` using the same data set:

### Technologies

Java, IntelliJ IDEA, Git, GitHub

Nogaibay Symbat SE-2402