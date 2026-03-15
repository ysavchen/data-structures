package org.example.data.structures.queue;

/**
 * Очередь на основе кольцевого буфера
 */
public class StaticArrayQueue<T> implements Queue<T> {

    private final T[] elements; // элементы очереди

    private final int capacity; // размер очереди

    private int headIndex = 0;  // индекс для извлечения элемента из очереди (в основной случае указывает за заполненную ячейку)

    private int tailIndex = 0;  // индекс для добавления элемента в очередь (в основной случае указывает за пустую ячейку)

    private int size = 0;       // количество элементов в очереди

    public StaticArrayQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean enqueue(T element) {
        if (size == capacity) {
            return false;
        }

        elements[tailIndex] = element;
        tailIndex = (tailIndex + 1) % capacity;
        size++;
        return true;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T element = elements[headIndex];
        elements[headIndex] = null;
        headIndex = (headIndex + 1) % capacity;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
