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

            // проверяем, отсортирована ли левая половина массива
            // если нет, то считаем, что отсортирована правая половина
            if (array[leftIndex] <= array[midIndex]) {
                if (array[leftIndex] >= target && array[midIndex] < target) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else {
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
