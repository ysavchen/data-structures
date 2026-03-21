package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursiveBinarySearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchFirstElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 2;
        int index = RecursiveBinarySearch.binarySearch(array, targetElement, 0, array.length);
        assertEquals(0, index);
    }

    @Test
    void searchMiddleElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 9;
        int index = RecursiveBinarySearch.binarySearch(array, targetElement, 0, array.length);
        assertEquals(2, index);
    }

    @Test
    void searchLastElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 14;
        int index = RecursiveBinarySearch.binarySearch(array, targetElement, 0, array.length);
        assertEquals(3, index);
    }

    @Test
    void searchNonExistingElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 22;
        int index = RecursiveBinarySearch.binarySearch(array, targetElement, 0, array.length);
        assertEquals(NOT_FOUND, index);
    }

    @Test
    void searchEmptyArray() {
        Integer[] array = {};
        int targetElement = 10;
        int index = RecursiveBinarySearch.binarySearch(array, targetElement, 0, array.length);
        assertEquals(NOT_FOUND, index);
    }
}
