package org.example.data.structures.stack;

import org.example.data.structures.linkedlist.SinglyLinkedList;

/**
 * Стек на основе односвязного списка
 */
public class LinkedListStack<T> implements Stack<T> {

    private final SinglyLinkedList<T> list;

    public LinkedListStack() {
        list = new SinglyLinkedList<>();
    }

    @Override
    public void push(T item) {
        list.insertToFront(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T element = list.getFirstElement();
        list.delete(element);
        return element;
    }

    @Override
    public T peek() {
        return list.getFirstElement();
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
