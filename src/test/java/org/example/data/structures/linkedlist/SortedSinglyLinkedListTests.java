package org.example.data.structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedSinglyLinkedListTests {

    @Test
    void createLinkedList() {
        var list = new SortedSinglyLinkedList<String>();
        assertEquals(0, list.getNumberOfElements());
    }

    @Test
    void addHeadElement() {
        var list = new SortedSinglyLinkedList<String>();
        int index = list.add("Anna");
        assertEquals(1, list.getNumberOfElements());
        assertEquals(0, index);
    }

    @Test
    void addTailElement() {
        var list = new SortedSinglyLinkedList<String>();
        int annaIndex = list.add("Anna");
        int elenaIndex = list.add("Elena");
        assertEquals(2, list.getNumberOfElements());
        assertEquals(0, annaIndex);
        assertEquals(1, elenaIndex);
    }

    @Test
    void sortToMiddle() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Anna");
        list.add("Maria");
        int elenaIndex = list.add("Elena");
        assertEquals(3, list.getNumberOfElements());
        assertEquals(1, elenaIndex);
    }

    @Test
    void sortToHead() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Elena");
        int annaIndex = list.add("Anna");
        assertEquals(2, list.getNumberOfElements());
        assertEquals(0, annaIndex);
    }
}
