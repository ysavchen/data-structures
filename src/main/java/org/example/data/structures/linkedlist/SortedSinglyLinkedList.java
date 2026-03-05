package org.example.data.structures.linkedlist;

/**
 * Отсортированный односвязный список<br/>
 * Для операций со связными списками все равно нужно перебирать элементы, поэтому сортировка не приносит особой пользы.
 */
public class SortedSinglyLinkedList<T extends Comparable<T>> implements SortedLinkedList<T> {

    private Node<T> head = null;

    private int numberOfElements = 0;

    public SortedSinglyLinkedList() {
    }

    /**
     * Вставка элемента в отсортированный список<br/>
     * Так как список отсортирован необходимо перебрать элементы, чтобы найти правильное место для вставки узла с новым значением.
     * <p>
     * Время работы: O(n)
     *
     * @return index
     */
    @Override
    public int add(T value) {
        int index = 0;

        if (head == null) {
            head = new Node<>(index, value);
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current != null) {
                if (current.value.compareTo(value) >= 0) {
                    var node = new Node<>(index, value);
                    if (previous != null) {
                        previous.append(node);
                    } else {
                        head = node;
                        node.append(current);
                    }
                    break;
                } else {
                    previous = current;
                    current = current.nextNode;
                    index++;
                }
            }

        }
        numberOfElements++;
        return index;
    }

    @Override
    public int getByIndex(int index) {
        return 0;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    private static class Node<T> {

        private int index;
        private final T value;
        private Node<T> nextNode;

        Node(int index, T value) {
            this.index = index;
            this.value = value;
            this.nextNode = null;
        }

        boolean hasNextNode() {
            return nextNode != null;
        }

        void append(Node<T> node) {
            nextNode = node;
        }
    }
}
