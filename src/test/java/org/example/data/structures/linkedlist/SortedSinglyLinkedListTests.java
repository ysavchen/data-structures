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
        int position = list.add("Anna");
        assertEquals(1, list.getNumberOfElements());
        assertEquals(1, position);
    }

    @Test
    void addTailElement() {
        var list = new SortedSinglyLinkedList<String>();
        int annaPosition = list.add("Anna");
        int elenaPosition = list.add("Elena");
        assertEquals(2, list.getNumberOfElements());
        assertEquals(1, annaPosition);
        assertEquals(2, elenaPosition);
    }

    @Test
    void sortToMiddle() {
        var list = new SortedSinglyLinkedList<String>();
        list.add("Anna");
        list.add("Maria");
        int elenaPosition = list.add("Elena");
        assertEquals(3, list.getNumberOfElements());
        assertEquals(2, elenaPosition);
    }
}
