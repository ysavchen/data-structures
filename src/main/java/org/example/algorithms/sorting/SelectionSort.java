package org.example.algorithms.sorting;

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
 * Изначально отсортированная часть пуста.<br/>
 * На каждом шаге выбирается минимальный элемент из неотсортированной части и перемещается в начало массива.
 * <p>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Визуализация</a>
 */
public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T minElement = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(minElement) < 0) { // array[j] < minElement
                    minElement = array[j];
                }
            }
            array[i] = minElement;
        }
    }
}
