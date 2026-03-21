package org.example.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Быстрая сортировка<br/>
 * Во многих языках программирования стандартные функции сортировки основаны на различных модификациях алгоритма быстрой сортировки,
 * так как на практике он зачастую оказывается даже быстрее сортировки слиянием.
 * <p>
 * Время работы: O(n log n) / O(n^2) (в среднем/худшем случае)<br/>
 * Затраты по памяти: O(log n) / O(n) (в среднем/худшем случае)<br/>
 * Устойчивая: нет
 * <p>
 * <a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html">Визуализация</a>
 */
public class QuickSort {

    public static List<Integer> sort(List<Integer> list) {
        List<Integer> listCopy = new ArrayList<>(list);
        if (listCopy.size() < 2) {
            return listCopy;
        }

        // Pivot - опорный элемент
        // Pivot - элемент для разделения массива не 2 части: меньшую и большую половину.
        // Итоговая сложность алгоритма зависит от выбора опорного элемента.
        int pivotElementIndex = 1;
        Integer pivot = listCopy.get(pivotElementIndex);
        listCopy.remove(pivotElementIndex);
        List<Integer> less = sort(
                listCopy.stream()
                        .filter(element -> element <= pivot)
                        .toList()
        );
        List<Integer> more = sort(
                listCopy.stream()
                        .filter(element -> element > pivot)
                        .toList()
        );

        return Stream.of(less.stream(), Stream.of(pivot), more.stream())
                .flatMap(Function.identity())
                .toList();
    }
}
