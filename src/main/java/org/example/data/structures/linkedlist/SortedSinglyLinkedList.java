package org.example.data.structures.linkedlist;

/**
 * Отсортированный односвязный список<br/>
 * Для операций со связными списками все равно нужно перебирать элементы, поэтому сортировка не приносит особой пользы.
 */
public class SortedSinglyLinkedList<T extends Comparable<T>> implements SortedLinkedList<T> {

    private Node<T> head = null;

    public SortedSinglyLinkedList() {
    }

    @Override
    public void add(T element) {

    }

    @Override
    public int getPosition(T element) {
        return 0;
    }

    @Override
    public void delete(T element) {

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

        void appendNode(Node<T> node) {
            nextNode = node;
        }
    }
}
