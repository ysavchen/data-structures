package org.example.data.structures.linkedlist;

/**
 * Несортированный односвязный список
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head = null;

    private int size = 0;

    public SinglyLinkedList() {
    }

    @Override
    public T getFirstElement() {
        return isEmpty() ? null : head.value;
    }

    @Override
    public T getLastElement() {
        Node<T> current = head;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        return current.value;
    }

    @Override
    public void insertToFront(T value) {
        var node = new Node<>(value);
        if (head != null) {
            node.nextNode = head;
        }
        head = node;
        size++;
    }

    @Override
    public void insertToBack(T value) {
        var node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = node;
        }
        size++;
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
    public boolean delete(T value) {
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.value.equals(value)) {
                if (previous == null) {
                    head = current.nextNode; // граничный случай: удаление головы списка
                } else {
                    previous.nextNode = current.nextNode; // основной случай: узел в середине списка (или в хвосте)
                }
                size--;
                return true;
            }
            previous = current;
            current = current.nextNode;
        }
        return false;
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

        Node(T value) {
            this.value = value;
        }
    }
}
