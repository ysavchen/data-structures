package org.example.data.structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTests {

    @Test
    void createLinkedList() {
        var list = new DoublyLinkedList<String>();
        assertEquals(0, list.getNumberOfElements());
    }

    @Test
    void insertToFront() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToFront(anna);
        assertEquals(1, list.getNumberOfElements());
        assertEquals(anna, list.getFirstElement());
        assertEquals(anna, list.getLastElement());

        list.insertToFront(elena);
        assertEquals(2, list.getNumberOfElements());
        assertEquals(elena, list.getFirstElement());
        assertEquals(anna, list.getLastElement());
    }

    @Test
    void insertToBack() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToBack(anna);
        assertEquals(1, list.getNumberOfElements());
        assertEquals(anna, list.getFirstElement());
        assertEquals(anna, list.getLastElement());

        list.insertToBack(elena);
        assertEquals(2, list.getNumberOfElements());
        assertEquals(anna, list.getFirstElement());
        assertEquals(elena, list.getLastElement());
    }
}
