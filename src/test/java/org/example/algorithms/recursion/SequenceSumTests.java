package org.example.algorithms.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequenceSumTests {

    @Test
    void loopSum() {
        int[] array = {1, 2, 3};
        int result = SequenceSum.loopSum(array);
        assertEquals(6, result);
    }

    @Test
    void loopSumEmptyArray() {
        int[] array = {};
        int result = SequenceSum.loopSum(array);
        assertEquals(0, result);
    }

    @Test
    void recursiveSum() {
        int[] array = {1, 2, 3};
        int result = SequenceSum.recursiveSum(array);
        assertEquals(6, result);
    }

    @Test
    void recursiveSumEmptyArray() {
        int[] array = {};
        int result = SequenceSum.recursiveSum(array);
        assertEquals(0, result);
    }
}
