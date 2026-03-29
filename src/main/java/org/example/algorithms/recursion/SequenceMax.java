package org.example.algorithms.recursion;

import java.util.Arrays;

/**
 * Нахождение максимального элемента последовательности
 */
public class SequenceMax {

    public static int loopMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        if (array.length == 1) {
            return array[0];
        }
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int recursiveMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        if (array.length == 1) {
            return array[0];  // базовый случай
        }
        int[] newArray = Arrays.copyOfRange(array, 1, array.length);
        return Math.max(array[0], recursiveMax(newArray));
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 3, 2};
        System.out.println(recursiveMax(array));
    }
}
