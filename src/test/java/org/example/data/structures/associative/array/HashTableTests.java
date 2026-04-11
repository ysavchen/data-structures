package org.example.data.structures.associative.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashTableTests {

    @Test
    void createHashTable() {
        var table = new HashTable<String, String>();
        assertEquals(0, table.getSize());
    }

    @Test
    void putElement() {
        var table = new HashTable<String, String>();
        table.put("first", "Anna");
        assertEquals(1, table.getSize());
        table.put("second", "Anna");
        assertEquals(2, table.getSize());
    }
}
