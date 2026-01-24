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
}
