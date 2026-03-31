package org.example.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotatedSortedArraySearchTests {

    @Test
    void searchSortedArrayFirstPart() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int target = 3;
        int index = RotatedSortedArraySearch.search(array, target);
        assertEquals(2, index);
    }

    @Test
    void searchSortedArraySecondPart() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;
        int index = RotatedSortedArraySearch.search(array, target);
        assertEquals(4, index);
    }

    @Test
    void searchMiddleElement() {
        int[] array = {5, 6, 7, 1, 2, 3, 4};
        int target = 1;
        int index = RotatedSortedArraySearch.search(array, target);
        assertEquals(3, index);
    }

    @Test
    void searchSortedFirstPart() {
        int[] array = {5, 6, 7, 1, 2, 3, 4};
        int target = 7;
        int index = RotatedSortedArraySearch.search(array, target);
        assertEquals(2, index);
    }

    @Test
    void searchSortedSecondPart() {
        int[] array = {5, 6, 7, 1, 2, 3, 4};
        int target = 3;
        int index = RotatedSortedArraySearch.search(array, target);
        assertEquals(5, index);
    }

    @Test
    void searchLastElement() {
        int[] array = {2, 3, 4, 5, 6, 7, 1};
        int target = 1;
        int index = RotatedSortedArraySearch.search(array, target);
        assertEquals(6, index);
    }

    @Test
    void searchUnsortedPart() {
        int[] array = {7, 4, 6, 5, 1, 2, 3};
        int target = 4;
        int index = RotatedSortedArraySearch.search(array, target);
        assertEquals(-1, index);
    }
}
