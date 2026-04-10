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
     * <p>
     * Защититься от переполнения при нахождении {@code midIndex} можно так:<br/>
     * {@code leftIndex + (rightIndex - leftIndex) / 2}
     *
     * @param sortedArray отсортированный массив
     * @param target      элемент для поиска в массиве
     * @return индекс найденного элемента
     */
    public static <T extends Comparable<T>> int search(T[] sortedArray, T target) {
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            T midElement = sortedArray[midIndex];

            if (midElement.equals(target)) {
                return midIndex;
            } else if (midElement.compareTo(target) > 0) {
                rightIndex = midIndex - 1;
            } else if (midElement.compareTo(target) < 0) {
                leftIndex = midIndex + 1;
            }
        }

        return NOT_FOUND;
    }
}
