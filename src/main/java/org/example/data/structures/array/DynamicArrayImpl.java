package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;

import java.util.Arrays;

/**
 * Несортированный динамический массив
 */
public class DynamicArrayImpl<T> implements DynamicArray<T> {

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

    @Override
    public T getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    @Override
    public int addElement(T element) {
        if (numberOfElements >= elementData.length) {
            doubleSize();
        }
        elementData[newElementIndex] = element;
        newElementIndex++;
        numberOfElements++;
        return newElementIndex - 1;
    }

    @Override
    public void deleteByIndex(int index) {
        if (numberOfElements == 0) {
            throw new EmptyArrayException();
        } else if (index < 0 || index >= newElementIndex) {
            throw new IndexOutOfBoundsException();
        } else {
            int lastElementIndex = newElementIndex - 1;
            if (index == lastElementIndex) {
                elementData[index] = null;
            } else {
                elementData[index] = elementData[lastElementIndex];
                elementData[lastElementIndex] = null;
            }
            newElementIndex--;
            numberOfElements--;
        }
        if (numberOfElements <= (elementData.length / 4)) {
            halveSize();
        }
    }

    private void doubleSize() {
        T[] newArray = (T[]) new Comparable[elementData.length * 2];
        for (int i = 0; i < elementData.length; i++) {
            newArray[i] = elementData[i];
        }
        elementData = newArray;
    }

    private void halveSize() {
        T[] newArray = (T[]) new Comparable[elementData.length / 2];
        for (int i = 0; i < elementData.length; i++) {
            T element = elementData[i];
            if (element != null) {
                newArray[i] = elementData[i];
            } else {
                break;
            }
        }
        elementData = newArray;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public int getSize() {
        return elementData.length;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
