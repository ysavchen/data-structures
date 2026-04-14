package org.example.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTests {

    @Test
    void sort() {
        Integer[] array = {9, 14, 2, 5};
        Integer[] sortedArray = {2, 5, 9, 14};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortWithSameElements() {
        Integer[] array = {9, 14, 2, 2, 5};
        Integer[] sortedArray = {2, 2, 5, 9, 14};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortWithAllSameElements() {
        Integer[] array = {2, 2, 2, 2, 2};
        Integer[] sortedArray = {2, 2, 2, 2, 2};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortNegativeElements() {
        Integer[] array = {-5, 4, 1, -3, 0};
        Integer[] sortedArray = {-5, -3, 0, 1, 4};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortSortedArray() {
        Integer[] array = {2, 5, 9, 14};
        Integer[] sortedArray = {2, 5, 9, 14};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortReverseOrderArray() {
        Integer[] array = {14, 9, 5, 2};
        Integer[] sortedArray = {2, 5, 9, 14};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortEmptyArray() {
        Integer[] array = {};
        Integer[] sortedArray = {};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    void sortSingleElementArray() {
        Integer[] array = {2};
        Integer[] sortedArray = {2};
        BubbleSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}
