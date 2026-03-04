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
        return head.value;
    }

    @Override
    public T getLastElement() {
        return tail.value;
    }

    @Override
    public void insertToFront(T value) {
        var node = new Node<>(value);
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
    public void insertToBack(T value) {
        var node = new Node<>(value);
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
    public boolean delete(T value) {
        return false;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    private static class Node<T> {

        private final T value;

        private Node<T> nextNode = null;

        private Node<T> previousNode = null;

        Node(T value) {
            this.value = value;
        }

        void append(Node<T> node) {
            nextNode = node;
        }
    }
}
