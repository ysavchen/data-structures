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
    void sortWithAllSameElements() {
        int[] array = {2, 2, 2, 2, 2};
        int[] sortedArray = {2, 2, 2, 2, 2};
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
    void sortReverseOrderArray() {
        int[] array = {14, 9, 5, 2};
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
