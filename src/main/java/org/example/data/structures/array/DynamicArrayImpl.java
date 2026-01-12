package org.example.data.structures.array;

import java.util.Arrays;

/**
 * Несортированный динамический массив
 */
public class DynamicArrayImpl<T> {

    private static final int INITIAL_CAPACITY = 10;

    private T[] elementData;

    private int newElementIndex = 0;

    private int numberOfElements = 0;

    public DynamicArrayImpl() {
        this.elementData = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    public DynamicArrayImpl(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        this.elementData = (T[]) new Comparable[initialCapacity];
    }

    public T getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public int addElement(T element) {
        if (elementData.length == numberOfElements) {
            doubleSize();
        }
        return 0;
    }

    public void deleteByIndex(int index) {

    }

    private void doubleSize() {
        T[] newArray = (T[]) new Comparable[elementData.length * 2];
        for (int i = 0; i < elementData.length; i++) {
            newArray[i] = elementData[i];
        }
        elementData = newArray;
    }

    private void halveSize() {

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
