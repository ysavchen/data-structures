package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchExistingNumber() {
        Integer[] array = {2, 5, 9, 14};
        int targetNumber = 9;
        int index = BinarySearch.binarySearch(array, targetNumber);
        assertEquals(2, index);
    }

    @Test
    void searchNonExistingNumber() {
        Integer[] array = {2, 5, 9, 14};
        int targetNumber = 22;
        int index = BinarySearch.binarySearch(array, targetNumber);
        assertEquals(NOT_FOUND, index);
    }

    @Test
    void searchEmptyList() {
        Integer[] array = {};
        int targetNumber = 10;
        int index = BinarySearch.binarySearch(array, targetNumber);
        assertEquals(NOT_FOUND, index);
    }
}
