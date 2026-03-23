package org.example.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTests {

    @Test
    void sort() {
        Integer[] array = {9, 14, 2, 5};
        Integer[] sortedArray = {2, 5, 9, 14};
        SelectionSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortWithSameElements() {
        Integer[] array = {9, 14, 2, 2, 5};
        Integer[] sortedArray = {2, 2, 5, 9, 14};
        SelectionSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortSortedArray() {
        Integer[] array = {2, 5, 9, 14};
        Integer[] sortedArray = {2, 5, 9, 14};
        SelectionSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortEmptyArray() {
        Integer[] array = {};
        Integer[] sortedArray = {};
        SelectionSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}
