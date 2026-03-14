package org.example.data.structures.queue;

public interface Queue<T> {

    boolean enqueue(T element);

    T dequeue();

    boolean isEmpty();

    int getSize();

}
