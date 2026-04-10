package org.example.data.structures.associative.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssociativeArrayTests {

    @Test
    void createAssociativeArray() {
        var array = new AssociativeArray<String, String>();
        assertTrue(array.isEmpty());
    }

    @Test
    void putValue() {
        var array = new AssociativeArray<String, String>();
        array.put("first", "Anna");
        assertEquals(1, array.getSize());

        array.put("second", "Maria");
        assertEquals(2, array.getSize());
    }

    @Test
    void replaceValue() {
        var array = new AssociativeArray<String, String>();
        array.put("first", "Anna");
        assertEquals(1, array.getSize());

        array.put("first", "Maria");
        assertEquals("Maria", array.get("first"));
        assertEquals(1, array.getSize());
    }

    @Test
    void getValue() {
        var array = new AssociativeArray<String, String>();
        array.put("first", "Anna");
        assertEquals("Anna", array.get("first"));
        assertEquals(1, array.getSize());
    }

    @Test
    void getValueByNonExistingKey() {
        var array = new AssociativeArray<String, String>();
        assertNull(array.get("first"));
    }

    @Test
    void containsValue() {
        var array = new AssociativeArray<String, String>();
        array.put("first", "Anna");
        assertTrue(array.contains("Anna"));
        assertFalse(array.contains("Maria"));
    }
}
