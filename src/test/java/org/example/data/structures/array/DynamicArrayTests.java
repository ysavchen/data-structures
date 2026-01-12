package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTests {

    @Test
    void createArray() {
        var array = new DynamicArrayImpl<String>();
        assertEquals(10, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void createArrayWithInitialCapacity() {
        var array = new DynamicArrayImpl<String>(15);
        assertEquals(15, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void createArrayWithZeroInitialCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicArrayImpl<String>(0));
    }

    @Test
    void createArrayWithNegativeInitialCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicArrayImpl<String>(-1));
    }

    @Test
    void getElement() {
        var array = new DynamicArrayImpl<String>(1);
        var element = "Anna";
        int index = array.addElement(element);
        assertEquals(element, array.getElement(index));
    }

    @Test
    void getNullElement() {
        var array = new DynamicArrayImpl<String>(1);
        assertNull(array.getElement(0));
    }

    @Test
    void getElementByNegativeIndex() {
        var array = new DynamicArrayImpl<String>(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.getElement(-1));
    }

    @Test
    void getElementOutOfBounds() {
        var array = new DynamicArrayImpl<String>(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.getElement(1));
    }

    @Test
    void addElement() {
        var array = new DynamicArrayImpl<String>(1);
        int index = array.addElement("Anna");
        assertEquals(0, index);
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());
    }

    @Test
    void doubleSize() {
        var array = new DynamicArrayImpl<String>(2);
        array.addElement("Anna");
        array.addElement("Elena");
        assertEquals(2, array.getSize());
        assertEquals(2, array.getNumberOfElements());

        int index = array.addElement("Maria");
        assertEquals(2, index);
        assertEquals(4, array.getSize());
        assertEquals(3, array.getNumberOfElements());
    }

    @Test
    void deleteElementByIndex() {
        var array = new DynamicArrayImpl<String>(1);
        var element = "Anna";
        int index = array.addElement(element);
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());

        array.deleteByIndex(index);
        assertEquals(1, array.getSize());
        assertEquals(0, array.getNumberOfElements());
        assertTrue(array.isEmpty());
    }

    @Test
    void deleteElementFromMiddleOfArray() {

    }

    @Test
    void halveSize() {

    }

    @Test
    void deleteElementFromEmptyArray() {
        var array = new DynamicArrayImpl<String>(1);
        assertThrows(EmptyArrayException.class, () -> array.deleteByIndex(0));
    }
}
