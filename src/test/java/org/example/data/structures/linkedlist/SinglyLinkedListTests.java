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
        var anna = "Anna";
        var elena = "Elena";
        list.insertToFront(anna);
        assertEquals(1, list.getNumberOfElements());
        assertEquals(anna, list.getFirstElement());

        list.insertToFront(elena);
        assertEquals(2, list.getNumberOfElements());
        assertEquals(elena, list.getFirstElement());
    }

    @Test
    void insertToBack() {
        var list = new SinglyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToBack(anna);
        assertEquals(1, list.getNumberOfElements());
        assertEquals(anna, list.getLastElement());

        list.insertToBack(elena);
        assertEquals(2, list.getNumberOfElements());
        assertEquals(elena, list.getLastElement());
    }

    @Test
    void deleteFirstElement() {
        var list = new SinglyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToBack(anna);
        list.insertToBack(elena);

        list.delete(anna);
        assertEquals(1, list.getNumberOfElements());
        assertEquals(elena, list.getFirstElement());
    }

    @Test
    void deleteMiddleElement() {
        var list = new SinglyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        var maria = "Maria";
        list.insertToBack(anna);
        list.insertToBack(elena);
        list.insertToBack(maria);

        list.delete(elena);
        assertEquals(2, list.getNumberOfElements());
        assertEquals(anna, list.getFirstElement());
        assertEquals(maria, list.getLastElement());
    }

    @Test
    void deleteLastElement() {
        var list = new SinglyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToBack(anna);
        list.insertToBack(elena);

        list.delete(elena);
        assertEquals(1, list.getNumberOfElements());
        assertEquals(anna, list.getLastElement());
    }
}
