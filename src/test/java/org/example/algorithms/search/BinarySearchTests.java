package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchFirstElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 2;
        int index = BinarySearch.binarySearch(array, targetElement);
        assertEquals(0, index);
    }

    @Test
    void searchMiddleElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 9;
        int index = BinarySearch.binarySearch(array, targetElement);
        assertEquals(2, index);
    }

    @Test
    void searchLastElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 14;
        int index = BinarySearch.binarySearch(array, targetElement);
        assertEquals(3, index);
    }

    @Test
    void searchNonExistingElement() {
        Integer[] array = {2, 5, 9, 14};
        int targetElement = 22;
        int index = BinarySearch.binarySearch(array, targetElement);
        assertEquals(NOT_FOUND, index);
    }

    @Test
    void searchEmptyArray() {
        Integer[] array = {};
        int targetElement = 10;
        int index = BinarySearch.binarySearch(array, targetElement);
        assertEquals(NOT_FOUND, index);
    }
}
