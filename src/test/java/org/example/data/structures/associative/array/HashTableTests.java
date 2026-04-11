package org.example.data.structures.associative.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTests {

    @Test
    void createHashTable() {
        var table = new HashTable<String, String>();
        assertEquals(0, table.getSize());
    }

    @Test
    void putElement() {
        var table = new HashTable<String, String>();

        boolean annaResult = table.put("first", "Anna");
        assertEquals(1, table.getSize());
        assertTrue(annaResult);

        boolean mariaResult = table.put("second", "Maria");
        assertEquals(2, table.getSize());
        assertTrue(mariaResult);
    }

    @Test
    void putNullElement() {
        var table = new HashTable<String, String>();

        boolean firstResult = table.put("first", null);
        assertEquals(1, table.getSize());
        assertTrue(firstResult);

        boolean secondResult = table.put("second", null);
        assertEquals(2, table.getSize());
        assertTrue(secondResult);
    }

    @Test
    void putByNullKey() {
        var table = new HashTable<String, String>();
        boolean annaResult = table.put(null, "Anna");
        assertEquals(0, table.getSize());
        assertFalse(annaResult);
    }

    @Test
    void getElement() {

    }

    @Test
    void getElementByNonExistingKey() {

    }
}
