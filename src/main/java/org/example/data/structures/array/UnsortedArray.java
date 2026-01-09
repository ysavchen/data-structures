package org.example.data.structures.array;

import java.util.function.Consumer;

public interface UnsortedArray<T> {

    T getElement(int index);

    int findElement(T element);

    void traverse(Consumer<T> consumer);

    int addElement(T element);

    void deleteByIndex(T element);

    int getSize();

    int getNumberOfElements();

}
