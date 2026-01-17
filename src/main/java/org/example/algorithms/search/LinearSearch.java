package org.example.algorithms.search;

public class LinearSearch {

    private static final int NOT_FOUND = -1;

    /**
     * Бинарный поиск<br/>
     * Время работы: O(n)
     *
     * @param array         массив
     * @param targetElement элемент для поиска в массиве
     * @return индекс найденного элемента
     */
    public static <T> int linearSearch(T[] array, T targetElement) {
        int index = 0;
        for (T element : array) {
            if (element.equals(targetElement)) {
                return index;
            }
            index++;
        }

        return NOT_FOUND;
    }

}
