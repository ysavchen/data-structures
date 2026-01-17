package org.example.algorithms.search;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    /**
     * Бинарный поиск<br/>
     * Время работы: O(log n)
     *
     * @param array         отсортированный массив
     * @param targetElement элемент для поиска в массиве
     * @return индекс найденного элемента
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array, T targetElement) {
        int minIndex = 0;
        int maxIndex = array.length - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            T midElement = array[midIndex];

            if (midElement.compareTo(targetElement) < 0) {
                minIndex = midIndex + 1;
            } else if (midElement.compareTo(targetElement) > 0) {
                maxIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }

        return NOT_FOUND;
    }
}
