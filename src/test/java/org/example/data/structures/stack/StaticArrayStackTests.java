package org.example.data.structures.stack;

import org.example.data.structures.stack.exception.FullStackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticArrayStackTests {

    @Test
    void createStack() {
        var stack = new StaticArrayStack<String>(1);
        assertEquals(0, stack.getSize());
    }

    @Test
    void pushElements() {
        var stack = new StaticArrayStack<String>(2);
        stack.push("Anna");
        assertEquals(1, stack.getSize());
        stack.push("Elena");
        assertEquals(2, stack.getSize());
    }

    @Test
    void pushElementToFullStack() {
        var stack = new StaticArrayStack<String>(1);
        stack.push("Anna");
        assertThrows(FullStackException.class, () -> stack.push("Elena"));
    }

    @Test
    void popElementsFromStack() {
        var stack = new StaticArrayStack<String>(2);
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
        var stack = new StaticArrayStack<String>(1);
        assertNull(stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    void peekElementFromStack() {
        var stack = new StaticArrayStack<String>(1);
        stack.push("Anna");
        assertEquals("Anna", stack.peek());
        assertEquals(1, stack.getSize());
    }

    @Test
    void peekElementFromEmptyStack() {
        var stack = new StaticArrayStack<String>(1);
        assertNull(stack.peek());
        assertEquals(0, stack.getSize());
    }

}
