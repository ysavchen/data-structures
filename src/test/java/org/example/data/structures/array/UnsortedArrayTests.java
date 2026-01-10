package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;
import org.example.data.structures.array.exception.FullArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnsortedArrayTests {

    @Test
    void createArray() {
        var array = new UnsortedArrayImpl<String>(1);
        assertEquals(1, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void createArrayWithZeroSize() {
        assertThrows(IllegalArgumentException.class, () -> new SortedArrayImpl<String>(0));
    }

    @Test
    void createArrayWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new UnsortedArrayImpl<String>(-1));
    }

    @Test
    void getElement() {
        var array = new UnsortedArrayImpl<String>(1);
        var element = "Anna";
        int index = array.addElement(element);
        assertEquals(element, array.getElement(index));
    }

    @Test
    void getNullElement() {
        var array = new UnsortedArrayImpl<String>(1);
        assertNull(array.getElement(0));
    }

    @Test
    void getElementByNegativeIndex() {
        var array = new UnsortedArrayImpl<String>(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.getElement(-1));
    }

    @Test
    void getElementOutOfBounds() {
        var array = new UnsortedArrayImpl<String>(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.getElement(1));
    }

    @Test
    void findElement() {
        var array = new UnsortedArrayImpl<String>(1);
        var element = "Anna";
        int index = array.addElement(element);
        assertEquals(index, array.findElement(element));
    }

    @Test
    void findNullElement() {
        var array = new UnsortedArrayImpl<String>(2);
        array.addElement("Anna");
        assertEquals(1, array.findElement(null));
    }

    @Test
    void findNonExistingElement() {
        var array = new UnsortedArrayImpl<String>(1);
        array.addElement("Anna");
        assertEquals(-1, array.findElement("Elena"));
    }

    @Test
    void addElement() {
        var array = new UnsortedArrayImpl<String>(1);
        int index = array.addElement("Anna");
        assertEquals(0, index);
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());
    }

    @Test
    void addElementToFullArray() {
        var array = new UnsortedArrayImpl<String>(1);
        array.addElement("Anna");
        assertThrows(FullArrayException.class, () -> array.addElement("Elena"));
    }

    @Test
    void deleteElement() {
        var array = new UnsortedArrayImpl<String>(1);
        array.addElement("Anna");
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());

        array.deleteByIndex(0);
        assertEquals(1, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void deleteElementFromEmptyArray() {
        var array = new UnsortedArrayImpl<String>(1);
        assertThrows(EmptyArrayException.class, () -> array.deleteByIndex(0));
    }
}
