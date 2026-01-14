package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;

import java.util.Arrays;
import java.util.Objects;

/**
 * Упорядоченный динамический массив<br/>
 * Массив поддерживает порядок вставки элементов.
 */
public class DynamicArrayImpl<T> implements DynamicArray<T> {

    private static final int ELEMENT_NOT_FOUND = -1;

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
    public int findElement(T element) {
        for (int index = 0; index < elementData.length; index++) {
            var arrayElement = elementData[index];
            if (Objects.equals(arrayElement, element)) {
                return index;
            }
        }
        return ELEMENT_NOT_FOUND;
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

    /**
     * Так как массив поддерживает порядок вставки элементов, то при удалении элемента из середины, мы сдвигаем влево все элементы, стоящие за удаленным.
     */
    @Override
    public void deleteByIndex(int index) {
        if (numberOfElements == 0) {
            throw new EmptyArrayException();
        } else if (index < 0 || index >= newElementIndex) {
            throw new IndexOutOfBoundsException();
        } else {
            elementData[index] = null;
            int lastElementIndex = newElementIndex - 1;
            if (index != lastElementIndex) {
                for (int i = index; i < lastElementIndex; i++) {
                    elementData[i] = elementData[i + 1];
                }
                elementData[lastElementIndex] = null;
            }
            newElementIndex--;
            numberOfElements--;
        }
        // Уменьшаем размер массива вдвое, если элементы занимают только четверть массива
        if (numberOfElements <= elementData.length / 4) {
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
        int halveSize = elementData.length / 2;
        T[] newArray = (T[]) new Comparable[halveSize];
        for (int i = 0; i < elementData.length; i++) {
            T element = elementData[i];
            if (element != null) {
                newArray[i] = element;
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
