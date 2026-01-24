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

    @Override
    public T getFirstElement() {
        return head.data;
    }

    @Override
    public T getLastElement() {
        Node<T> current = head;
        while (current.hasNextNode()) {
            current = current.nextNode;
        }
        return current.data;
    }

    @Override
    public void insertToFront(T data) {
        var node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            node.append(head);
        }
        numberOfElements++;
    }

    @Override
    public void insertToBack(T data) {
        var node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.hasNextNode()) {
                current = current.nextNode;
            }
            current.append(node);
        }
        numberOfElements++;
    }

    /**
     * Для удаления элемента нужно найти удаляемый узел, и обновить ссылку у предыдущего узла.<br/>
     * То есть previousNode ссылается на nextNode удаляемого узла.
     * <p>
     * Граничные случаи:<br/>
     * 1. Если удаляется последний узел, то предыдущему узлу нужно присвоить null<br/>
     * 2. Если удаляется первый узел (head), то необходимо обновить head списка
     * <p>
     * Время работы: O(n)
     */
    @Override
    public boolean delete(T data) {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.data.equals(data)) {
                if (previous == null) {
                    head = current.nextNode; // граничный случай: удаление головы списка
                } else {
                    previous.append(current.nextNode); // стандартный случай: узел в середине списка (или в хвосте)
                }
                numberOfElements--;
                return true;
            }
            previous = current;
            current = current.nextNode;
        }
        return false;
    }

    private Node<T> searchNode(T data) {
        var current = head;
        while (current.hasNextNode()) {
            if (Objects.equals(current.data, data)) {
                return current;
            }
            current = current.nextNode;
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

        boolean hasNextNode() {
            return nextNode != null;
        }

        void append(Node<T> node) {
            nextNode = node;
        }
    }
}
