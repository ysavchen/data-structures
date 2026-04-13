package org.example.data.structures.queue;

import java.util.Arrays;

/**
 * Дек на основе кольцевого буфера
 */
public class StaticArrayDeque<T> implements Deque<T> {

    private final T[] elements; // элементы очереди

    private final int capacity; // размер очереди

    private int headIndex = 0;  // индекс для записи/извлечения элемента в начало очереди (в основном случае указывает за заполненную ячейку)

    private int tailIndex = 0;  // индекс для записи/извлечения элемента в конец очереди (в основном случае указывает за заполненную ячейку)

    private int size = 0;       // количество элементов в очереди

    public StaticArrayDeque(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean pushFront(T value) {
        if (size == capacity) {
            return false;
        }

        if (!isEmpty()) {
            headIndex = (headIndex - 1 + capacity) % capacity;
        }
        elements[headIndex] = value;
        size++;
        return true;
    }

    /**
     * Для определения следующего значения индекса используется деление по модулю.
     * {@code tailIndex = (tailIndex + shift) % capacity} можно переписать как:
     * <pre>{@code
     *   tailIndex += shift;
     *   if (tailIndex >= capacity) {
     *       tailIndex = 0;
     *   }
     * }</pre>
     */
    @Override
    public boolean pushBack(T value) {
        if (size == capacity) {
            return false;
        }

        if (!isEmpty()) {
            tailIndex = (tailIndex + 1) % capacity;
        }
        elements[tailIndex] = value;
        size++;
        return true;
    }

    @Override
    public T popFront() {
        if (isEmpty()) {
            return null;
        }

        T element = elements[headIndex];
        elements[headIndex] = null;
        size--;

        if (!isEmpty()) {
            headIndex = (headIndex + 1) % capacity;
        }
        return element;
    }

    @Override
    public T popBack() {
        if (isEmpty()) {
            return null;
        }

        T element = elements[tailIndex];
        elements[tailIndex] = null;
        size--;

        if (!isEmpty()) {
            tailIndex = (tailIndex - 1 + capacity) % capacity;
        }
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

    @Override
    public String toString() {
        return "headIndex: " + headIndex + ", " +
                "tailIndex: " + tailIndex + ", " +
                "size: " + size + ", " +
                "elements: " + Arrays.toString(elements);
    }
}
