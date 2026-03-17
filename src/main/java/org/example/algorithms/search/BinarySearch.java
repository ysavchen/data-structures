package org.example.algorithms.search;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    /**
     * Бинарный поиск<br/>
     * Время работы: O(log n)
     * <p>
     * Принцип работы:<br/>
     * Находим центральный элемент массива.<br/>
     * 1. Если центральный элемент массива равен искомому, поиск окончен<br/>
     * 2. Если центральный элемент больше искомого, выполняем те же действия для левой половины массива<br/>
     * 3. Иначе - ищем в правой половине
     * На каждой итерации цикла мы отбрасываем половину данных для поиска.
     * <p>
     * Концептуально удобно сначала проверять актуальность поиска в левой половине, потом в правой.
     *
     * @param sortedArray   отсортированный массив
     * @param targetElement элемент для поиска в массиве
     * @return индекс найденного элемента
     */
    public static <T extends Comparable<T>> int binarySearch(T[] sortedArray, T targetElement) {
        int leftIndex = 0;
        int rightIndex = sortedArray.length; // [leftIndex, rightIndex)

        while (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            T midElement = sortedArray[midIndex];

            if (midElement.equals(targetElement)) {
                return midIndex;
            } else if (midElement.compareTo(targetElement) > 0) {
                rightIndex = midIndex;
            } else { // midElement.compareTo(targetElement) < 0
                leftIndex = midIndex + 1;
            }
        }

        return NOT_FOUND;
    }
}
