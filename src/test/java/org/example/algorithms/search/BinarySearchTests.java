package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchExistingNumber() {
        int[] array = {9, 14, 2, 5};
        int pickedNumber = 9;
        Arrays.sort(array);
        int searchResult = BinarySearch.binarySearch(array, pickedNumber);
        assertEquals(pickedNumber, searchResult);
    }

    @Test
    void searchNonExistingNumber() {
        int[] array = {9, 14, 2, 5};
        int pickedNumber = 22;
        Arrays.sort(array);
        int searchResult = BinarySearch.binarySearch(array, pickedNumber);
        assertEquals(NOT_FOUND, searchResult);
    }

    @Test
    void searchTime() {
        int[] array = IntStream.iterate(1, i -> i + 1)
            .limit(100L)
            .toArray();
        int pickedNumber = 100;
        long startMillis = System.currentTimeMillis();
        BinarySearch.binarySearch(array, pickedNumber);
        long endMillis = System.currentTimeMillis();
        System.out.println("Binary search: " + (endMillis - startMillis) + "ms");
    }

    @Test
    void searchEmptyList() {
        int[] array = {};
        int pickedNumber = 10;
        int searchResult = BinarySearch.binarySearch(array, pickedNumber);
        assertEquals(NOT_FOUND, searchResult);
    }
}
