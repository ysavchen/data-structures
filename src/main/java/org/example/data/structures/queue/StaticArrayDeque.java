package org.example.data.structures.queue;

import org.example.data.structures.queue.exception.EmptyQueueException;
import org.example.data.structures.queue.exception.FullQueueException;

/**
 * Дек на основе кольцевого буфера
 */
public class StaticArrayDeque<T> implements Deque<T> {

    private final T[] elements; // элементы очереди

    private final int capacity; // размер очереди

    private int headIndex = 0;  // индекс, по которому нужно извлекать элемент, если очередь непустая

    private int tailIndex = 0;  // индекс, по которому нужно добавлять элемент, если в очереди есть место

    private int size = 0;       // количество элементов в очереди

    public StaticArrayDeque(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public void pushFront(T value) {
        if (size == capacity) {
            throw new FullQueueException();
        }

        // headIndex указывает за заполненную ячейку,
        //       поэтому при записи в непустой список (pushFront), мы его сдвигаем влево в ячейку с null
        if (elements[headIndex] != null) {
            headIndex = (headIndex - 1 + capacity) % capacity;
        }
        elements[headIndex] = value;

        // tailIndex должен указывать на пустую ячейку, поэтому после заполнения ячейки, мы его сдвигаем вправо
        if (headIndex == tailIndex) {
            int newTailIndex = (tailIndex + 1) % capacity;
            if (elements[newTailIndex] == null) { // сдвигаем tailIndex только если в очереди еще есть пустые места
                tailIndex = newTailIndex;
            }
        }
        size++;
    }

    /**
     * Для определения следующего значения индекса используется деление по модулю.
     * {@code tailIndex = (tailIndex + 1) % capacity} можно переписать как:
     * <pre>{@code
     *   tailIndex += 1;
     *   if (tailIndex >= capacity) {
     *       tailIndex = 0;
     *   }
     * }</pre>
     */
    @Override
    public void pushBack(T value) {
        if (size == capacity) {
            throw new FullQueueException();
        }

        elements[tailIndex] = value;
        tailIndex = (tailIndex + 1) % capacity;
        size++;
    }

    @Override
    public T popFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        T element = elements[headIndex];
        elements[headIndex] = null;
        headIndex = (headIndex + 1) % capacity;
        size--;
        return element;
    }

    @Override
    public T popBack() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        tailIndex = (tailIndex - 1 + capacity) % capacity;
        T element = elements[tailIndex];
        elements[tailIndex] = null;
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
