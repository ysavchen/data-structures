package org.example.data.structures.array;

public interface DynamicArray<T> {

    T getElement(int index);

    int addElement(T element);

    void deleteByIndex(int index);

    boolean isEmpty();

    int getSize();

    int getNumberOfElements();

}
