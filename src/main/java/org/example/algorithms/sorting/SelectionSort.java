package org.example.algorithms.sorting;

import java.util.Arrays;

/**
 * Сортировка выбором
 * <p>
 * Время работы: O(n^2)<br/>
 * Затраты по памяти: O(1)<br/>
 * Устойчивая: нет
 * <p>
 * Использование:<br/>
 * Благодаря простоте реализации сортировка выбором отлично подходит для знакомства с основными принципами работы алгоритмов сортировки.<br/>
 * На практике не используется.
 * <p>
 * Принцип работы:<br/>
 * Алгоритм делит массив на две части: отсортированную и неотсортированную.<br/>
 * Отсортированная часть располагается в начале массива, неотсортированная занимает оставшуюся часть массива.
 * Изначально отсортированная часть пуста.<br/>
 * На каждом шаге выбирается минимальный элемент из неотсортированной части и перемещается в начало,
 * а элемент из начала перемещается на место минимального элемента.
 * <p>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Визуализация</a>
 */
public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        System.out.println("Initial array: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minElementIndex]) < 0) { // array[j] < minElement
                    minElementIndex = j;
                }
            }
            T firstElement = array[i];
            array[i] = array[minElementIndex];
            array[minElementIndex] = firstElement;
            System.out.println("Step " + i + ", sorted " + (i + 1) + " elements, array: " + Arrays.toString(array));
        }
    }
}
