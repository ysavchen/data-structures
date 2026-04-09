package org.example.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingSortTests {

    @Test
    void sort() {
        int[] array = {9, 14, 2, 5};
        int[] sortedArray = {2, 5, 9, 14};
        CountingSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortWithSameElements() {
        int[] array = {9, 14, 2, 2, 5};
        int[] sortedArray = {2, 2, 5, 9, 14};
        CountingSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortSortedArray() {
        int[] array = {2, 5, 9, 14};
        int[] sortedArray = {2, 5, 9, 14};
        CountingSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortEmptyArray() {
        int[] array = {};
        int[] sortedArray = {};
        CountingSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}
