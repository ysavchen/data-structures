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
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            T midElement = sortedArray[midIndex];

            if (midElement == targetElement) {
                return midIndex;
            } else if (midElement.compareTo(targetElement) < 0) {
                leftIndex = midIndex + 1;
            } else { // midElement.compareTo(targetElement) > 0
                rightIndex = midIndex - 1;
            }
        }

        return NOT_FOUND;
    }
}
