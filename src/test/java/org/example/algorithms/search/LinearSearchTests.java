package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchElement() {
        Integer[] array = {9, 14, 2, 5};
        int target = 9;
        int index = LinearSearch.search(array, target);
        assertEquals(0, index);
    }

    @Test
    void searchNonExistingElement() {
        Integer[] array = {9, 14, 2, 5};
        int target = 22;
        int index = LinearSearch.search(array, target);
        assertEquals(NOT_FOUND, index);
    }

    @Test
    void searchEmptyList() {
        Integer[] list = {};
        int target = 10;
        int index = LinearSearch.search(list, target);
        assertEquals(NOT_FOUND, index);
    }
}
