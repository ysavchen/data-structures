package org.example.algorithms.sorting;

import java.util.Random;

/**
 * Быстрая сортировка с разбиением Хоара
 * <p>
 * Время работы: O(n log n) / O(n^2) (в среднем/худшем случае)<br/>
 * Затраты по памяти: O(log n) / O(n) (в среднем/худшем случае)<br/>
 * Память тратится на рекурсивный стек вызовов для хранения границ подмассивов.<br/>
 * Устойчивая: нет
 */
public class HoareQuickSort {

    private static final Random random = new Random();

    private static <T> void swap(T[] array, int leftIndex, int rightIndex) {
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    /**
     * Схема разбиения Хоара<br/>
     * Два указателя (слева и справа), swap "неправильных элементов", пока указатели не сошлись.
     * <p>
     * После разбиения элементы {@code < pivot} находятся в левой части массива,<br/>
     * а элементы {@code >= pivot} - в правой.
     */
    private static <T extends Comparable<T>> int partition(T[] array, int leftIndex, int rightIndex) {
        var pivot = array[leftIndex + random.nextInt(rightIndex - leftIndex + 1)];

        while (leftIndex <= rightIndex) {
            while (array[leftIndex].compareTo(pivot) < 0) {
                leftIndex++;
            }

            while (array[rightIndex].compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex >= rightIndex) {
                break;
            }

            swap(array, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }

        return rightIndex;
    }

    public static <T extends Comparable<T>> void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = partition(array, leftIndex, rightIndex);
            sort(array, leftIndex, pivotIndex);
            sort(array, pivotIndex + 1, rightIndex);
        }
    }
}
