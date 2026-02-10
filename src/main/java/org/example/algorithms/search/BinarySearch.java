package org.example.algorithms.search;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    /**
     * Бинарный поиск<br/>
     * Время работы: O(log n)
     *
     * @param sortedArray   отсортированный массив
     * @param targetElement элемент для поиска в массиве
     * @return индекс найденного элемента
     */
    public static <T extends Comparable<T>> int binarySearch(T[] sortedArray, T targetElement) {
        int minIndex = 0;
        int maxIndex = sortedArray.length - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            T midElement = sortedArray[midIndex];

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
