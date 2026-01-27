package org.example.data.structures.linkedlist;

/**
 * Несортированный двусвязный список
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node<T> head = null;

    private Node<T> tail = null;

    private int numberOfElements = 0;

    public DoublyLinkedList() {
    }

    @Override
    public T getFirstElement() {
        return head.data;
    }

    @Override
    public T getLastElement() {
        return tail.data;
    }

    @Override
    public void insertToFront(T data) {
        var node = new Node<>(data);
        if (head != null) {
            node.append(head);
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
        numberOfElements++;
    }

    @Override
    public void insertToBack(T data) {
        var node = new Node<>(data);
        if (tail != null) {
            tail.append(node);
        }
        tail = node;

        if (head == null) {
            head = node;
        }
        numberOfElements++;
    }

    @Override
    public boolean delete(T data) {
        return false;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    private static class Node<T> {

        private final T data;

        private Node<T> nextNode = null;

        private Node<T> previousNode = null;

        Node(T data) {
            this.data = data;
        }

        void append(Node<T> node) {
            nextNode = node;
        }
    }
}
