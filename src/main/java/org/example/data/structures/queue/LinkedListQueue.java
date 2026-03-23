package org.example.data.structures.queue;

import org.example.data.structures.linkedlist.DoublyLinkedList;

/**
 * Очередь на основе двусвязного списка
 */
public class LinkedListQueue<T> implements Queue<T> {

    private final DoublyLinkedList<T> list;

    public LinkedListQueue() {
        this.list = new DoublyLinkedList<>();
    }

    @Override
    public boolean enqueue(T element) {
        list.insertToBack(element);
        return true;
    }

    @Override
    public T dequeue() {
        T element = list.getFirstElement();
        list.delete(element);
        return element;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }
}
