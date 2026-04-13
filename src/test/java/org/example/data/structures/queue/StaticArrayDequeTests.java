package org.example.data.structures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticArrayDequeTests {

    @Test
    void createDeque() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 0, tailIndex: 0, size: 0, elements: [null, null, null]";
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushBack() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 0, tailIndex: 1, size: 2, elements: [52, 15, null]";
        deque.pushBack("52");
        deque.pushBack("15");
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushBackFull() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 0, tailIndex: 2, size: 3, elements: [52, 15, 7]";
        deque.pushBack("52");
        deque.pushBack("15");
        deque.pushBack("7");
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushBackToFullDeque() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 0, tailIndex: 2, size: 3, elements: [52, 15, 7]";
        deque.pushBack("52");
        deque.pushBack("15");
        deque.pushBack("7");
        assertFalse(deque.pushBack("24"));
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushFront() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 2, tailIndex: 0, size: 2, elements: [52, null, 15]";
        deque.pushFront("52");
        deque.pushFront("15");
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushFrontFull() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 1, tailIndex: 0, size: 3, elements: [52, 7, 15]";
        deque.pushFront("52");
        deque.pushFront("15");
        deque.pushFront("7");
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushFrontToFullDeque() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 1, tailIndex: 0, size: 3, elements: [52, 7, 15]";
        deque.pushFront("52");
        deque.pushFront("15");
        deque.pushFront("7");
        assertFalse(deque.pushFront("24"));
        assertEquals(expected, deque.toString());
    }

    @Test
    void popFrontEmptyDeque() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 0, tailIndex: 0, size: 0, elements: [null, null, null]";
        assertNull(deque.popFront());
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushBackPopFront() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 1, tailIndex: 1, size: 1, elements: [null, 15, null]";
        deque.pushBack("52");
        deque.pushBack("15");
        deque.popFront();
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushFrontPopFront() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 0, tailIndex: 0, size: 1, elements: [52, null, null]";
        deque.pushFront("52");
        deque.pushFront("15");
        deque.popFront();
        assertEquals(expected, deque.toString());
    }

    @Test
    void popBackEmptyDeque() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 0, tailIndex: 0, size: 0, elements: [null, null, null]";
        assertNull(deque.popBack());
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushBackPopBack() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 1, tailIndex: 1, size: 1, elements: [null, 15, null]";
        deque.pushBack("52");
        deque.pushBack("15");
        deque.popFront();
        assertEquals(expected, deque.toString());
    }

    @Test
    void pushFrontPopBack() {
        var deque = new StaticArrayDeque<String>(3);
        String expected = "headIndex: 2, tailIndex: 2, size: 1, elements: [null, null, 15]";
        deque.pushFront("52");
        deque.pushFront("15");
        deque.popBack();
        assertEquals(expected, deque.toString());
    }
}
