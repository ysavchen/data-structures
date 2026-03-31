package org.example.algorithms.search;

/**
 * Бинарный поиск в отсортированном массиве со смещением
 */
public class RotatedSortedArraySearch {

    private static final int NOT_FOUND = -1;

    /**
     * Бинарный поиск<br/>
     * Время работы: O(log n)
     *
     * @param array  отсортированный массив со смещением
     * @param target элемент для поиска в массиве
     * @return индекс найденного элемента
     */
    public static int search(int[] array, int target) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int midElement = array[midIndex];

            if (midElement == target) {
                return midIndex;
            }

            // 1. Проверяем, отсортирована ли левая половина интервала.
            //    Если нет, то считаем, что отсортирована правая половина.
            // 2. Если левая половина отсортирована, но там элемент не найден,
            //    то ищем элемент в левой половине.
            if (array[leftIndex] <= array[midIndex]) {

                // Проверяем, что элемент находится в диапазоне значений левой половины интервала.
                // Если нет - ищем элемент в правой половине.
                if (array[leftIndex] >= target && array[midIndex] < target) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else {
                // Проверяем, что элемент находится в диапазоне значений правой половины интервала.
                // Если нет - ищем элемент в левой половине.
                if (array[midIndex] > target && array[rightIndex] <= target) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }

        return NOT_FOUND;
    }
}
