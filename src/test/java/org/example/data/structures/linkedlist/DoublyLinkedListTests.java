package org.example.data.structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTests {

    @Test
    void createLinkedList() {
        var list = new DoublyLinkedList<String>();
        assertEquals(0, list.getSize());
    }

    @Test
    void insertToFront() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToFront(anna);
        assertEquals(1, list.getSize());
        assertEquals(anna, list.getFirstElement());
        assertEquals(anna, list.getLastElement());

        list.insertToFront(elena);
        assertEquals(2, list.getSize());
        assertEquals(elena, list.getFirstElement());
        assertEquals(anna, list.getLastElement());
    }

    @Test
    void insertToBack() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToBack(anna);
        assertEquals(1, list.getSize());
        assertEquals(anna, list.getFirstElement());
        assertEquals(anna, list.getLastElement());

        list.insertToBack(elena);
        assertEquals(2, list.getSize());
        assertEquals(anna, list.getFirstElement());
        assertEquals(elena, list.getLastElement());
    }

    @Test
    void deleteFirstElement() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToBack(anna);
        list.insertToBack(elena);

        var result = list.delete(anna);
        assertTrue(result);
        assertEquals(1, list.getSize());
        assertEquals(elena, list.getFirstElement());
        assertEquals(elena, list.getLastElement());
    }

    @Test
    void deleteMiddleElement() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        var maria = "Maria";
        list.insertToBack(anna);
        list.insertToBack(elena);
        list.insertToBack(maria);

        var result = list.delete(elena);
        assertTrue(result);
        assertEquals(2, list.getSize());
        assertEquals(anna, list.getFirstElement());
        assertEquals(maria, list.getLastElement());
    }

    @Test
    void deleteLastElement() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        var elena = "Elena";
        list.insertToBack(anna);
        list.insertToBack(elena);

        var result = list.delete(elena);
        assertTrue(result);
        assertEquals(1, list.getSize());
        assertEquals(anna, list.getLastElement());
    }

    @Test
    void deleteNonExistingElement() {
        var list = new DoublyLinkedList<String>();
        var anna = "Anna";
        list.insertToBack(anna);

        var result = list.delete("Elena");
        assertFalse(result);
        assertEquals(1, list.getSize());
    }
}
