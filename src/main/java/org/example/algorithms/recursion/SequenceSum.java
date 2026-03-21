package org.example.algorithms.recursion;

import java.util.Arrays;

/**
 * Вычисление суммы элементов последовательности
 */
public class SequenceSum {

    public static int loopSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int total = 0;
        for (int x : array) {
            total += x;
        }
        return total;
    }

    public static int recursiveSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] newArray = Arrays.copyOfRange(array, 1, array.length);
        return array[0] + recursiveSum(newArray);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(recursiveSum(array));
    }
}
