package org.example.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTests {

    @Test
    void sort() {
        List<Integer> list = List.of(9, 14, 2, 5);
        List<Integer> sortedList = List.of(2, 5, 9, 14);
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }

    @Test
    void sortWithSameElements() {
        List<Integer> list = List.of(9, 14, 2, 2, 5);
        List<Integer> sortedList = List.of(2, 2, 5, 9, 14);
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }

    @Test
    void sortWithAllSameElements() {
        List<Integer> list = List.of(2, 2, 2, 2, 2);
        List<Integer> sortedList = List.of(2, 2, 2, 2, 2);
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }

    @Test
    void sortNegativeElements() {
        List<Integer> list = List.of(-5, 4, 1, -3, 0);
        List<Integer> sortedList = List.of(-5, -3, 0, 1, 4);
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }

    @Test
    void sortSortedList() {
        List<Integer> list = List.of(2, 5, 9, 14);
        List<Integer> sortedList = List.of(2, 5, 9, 14);
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }

    @Test
    void sortReverseOrderArray() {
        List<Integer> list = List.of(14, 9, 5, 2);
        List<Integer> sortedList = List.of(2, 5, 9, 14);
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }

    @Test
    void sortEmptyList() {
        List<Integer> list = List.of();
        List<Integer> sortedList = List.of();
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }

    @Test
    void sortSingleElementArray() {
        List<Integer> list = List.of(2);
        List<Integer> sortedList = List.of(2);
        List<Integer> result = QuickSort.sort(list);
        assertEquals(sortedList, result);
    }
}
