package org.example.algorithms.sorting;

/**
 * Сортировка вставками
 * <p>
 * Время работы: O(n^2)<br/>
 * Затраты по памяти: O(1)<br/>
 * Устойчивая: да
 * <p>
 * Использование:<br/>
 * Используется в реальных задачах.<br/>
 * Особенность сортировки вставками заключается в том, что нам не требуется заранее знать все элементы, которые предстоит отсортировать.
 * Фактически, элементы упорядочиваются по мере их поступления.
 * Благодаря этому сортировку вставками удобно использовать в случаях, когда элементы поступают в виде потока и их нужно сортировать в реальном времени.
 * <p>
 * Принцип работы:
 *
 * <p>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Визуализация</a>
 */
public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T itemToInsert = array[i];
            int j = i;
            while (j > 0 && itemToInsert.compareTo(array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = itemToInsert;
        }
    }
}
