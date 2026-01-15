package org.example.data.structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinglyLinkedListTests {

    @Test
    void createLinkedList() {
        var list = new SinglyLinkedList<String>();
        assertEquals(0, list.getNumberOfElements());
    }
}
