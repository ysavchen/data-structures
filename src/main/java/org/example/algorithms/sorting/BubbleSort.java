package org.example.algorithms.sorting;

import java.util.Arrays;

/**
 * Пузырьковая сортировка
 * <p>
 * Время работы: O(n^2)<br/>
 * Затраты по памяти: O(1)<br/>
 * Стабильная: да
 * <p>
 * В лучшем случае, когда список уже отсортирован, время работы алгоритма составит O(n).
 * <p>
 * Использование:<br/>
 * Благодаря своей простоте пузырьковая сортировка идеально подходит для тех, кто только начинает изучать алгоритмы сортировки.
 * Пошаговый процесс поможет новичкам понять саму концепцию сортировки и разобраться в работе этой группы алгоритмов.<br/>
 * На практике не используется.
 * <p>
 * Принцип работы:<br/>
 * Пузырьковая сортировка работает путем последовательного сравнения соседних элементов массива и их перестановки, если левый больше правого.
 * За один проход самый большой элемент "всплывает" в конец, и процесс повторяется, пока массив не будет отсортирован.<br/>
 * Каждую итерацию сравнения элементов всегда начинаем с самого начала массива: первого и второго элементов.<br/>
 * Уже отсортированные элементы в конце массива исключаем из сравнений.
 * <p>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Визуализация</a>
 */
public class BubbleSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        System.out.println("Initial array: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            // array.length - i -> не проверяем уже отсортированные элементы
            // array.length - 1 -> чтобы не выйти за границы массива для rightElement
            for (int j = 0; j < array.length - i - 1; j++) {
                T leftElement = array[j];
                T rightElement = array[j + 1];
                if (leftElement.compareTo(rightElement) > 0) {
                    array[j] = rightElement;
                    array[j + 1] = leftElement;
                    swapped = true;
                }
            }
            if (!swapped) break;
            System.out.println("Step " + i + ", array: " + Arrays.toString(array));
        }
    }
}
