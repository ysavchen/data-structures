package org.example.data.structures.linkedlist;

/**
 * Несортированный двусвязный список
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    private static class Node<T> {
        private final T value;
        private Node<T> next = null;
        private Node<T> previous = null;

        Node(T value) {
            this.value = value;
        }
    }

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
            node.next = head;
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
            tail.next = node;
            node.previous = tail;
        }
        tail = node;

        if (head == null) {
            head = node;
        }
        size++;
    }

    /**
     * Удаление элемента из списка
     * <p>
     * Время работы: O(n)
     *
     * @return {@code true} если узел успешно удален, {@code false} если узел не найден
     */
    @Override
    public boolean delete(T value) {
        var node = searchNode(value);
        if (node == null) {
            return false;
        }
        if (node.previous == null) {    // удаление первого узла (head)
            head = node.next;
            if (head == null) {
                tail = null;
            } else {
                head.previous = null;
            }
        } else if (node.next == null) { // удаление последнего узла (tail)
            tail = node.previous;
            tail.next = null;
        } else {                        // общий случай
            node.previous.next = node.next;
        }
        size--;
        return true;
    }

    private Node<T> searchNode(T value) {
        var current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
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
}
