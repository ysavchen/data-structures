package org.example.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTests {

    @Test
    void sort() {
        int[] array = {9, 14, 2, 5};
        int[] sortedArray = {2, 5, 9, 14};
        int[] result = MergeSort.sort(array);
        assertArrayEquals(sortedArray, result);
    }

    @Test
    void sortWithSameElements() {
        int[] array = {9, 14, 2, 2, 5};
        int[] sortedArray = {2, 2, 5, 9, 14};
        int[] result = MergeSort.sort(array);
        assertArrayEquals(sortedArray, result);
    }

    @Test
    void sortSortedArray() {
        int[] array = {2, 5, 9, 14};
        int[] sortedArray = {2, 5, 9, 14};
        int[] result = MergeSort.sort(array);
        assertArrayEquals(sortedArray, result);
    }

    @Test
    void sortEmptyArray() {
        int[] array = {};
        int[] sortedArray = {};
        int[] result = MergeSort.sort(array);
        assertArrayEquals(sortedArray, result);
    }
}
