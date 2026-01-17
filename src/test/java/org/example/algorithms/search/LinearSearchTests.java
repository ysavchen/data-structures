package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchElement() {
        Integer[] array = {9, 14, 2, 5};
        int targetElement = 9;
        int searchResult = LinearSearch.linearSearch(array, targetElement);
        assertEquals(0, searchResult);
    }

    @Test
    void searchNonExistingElement() {
        Integer[] array = {9, 14, 2, 5};
        int nonExistingElement = 22;
        int searchResult = LinearSearch.linearSearch(array, nonExistingElement);
        assertEquals(NOT_FOUND, searchResult);
    }

    @Test
    void searchEmptyList() {
        Integer[] list = {};
        int targetElement = 10;
        int searchResult = LinearSearch.linearSearch(list, targetElement);
        assertEquals(NOT_FOUND, searchResult);
    }
}
