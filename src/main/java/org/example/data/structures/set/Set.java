package org.example.data.structures.set;

public interface Set<T> {

    boolean add(T element);

    boolean contains(T element);

    boolean delete(T element);

    int getSize();

}
