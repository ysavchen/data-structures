package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTests {

    @Test
    void createArray() {
        var array = new DynamicArrayImpl<String>();
        assertEquals(10, array.getCapacity());
        assertEquals(0, array.getSize());
    }

    @Test
    void createArrayWithInitialCapacity() {
        var array = new DynamicArrayImpl<String>(15);
        assertEquals(15, array.getCapacity());
        assertEquals(0, array.getSize());
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
        assertEquals(1, array.getCapacity());
        assertEquals(1, array.getSize());
    }

    @Test
    void doubleSize() {
        var array = new DynamicArrayImpl<String>(2);
        array.addElement("Anna");
        array.addElement("Elena");
        assertEquals(2, array.getCapacity());
        assertEquals(2, array.getSize());

        int index = array.addElement("Maria");
        assertEquals(2, index);
        assertEquals(4, array.getCapacity());
        assertEquals(3, array.getSize());
    }

    @Test
    void deleteElementByIndex() {
        var array = new DynamicArrayImpl<String>(1);
        int index = array.addElement("Anna");
        assertEquals(1, array.getCapacity());
        assertEquals(1, array.getSize());

        array.deleteByIndex(index);
        assertEquals(0, array.getCapacity());
        assertEquals(0, array.getSize());
        assertTrue(array.isEmpty());
    }

    @Test
    void deleteElementFromMiddleOfArray() {
        var array = new DynamicArrayImpl<String>(3);
        int annaIndex = array.addElement("Anna");
        int elenaIndex = array.addElement("Elena");
        int mariaIndex = array.addElement("Maria");
        assertEquals(0, annaIndex);
        assertEquals(1, elenaIndex);
        assertEquals(2, mariaIndex);

        array.deleteByIndex(elenaIndex);
        annaIndex = array.findElement("Anna");
        elenaIndex = array.findElement("Elena");
        mariaIndex = array.findElement("Maria");
        assertEquals(0, annaIndex);
        assertEquals(-1, elenaIndex);
        assertEquals(1, mariaIndex);
    }

    @Test
    void halveSize() {
        var array = new DynamicArrayImpl<String>(8);
        array.addElement("Anna");
        array.addElement("Elena");
        int mariaIndex = array.addElement("Maria");
        assertEquals(8, array.getCapacity());
        assertEquals(3, array.getSize());

        array.deleteByIndex(mariaIndex);
        assertEquals(4, array.getCapacity());
        assertEquals(2, array.getSize());
    }

    @Test
    void deleteElementFromEmptyArray() {
        var array = new DynamicArrayImpl<String>(1);
        assertThrows(EmptyArrayException.class, () -> array.deleteByIndex(0));
    }
}
