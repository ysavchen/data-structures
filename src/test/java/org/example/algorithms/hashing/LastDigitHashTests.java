package org.example.algorithms.hashing;

import org.junit.jupiter.api.Test;

import static org.example.algorithms.hashing.LastDigitHash.hash;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastDigitHashTests {

    @Test
    void collision() {
        int a = 137;
        int b = 7;
        assertEquals(hash(a), hash(b));
    }
}
