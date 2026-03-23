package org.example.data.structures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticArrayQueueTests {

    @Test
    void createQueue() {
        var queue = new StaticArrayQueue<String>(1);
        assertEquals(0, queue.getSize());
    }

    @Test
    void enqueueElements() {
        var queue = new StaticArrayQueue<String>(2);
        assertTrue(queue.enqueue("Anna"));
        assertEquals(1, queue.getSize());
        assertTrue(queue.enqueue("Elena"));
        assertEquals(2, queue.getSize());
    }

    @Test
    void enqueueElementToFullQueue() {
        var queue = new StaticArrayQueue<String>(1);
        assertTrue(queue.enqueue("Anna"));
        assertFalse(queue.enqueue("Elena"));
    }

    @Test
    void dequeueElements() {
        var queue = new StaticArrayQueue<String>(2);
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
        var queue = new StaticArrayQueue<String>(1);
        assertNull(queue.dequeue());
        assertEquals(0, queue.getSize());
    }
}
