package org.example.algorithms.search;

public class RecursiveBinarySearch {

    private static final int NOT_FOUND = -1;

    /**
     * Рекурсивный бинарный поиск<br/>
     * Время работы: O(log n)
     *
     * @param sortedArray   отсортированный массив
     * @param targetElement элемент для поиска в массиве
     * @param leftIndex     индекс левой границы интервала (граница включается в интервал) - [leftIndex, rightIndex)
     * @param rightIndex    индекс правой границы интервала (граница не включается в интервал)
     * @return индекс найденного элемента
     */
    public static <T extends Comparable<T>> int binarySearch(
            T[] sortedArray, T targetElement, int leftIndex, int rightIndex
    ) {
        // rightIndex не включается в интервал,
        //     поэтому если индексы равны, значит мы уже обошли весь массив
        if (rightIndex <= leftIndex) {
            return NOT_FOUND;
        }

        // поиск элемента в интервале
        int midIndex = (leftIndex + rightIndex) / 2;
        T midElement = sortedArray[midIndex];

        if (midElement.equals(targetElement)) {
            return midIndex;
        } else if (midElement.compareTo(targetElement) > 0) { // ищем в левой половине
            return binarySearch(sortedArray, targetElement, leftIndex, midIndex);
        } else { // midElement < targetElement (ищем в правой половине)
            return binarySearch(sortedArray, targetElement, midIndex + 1, rightIndex);
        }
    }
}
