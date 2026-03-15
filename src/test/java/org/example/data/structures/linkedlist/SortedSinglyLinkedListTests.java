package org.example.data.structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedSinglyLinkedListTests {

    @Test
    void createLinkedList() {
        var list = new SortedSinglyLinkedList<String>();
        assertEquals(0, list.getSize());
    }

    @Test
    void addHeadElement() {
        var list = new SortedSinglyLinkedList<String>();
        var anna = "Anna";
        list.add(anna);
        assertEquals(1, list.getSize());
        assertEquals(anna, list.getFirstElement());
    }

    @Test
    void addTailElement() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Anna");
        list.add("Elena");
        assertEquals(2, list.getSize());
        assertEquals("Anna", list.getFirstElement());
        assertEquals("Elena", list.getLastElement());
    }

    @Test
    void sortToMiddle() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Anna");
        list.add("Maria");
        list.add("Elena");
        assertEquals(3, list.getSize());
        assertEquals("Anna", list.getFirstElement());
        assertEquals("Maria", list.getLastElement());
    }

    @Test
    void sortToHead() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Elena");
        list.add("Anna");
        assertEquals(2, list.getSize());
        assertEquals("Anna", list.getFirstElement());
    }
}
