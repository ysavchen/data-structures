package org.example.algorithms.two.pointers;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {

    private static int[] naiveTwoSum(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            System.out.println("first: " + first);
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                System.out.println("second: " + second);
                if (first + second == x) {
                    System.out.println(first + " + " + second + " = " + x);
                    return new int[]{first, second};
                }
            }
        }
        return new int[]{};
    }

    private static int[] twoPointersTwoSum(int[] array, int x) {
        Arrays.sort(array);

        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex < rightIndex) {
            int first = array[leftIndex];
            int second = array[rightIndex];
            int sum = first + second;
            if (sum == x) {
                return new int[]{first, second};
            } else if (sum < x) {
                leftIndex += 1;
            } else if (sum > x) {
                rightIndex -= 1;
            }
        }

        return new int[]{};
    }

    private static int[] twoSum(int[] array, int x) {
        var previous = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            int b = x - a;
            if (previous.contains(b)) {
                return new int[]{a, b};
            } else {
                previous.add(a);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 5};
        int x = 4;
        int[] numbers = twoSum(array, x);
        System.out.println(Arrays.toString(numbers));
    }
}
