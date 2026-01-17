package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchElement() {
        Integer[] array = {9, 14, 2, 5};
        int targetElement = 9;
        int index = LinearSearch.linearSearch(array, targetElement);
        assertEquals(0, index);
    }

    @Test
    void searchNonExistingElement() {
        Integer[] array = {9, 14, 2, 5};
        int targetNumber = 22;
        int index = LinearSearch.linearSearch(array, targetNumber);
        assertEquals(NOT_FOUND, index);
    }

    @Test
    void searchEmptyList() {
        Integer[] list = {};
        int targetElement = 10;
        int index = LinearSearch.linearSearch(list, targetElement);
        assertEquals(NOT_FOUND, index);
    }
}
