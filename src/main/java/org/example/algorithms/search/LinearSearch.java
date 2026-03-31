package org.example.algorithms.search;

public class LinearSearch {

    private static final int NOT_FOUND = -1;

    /**
     * Линейный поиск<br/>
     * Время работы: O(n)
     *
     * @param array  массив
     * @param target элемент для поиска в массиве
     * @return индекс найденного элемента
     */
    public static <T> int search(T[] array, T target) {
        for (int i = 0; i < array.length; i++) {
            T element = array[i];
            if (element.equals(target)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

}
