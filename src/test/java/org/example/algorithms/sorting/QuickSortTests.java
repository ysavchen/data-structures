package org.example.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTests {

    @Test
    void sort() {
        List<Integer> list = List.of(9, 14, 2, 5);
        List<Integer> sortedList = List.of(2, 5, 9, 14);
        QuickSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    void sortWithSameElements() {
        List<Integer> list = List.of(9, 14, 2, 2, 5);
        List<Integer> sortedList = List.of(2, 2, 5, 9, 14);
        QuickSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    void sortSortedList() {
        List<Integer> list = List.of(2, 5, 9, 14);
        List<Integer> sortedList = List.of(2, 5, 9, 14);
        QuickSort.sort(list);
        assertEquals(sortedList, list);
    }

    @Test
    void sortEmptyList() {
        List<Integer> list = List.of();
        List<Integer> sortedList = List.of();
        QuickSort.sort(list);
        assertEquals(sortedList, list);
    }
}
