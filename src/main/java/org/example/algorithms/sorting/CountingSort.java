package org.example.algorithms.sorting;

import java.util.Arrays;

/**
 * Сортировка подсчетом
 * <p>
 * Время работы: O(n)<br/>
 * Затраты по памяти: O(k) / O(n + k)<br/>
 * n - память под выходной массив, куда записываются отсортированные данные<br/>
 * k - диапазон значений (помять под массив счетчиков).<br/>
 * Устойчивая: нет/да<br/>
 * Устойчивость сортировки подсчетом зависит от реализации.<br/>
 * Устойчивая сортировка подсчетом занимает O(n + k) памяти.
 */
public class CountingSort {

    /**
     * Сортирует целые числа от 0 до array.length
     */
    public static void sort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // 1. Считаем количество вхождений каждого числа
        int max = Arrays.stream(array).max().getAsInt();
        int[] counting = new int[max + 1];
        for (int element : array) {
            counting[element] += 1;
        }

        // 2. Перезаписываем исходный массив
        int index = 0;
        for (int i = 0; i < counting.length; i++) {
            while (counting[i] > 0) {
                array[index] = i;
                index++;
                counting[i]--;
            }
        }
    }
}
