package org.example.data.structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SortedSinglyLinkedListTests {

    @Test
    void createLinkedList() {
        var list = new SortedSinglyLinkedList<String>();
        assertEquals(0, list.getSize());
    }

    @Test
    void addHeadElement() {
        var list = new SortedSinglyLinkedList<String>();
        int index = list.add("Anna");
        assertEquals(1, list.getSize());
        assertEquals(0, index);
    }

    @Test
    void addTailElement() {
        var list = new SortedSinglyLinkedList<String>();
        int annaIndex = list.add("Anna");
        int elenaIndex = list.add("Elena");
        assertEquals(2, list.getSize());
        assertEquals(0, annaIndex);
        assertEquals(1, elenaIndex);
    }

    @Test
    void sortToMiddle() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Anna");
        list.add("Maria");
        int elenaIndex = list.add("Elena");
        assertEquals(3, list.getSize());
        assertEquals(1, elenaIndex);
    }

    @Test
    void sortToHead() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Elena");
        int annaIndex = list.add("Anna");
        assertEquals(2, list.getSize());
        assertEquals(0, annaIndex);
    }

    @Test
    void getByIndex() {
        var list = new SortedSinglyLinkedList<String>();
        int annaIndex = list.add("Anna");
        int elenaIndex = list.add("Elena");
        assertEquals("Anna", list.getByIndex(annaIndex));
        assertEquals("Elena", list.getByIndex(elenaIndex));
    }

    @Test
    void getByIndexSorted() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Elena");
        list.add("Anna");
        assertEquals("Anna", list.getByIndex(0));
        assertEquals("Elena", list.getByIndex(1));
    }

    @Test
    void getByNegativeIndex() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Anna");
        assertNull(list.getByIndex(-1));
    }

    @Test
    void getByNonExistingIndex() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Anna");
        assertNull(list.getByIndex(5));
    }
}
