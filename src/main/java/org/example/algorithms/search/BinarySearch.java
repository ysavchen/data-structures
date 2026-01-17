package org.example.algorithms.search;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    /**
     * Бинарный поиск<br/>
     * Время работы: O(log n)
     *
     * @param array        отсортированный массив
     * @param pickedNumber элемент для поиска в массиве
     * @return найденный элемент
     */
    public static int binarySearch(int[] array, int pickedNumber) {
        if (isEmpty(array)) {
            return NOT_FOUND;
        }

        int minIndex = 0;
        int maxIndex = array.length - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            int midNumber = array[midIndex];

            if (midNumber < pickedNumber) {
                minIndex = midIndex + 1;
            } else if (midNumber > pickedNumber) {
                maxIndex = midIndex - 1;
            } else {
                return midNumber;
            }
            sleep();
        }

        return NOT_FOUND;
    }

    private static boolean isEmpty(int[] array) {
        return array.length == 0;
    }

    private static void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
