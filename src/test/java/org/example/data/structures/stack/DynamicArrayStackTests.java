package org.example.data.structures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DynamicArrayStackTests {

    @Test
    void createStack() {
        var stack = new DynamicArrayStack<String>();
        assertEquals(0, stack.getSize());
    }

    @Test
    void pushElements() {
        var stack = new DynamicArrayStack<String>();
        stack.push("Anna");
        assertEquals(1, stack.getSize());
        stack.push("Elena");
        assertEquals(2, stack.getSize());
    }

    @Test
    void popElementsFromStack() {
        var stack = new DynamicArrayStack<String>();
        stack.push("Anna");
        stack.push("Elena");
        assertEquals(2, stack.getSize());

        assertEquals("Elena", stack.pop());
        assertEquals(1, stack.getSize());
        assertEquals("Anna", stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    void popElementFromEmptyStack() {
        var stack = new DynamicArrayStack<String>();
        assertNull(stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    void peekElementFromStack() {
        var stack = new DynamicArrayStack<String>();
        stack.push("Anna");
        assertEquals("Anna", stack.peek());
        assertEquals(1, stack.getSize());
    }

    @Test
    void peekElementFromEmptyStack() {
        var stack = new DynamicArrayStack<String>();
        assertNull(stack.peek());
        assertEquals(0, stack.getSize());
    }
}
