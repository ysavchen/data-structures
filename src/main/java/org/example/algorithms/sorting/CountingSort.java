package org.example.algorithms.sorting;

/**
 * Сортировка подсчетом
 * <p>
 * Время работы: O(n)<br/>
 * Затраты по памяти: O(k)<br/>
 * k - диапазон значений, или количество уникальных элементов (помять под массив счетчиков).
 */
public class CountingSort {

    /**
     * Сортирует целые числа от 0 до array.length
     */
    public static void sort(int[] array) {

        // 1. Считаем количество вхождений каждого числа
        // Если нужно отсортировать числа от 1 до 10,
        // то для удобства подсчета стоит выделить массив размером array.length + 1
        // Индекс 0 использоваться не будет.
        int[] counting = new int[array.length];
        for (int element : array) {
            counting[element] += 1;
        }

        // 2. Перезаписываем исходный массив
        int index = 0;
        for (int numOfElements : counting) {
            for (int j = 0; j < numOfElements; j++) {
                array[index] = j;
                index++;
            }
        }
    }
}
