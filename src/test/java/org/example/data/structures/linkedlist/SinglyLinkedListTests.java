package org.example.data.structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinglyLinkedListTests {

    @Test
    void createLinkedList() {
        var list = new SinglyLinkedList<String>();
        assertEquals(0, list.getNumberOfElements());
    }

    @Test
    void insertToFront() {
        var list = new SinglyLinkedList<String>();
        list.insertToFront("Anna");
        assertEquals(1, list.getNumberOfElements());
        assertEquals("Anna", list.getFirstElement());

        list.insertToFront("Elena");
        assertEquals(2, list.getNumberOfElements());
        assertEquals("Elena", list.getFirstElement());
    }
}
