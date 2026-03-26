package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;
import org.example.data.structures.array.exception.FullArrayException;

import java.util.Arrays;
import java.util.Objects;

/**
 * Отсортированный статический массив
 */
public class SortedArrayImpl<T extends Comparable<T>> implements SortedArray<T> {

    private static final int ELEMENT_NOT_FOUND = -1;

    private final T[] elementData;

    private int size = 0;

    public SortedArrayImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.elementData = (T[]) new Comparable[capacity];
    }

    @Override
    public T getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    /**
     * Так как массив отсортирован, можем использовать бинарный поиск.
     */
    @Override
    public int findElement(T element) {
        Objects.requireNonNull(element);
        if (elementData.length == 0) {
            return ELEMENT_NOT_FOUND;
        }

        int leftIndex = 0;
        int rightIndex = elementData.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            var midElement = elementData[midIndex];
            int result = midElement.compareTo(element);
            if (result == 0) {         // element equals midElement
                return midIndex;
            } else if (result > 0) {   // element is less than midElement
                rightIndex = midIndex - 1;
            } else {                   // element is greater than midElement
                leftIndex = midIndex + 1;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * При добавлении нового элемента в массив, находим правильную позицию для вставки,
     * чтобы не нарушался порядок сортировки.
     * <p>
     * Время работы: O(n)<br/>
     * Несмотря на то, что сортировка вставками работает за O(n^2),
     * в данном случае новый элемент добавляется в уже отсортированный массив.
     * Поэтому происходит только один перебор элементов для нахождения правильной позиции для вставки.
     */
    @Override
    public int addElement(T element) {
        if (elementData.length == size) {
            throw new FullArrayException();
        }

        int elementIndex = size;
        if (size == 0) { // array is empty
            elementData[elementIndex] = element;
        } else {
            // обходим элементы массива, начиная с последнего,
            //     и сравниваем вставляемый элемент с предыдущим (сортировка вставками)
            for (int i = elementIndex; i > 0; i--) {
                var prevElement = elementData[i - 1];
                int result = element.compareTo(prevElement);
                if (result < 0) {  // element is less than prevElement
                    elementData[i] = prevElement;
                    elementData[i - 1] = element;
                    elementIndex = i - 1;
                } else {
                    elementData[i] = element;
                    elementIndex = i;
                    break;
                }
            }
        }

        size++;
        return elementIndex;
    }

    /**
     * В отсортированных массивах элементы часто сдвигаются для поддержания порядка сортировки,
     * поэтому при удалении элемента мы ищем элемент не по индексу, а по значению.
     */
    @Override
    public void deleteElement(T element) {
        if (size == 0) {
            throw new EmptyArrayException();
        }

        int index = findElement(element);
        int lastElementIndex = size - 1;
        if (index == ELEMENT_NOT_FOUND) {
            return;
        } else if (index == lastElementIndex) {
            elementData[index] = null;
        } else {
            for (int i = index; i < lastElementIndex; i++) {
                var nextElement = elementData[i + 1];
                elementData[i] = nextElement;
            }
            elementData[lastElementIndex] = null;
        }

        size--;
    }

    @Override
    public int getCapacity() {
        return elementData.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

}
