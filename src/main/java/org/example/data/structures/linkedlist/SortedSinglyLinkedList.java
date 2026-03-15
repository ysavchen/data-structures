package org.example.data.structures.linkedlist;

/**
 * Отсортированный односвязный список<br/>
 * Для операций со связными списками все равно нужно перебирать элементы, поэтому сортировка не приносит особой пользы.
 */
public class SortedSinglyLinkedList<T extends Comparable<T>> implements SortedLinkedList<T> {

    private Node<T> head = null;

    private int size = 0;

    public SortedSinglyLinkedList() {
    }

    /**
     * Вставка элемента в отсортированный список<br/>
     * Так как список отсортирован необходимо перебрать элементы, чтобы найти правильное место для вставки узла с новым значением.
     * <p>
     * Время работы: O(n)
     */
    @Override
    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current != null) {
                if (current.value.compareTo(value) >= 0) {
                    var node = new Node<>(value);
                    if (previous != null) {
                        previous.nextNode = node;
                    } else {
                        head = node;
                        node.nextNode = current;
                    }
                    break;
                } else {
                    previous = current;
                    current = current.nextNode;
                }
            }

        }
        size++;
    }

    @Override
    public T findElement(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(element)) {
                return current.value;
            }
            current = current.nextNode;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    private static class Node<T> {

        private final T value;
        private Node<T> nextNode = null;

        Node(T value) {
            this.value = value;
        }
    }
}
