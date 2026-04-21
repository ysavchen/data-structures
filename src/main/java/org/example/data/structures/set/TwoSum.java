package org.example.data.structures.set;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Дан массив целых чисел {@code array} и целое число {@code x}.<br/>
 * Нужно найти в массиве два элемента, сумма которых равняется {@code x}.
 */
public class TwoSum {

    /**
     * Наивный алгоритм
     * <p>
     * Время работы: O(n^2 / 2)<br/>
     * Затраты по памяти: O(1)
     */
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

    /**
     * Метод двух указателей
     * <p>
     * Сортируем массив.<br/>
     * {@code leftIndex} указывает на первый элемент массива, {@code rightIndex} - на последний.<br/>
     * На каждой итерации суммируем элементы левого и правого указателя.<br/>
     * 1. Сумма элементов равна {@code x} - ответ найден<br/>
     * 2. Сумма элементов меньше {@code x} - передвигаем {@code leftIndex}<br/>
     * 3. Сумма элементов больше {@code x} - передвигаем {@code rightIndex}<br/>
     * Если в какой-то момент указатели встретятся - значит, искомая пара элементов в массиве отсутствует.
     * <p>
     * Время работы: O(n log n)<br/>
     * Затраты по памяти: O(1)
     */
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

    /**
     * Решение с использованием {@code Set}.
     * <p>
     * Такое решение потребляет дополнительную память на хранение элементов в {@code Set}.
     * <p>
     * Время работы: O(n)<br/>
     * Затраты по памяти: O(n)
     */
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
