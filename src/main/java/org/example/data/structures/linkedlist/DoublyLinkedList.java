package org.example.data.structures.linkedlist;

/**
 * Несортированный двусвязный список
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node<T> head = null;

    private Node<T> tail = null;

    private int size = 0;

    public DoublyLinkedList() {
    }

    @Override
    public T getFirstElement() {
        return isEmpty() ? null : head.value;
    }

    @Override
    public T getLastElement() {
        return isEmpty() ? null : tail.value;
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
        size++;
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
        size++;
    }

    /**
     * Время работы: O(n)
     *
     * @return true если узел успешно удален, false - если узел не найден
     */
    @Override
    public boolean delete(T value) {
        var node = searchNode(value);
        if (node == null) {
            return false;
        }
        if (node.previousNode == null) {    // удаление первого узла (head)
            head = node.nextNode;
            if (head == null) {
                tail = null;
            } else {
                head.prepend(null);
            }
        } else if (node.nextNode == null) { // удаление последнего узла (tail)
            tail = node.previousNode;
            tail.append(null);
        } else {                            // типичный случай
            node.previousNode.append(node.nextNode);
        }
        return true;
    }

    private Node<T> searchNode(T value) {
        var current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.nextNode;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
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

        void prepend(Node<T> node) {
            previousNode = node;
        }
    }
}
