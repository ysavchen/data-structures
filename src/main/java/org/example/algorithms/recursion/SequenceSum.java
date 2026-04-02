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

    /**
     * Сумма элементов рекурсивно вычисляется как:<br/>
     * {@code сумма текущего элемента + сумма всех последующих элементов}<br/>
     * Например, массив {@code [2, 8, 10, 25]} на первом рекурсивном вызове разбивается на {@code [2] + [8, 10, 25]}.
     * На следующем вызове считаем {@code [8] + [10, 25]}.<br/>
     * Базовый случай - сумма нуля элементов - {@code 0}, потом возвращаемся считаем сумму {@code 25 + 0} etc.
     * <p>
     * Почему базовый случай сумма нуля элементов, а не одного?
     * <pre>
     * {@code
     * if (array.length == 1) {
     *     return array[0]; // почему не остановились на сумме одного элемента?
     * }}
     * Обычно базовый случай - когда дальше уже невозможно продолжать дробить задачу.
     * </pre>
     */
    public static int recursiveSum(int[] array) {
        if (array.length == 0) {
            return 0; // базовый случай
        }
        int[] newArray = Arrays.copyOfRange(array, 1, array.length);
        return array[0] + recursiveSum(newArray);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(recursiveSum(array));
    }
}
