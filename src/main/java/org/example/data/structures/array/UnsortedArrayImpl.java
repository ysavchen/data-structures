package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;
import org.example.data.structures.array.exception.FullArrayException;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Несортированный статический массив
 */
public class UnsortedArrayImpl<T> implements UnsortedArray<T> {

    private static final int ELEMENT_NOT_FOUND = -1;

    private final T[] elementData;

    private int newElementIndex = 0;

    private int size = 0;

    public UnsortedArrayImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.elementData = (T[]) new Object[capacity];
    }

    @Override
    public T getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    /**
     * Находит элемент в массиве<br/>
     * В случае дубликатов вернет индекс первого элемента.
     *
     * @return index
     */
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

    /**
     * Обход массива и выполнение операции с каждым элементом
     */
    @Override
    public void traverse(Consumer<T> consumer) {
        for (T element : elementData) {
            consumer.accept(element);
        }
    }

    @Override
    public int addElement(T element) {
        if (elementData.length == size) {
            throw new FullArrayException();
        }
        int elementIndex = newElementIndex;
        elementData[newElementIndex] = element;
        newElementIndex++;
        size++;
        return elementIndex;
    }

    /**
     * Поддерживается выравнивание массива по левому краю,
     * и если требуется удалить элемент из середины массива, то такое удаление оставит пропуск посреди блока элементов.<br/>
     * Т.к. массив не отсортирован, то можно поменять местами последний элемент с удаляемым.<br/>
     * И затем удалить последний элемент.
     */
    @Override
    public void deleteByIndex(int index) {
        if (size == 0) {
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
            size--;
        }
    }

    /**
     * Размер массива
     */
    @Override
    public int getCapacity() {
        return elementData.length;
    }

    /**
     * Количество элементов в массиве
     */
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
