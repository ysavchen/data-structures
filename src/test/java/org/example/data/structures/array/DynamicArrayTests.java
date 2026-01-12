package org.example.data.structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicArrayTests {

    @Test
    void createArray() {
        var array = new DynamicArrayImpl<String>();
        assertEquals(10, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void createArrayWithInitialCapacity() {
        var array = new DynamicArrayImpl<String>(15);
        assertEquals(15, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void createArrayWithZeroInitialCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicArrayImpl<String>(0));
    }

    @Test
    void createArrayWithNegativeInitialCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicArrayImpl<String>(-1));
    }
}
