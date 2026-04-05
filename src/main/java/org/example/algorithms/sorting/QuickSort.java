package org.example.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Быстрая сортировка
 * <p>
 * Время работы: O(n log n) / O(n^2) (в среднем/худшем случае)<br/>
 * Затраты по памяти: O(log n) / O(n) (в среднем/худшем случае)<br/>
 * Устойчивая: нет
 * <p>
 * Использование:<br/>
 * Быстрая сортировка представлена Тони Хоаром в 1961 году.<br/>
 * На сегодняшний день это самый популярный алгоритм сортировки, при правильной реализации он превосходит все остальные.
 * Во многих языках программирования стандартные функции сортировки основаны на различных модификациях алгоритма быстрой сортировки,
 * так как на практике он зачастую оказывается быстрее сортировки слиянием.
 * <p>
 * Принцип работы:<br/>
 * Быстрая сортировка работает по принципу "разделяй и властвуй".<br/>
 * Алгоритм работает в 4 основных этапа:
 * <ol>
 * <li>
 * Выбор опорного элемента<br/>
 * Опорный элемент (pivot) разделяет массив на два подмассива: меньше опорного элемента и больше.
 * </li>
 * <li>
 * Разделение массива<br/>
 * Все элементы массива перестраиваются так, что элементы меньше опорного оказываются слева от него, а больше - справа.
 * </li>
 * <li>
 * Рекурсивная сортировка<br/>
 * Алгоритм рекурсивно применяются к подмассивам слева и справа от опорного элемента.<br/>
 * Процесс продолжается, пока подмассивы не станут пустыми или состоящими из одного элемента (базовый случай).
 * </li>
 * <li>
 * Объединение результатов<br/>
 * После завершения всех рекурсивных вызовов объединяем результаты в общий отсортированный массив.
 * </li>
 * </ol>
 * <p>
 * Как выбрать опорный элемент?<br/>
 * В качестве опорного элемента выбирается произвольный элемент массива.<br/>
 * Не стоит каждый раз искать точки, которые разделяют данные оптимальным образом.<br/>
 * Это лишь усложняет весь процесс.
 * <p>
 * Когда реализуется худший случай?<br/>
 * Худший случай реализуется только если опорным элементом всегда будет выбираться минимальный (или максимальный) среди оставшихся.
 * Тогда быстрая сортировка вырождается в сортировку выбором, т.к. опорный элемент в действительности не разделяет элементы.<br/>
 * Вероятность реализации худшего случая при выборе произвольного элемента равна 2^n-1 / n!.<br/>
 * Поэтому на практике быстрая сортировка всегда будет работать за O(n log n), а худший случай представляет скорее академический интерес.
 * <p>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Визуализация</a>
 */
public class QuickSort {

    private static final Random random = new Random();

    public static List<List<Integer>> partition(int pivot, List<Integer> list) {
        List<Integer> left = new ArrayList<>();
        List<Integer> center = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (Integer element : list) {
            if (element < pivot) {
                left.add(element);
            } else if (element == pivot) {
                center.add(element);
            } else {
                right.add(element);
            }
        }
        return List.of(left, center, right);
    }

    public static List<Integer> concatenate(List<Integer> left, List<Integer> center, List<Integer> right) {
        List<Integer> result = new ArrayList<>(left.size() + center.size() + right.size());
        result.addAll(left);
        result.addAll(center);
        result.addAll(right);
        return result;
    }

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) { // базовый случай
            return list;
        } else {                // рекурсивный случай
            int pivot = list.get(random.nextInt(list.size()));
            List<List<Integer>> parts = partition(pivot, list);
            return concatenate(sort(parts.get(0)), parts.get(1), sort(parts.get(2)));
        }
    }
}
