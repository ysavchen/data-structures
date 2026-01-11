package org.example.data.structures.array;

import java.util.Arrays;

/**
 * Несортированный динамический массив
 */
public class DynamicArray<T> {

    private final T[] elementData;

    private int initialCapacity = 10;

    private int newElementIndex = 0;

    private int numberOfElements = 0;

    public DynamicArray() {
        this.elementData = (T[]) new Comparable[initialCapacity];
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        this.elementData = (T[]) new Comparable[initialCapacity];
    }

    public int getSize() {
        return elementData.length;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
