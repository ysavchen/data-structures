package org.example.data.structures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListQueueTests {

    @Test
    void createQueue() {
        var queue = new LinkedListQueue<String>();
        assertEquals(0, queue.getSize());
    }

    @Test
    void enqueueElements() {
        var queue = new LinkedListQueue<String>();
        assertTrue(queue.enqueue("Anna"));
        assertEquals(1, queue.getSize());
        assertTrue(queue.enqueue("Elena"));
        assertEquals(2, queue.getSize());
    }

    @Test
    void dequeueElements() {
        var queue = new LinkedListQueue<String>();
        queue.enqueue("Anna");
        queue.enqueue("Elena");
        assertEquals(2, queue.getSize());

        assertEquals("Anna", queue.dequeue());
        assertEquals(1, queue.getSize());
        assertEquals("Elena", queue.dequeue());
        assertEquals(0, queue.getSize());
    }

    @Test
    void dequeueElementFromEmptyQueue() {
        var queue = new LinkedListQueue<String>();
        assertNull(queue.dequeue());
        assertEquals(0, queue.getSize());
    }
}
