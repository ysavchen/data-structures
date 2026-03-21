package org.example.data.structures.linkedlist;

/**
 * Отсортированный односвязный список<br/>
 * Для операций со связными списками все равно нужно перебирать элементы, поэтому сортировка не приносит особой пользы.
 */
public class SortedSinglyLinkedList<T extends Comparable<T>> implements SortedLinkedList<T> {

    private static class Node<T> {
        private final T value;
        private Node<T> nextNode = null;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head = null;

    private int size = 0;

    public SortedSinglyLinkedList() {
    }

    @Override
    public T getFirstElement() {
        return isEmpty() ? null : head.value;
    }

    @Override
    public T getLastElement() {
        if (head == null) {
            return null;
        }

        Node<T> current = head;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        return current.value;
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
            Node<T> newNode = new Node<>(value);
            while (current != null) {
                if (current.value.compareTo(value) >= 0) { // current.value >= value
                    if (previous == null) { // граничный случай: добавляем элемент в начало списка
                        head = newNode;
                    } else {
                        previous.nextNode = newNode; // основной случай: добавляем элемент в середину списка
                    }
                    newNode.nextNode = current;
                    break;
                }
                previous = current;
                current = current.nextNode;
            }

            if (current == null) { // граничный случай: добавляем элемент в конец списка
                previous.nextNode = newNode;
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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
