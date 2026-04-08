package org.example.data.structures.set;

public interface Set<T> {

    void add(T element);

    boolean contains(T element);

    void delete(T element);

    int getSize();

}
