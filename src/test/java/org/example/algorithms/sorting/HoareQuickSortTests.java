package org.example.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HoareQuickSortTests {

    @Test
    void sort() {
        Integer[] array = {9, 14, 2, 5};
        Integer[] sortedArray = {2, 5, 9, 14};
        HoareQuickSort.sort(array, 0, array.length - 1);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortWithSameElements() {
        Integer[] array = {9, 14, 2, 2, 5};
        Integer[] sortedArray = {2, 2, 5, 9, 14};
        HoareQuickSort.sort(array, 0, array.length - 1);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortWithAllSameElements() {
        Integer[] array = {2, 2, 2, 2, 2};
        Integer[] sortedArray = {2, 2, 2, 2, 2};
        HoareQuickSort.sort(array, 0, array.length - 1);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortNegativeElements() {
        Integer[] array = {-5, 4, 1, -3, 0};
        Integer[] sortedArray = {-5, -3, 0, 1, 4};
        HoareQuickSort.sort(array, 0, array.length - 1);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortSortedArray() {
        Integer[] array = {2, 5, 9, 14};
        Integer[] sortedArray = {2, 5, 9, 14};
        HoareQuickSort.sort(array, 0, array.length - 1);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortEmptyArray() {
        Integer[] array = {};
        Integer[] sortedArray = {};
        HoareQuickSort.sort(array, 0, array.length - 1);
        assertArrayEquals(sortedArray, array);
    }
}
