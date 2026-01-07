package org.example.data.structures.stack;

import org.example.data.structures.stack.exception.EmptyStackException;
import org.example.data.structures.stack.exception.FullStackException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaticArrayStackTests {

    @Test
    void createStackWithSize() {
        var stack = new StaticArrayStack(1);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushToFullStack() {
        var stack = new StaticArrayStack(1);
        stack.push(1);
        assertThrows(FullStackException.class, () -> stack.push(2));
    }

    @Test
    void peekFromStack() {
        var stack = new StaticArrayStack(2);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peekFromEmptyStack() {
        var stack = new StaticArrayStack(1);
        assertThrows(EmptyStackException.class, stack::pop);
    }

}
