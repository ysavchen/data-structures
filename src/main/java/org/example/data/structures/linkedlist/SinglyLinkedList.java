package org.example.data.structures.linkedlist;

import java.util.Objects;

/**
 * Несортированный односвязный список
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head = null;

    private int numberOfElements = 0;

    public SinglyLinkedList() {
    }

    public T getFirstElement() {
        return head.data;
    }

    public void insertToFront(T data) {
        var node = new Node<>(data);
        if (head != null) {
            node.appendNode(head);
        }
        head = node;
        numberOfElements++;
    }

    public void insertToBack(T data) {
        var node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> currentNode = head;
            while (currentNode.hasNextNode()) {
                currentNode = currentNode.nextNode();
            }
            currentNode.appendNode(node);
        }
        numberOfElements++;
    }

    private Node<T> searchNode(T data) {
        var currentNode = head;
        while (currentNode.hasNextNode()) {
            if (Objects.equals(currentNode.getData(), data)) {
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    private static class Node<T> {

        private final T data;

        private Node<T> nextNode = null;

        Node(T data) {
            this.data = data;
        }

        T getData() {
            return data;
        }

        Node<T> getNextNode() {
            return nextNode;
        }

        boolean hasNextNode() {
            return nextNode != null;
        }

        void appendNode(Node<T> node) {
            nextNode = node;
        }

        public Node<T> nextNode() {
            return nextNode;
        }
    }
}
