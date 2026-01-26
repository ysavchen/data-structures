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
     * @return позиция вставки в список
     */
    @Override
    public int add(T data) {
        int position = 1;  // позиции элементов начинаются с 1

        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current != null) {
                if (current.data.compareTo(data) >= 0) {
                    var node = new Node<>(data);
                    if (previous != null) {
                        previous.append(node);
                    }
                    node.append(current);
                } else {
                    previous = current;
                    current = current.nextNode;
                    position++;
                }
            }

        }
        numberOfElements++;
        return position;
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
