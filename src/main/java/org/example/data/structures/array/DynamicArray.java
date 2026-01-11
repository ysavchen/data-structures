package org.example.data.structures.array;

/**
 * Несортированный динамический массив
 */
public class DynamicArray<T> {

    private final T[] elementData;

    private int initialCapacity = 10;

    public DynamicArray() {
        this.elementData = (T[]) new Comparable[initialCapacity];
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        this.elementData = (T[]) new Comparable[initialCapacity];
    }
}
