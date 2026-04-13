package org.example.data.structures.associative.array;

import java.util.Objects;

/**
 * Хеш-таблица на основе массива с разрешением конфликтов методом цепочек
 * <p>
 * Амортизированная сложность операций c хеш-таблицей составляет O(1).
 */
public class HashTable<K, V> implements Map<K, V> {

    private static class Node<K, V> {
        private final K key;
        private V value;

        private Node<K, V> next = null;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Массив содержит бакеты, каждый бакет содержит список элементов.
     * <pre>{@code
     * 0 -> Node<K, V>
     * 1 -> Node<K, V>
     * 2 -> Node<K, V> -> Node<K, V>
     * }</pre>
     */
    private final Node<K, V>[] nodes;

    private static final int INITIAL_CAPACITY = 10;

    private int size;

    public HashTable() {
        this.nodes = new Node[INITIAL_CAPACITY];
    }

    /**
     * Найденный элемент перемещается в начало цепочки (MTF)
     */
    @Override
    public V get(K key) {
        int index = key.hashCode() % nodes.length;
        Node<K, V> current = nodes[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous != null) {
                    previous.next = current.next;
                    current.next = nodes[index];
                    nodes[index] = current;
                }
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }

    @Override
    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }

        // если существует узел с таким ключом, то заменяем value
        var node = search(key);
        if (node != null) {
            node.value = value;
            return true;
        }

        // добавляем новый узел в начало списка
        var newNode = new Node<>(key, value);
        int index = key.hashCode() % nodes.length;
        var current = nodes[index];
        if (current != null) {
            newNode.next = current;
        }
        nodes[index] = newNode;

        size++;
        return true;
    }

    private Node<K, V> search(K key) {
        int index = key.hashCode() % nodes.length;
        var current = nodes[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(V value) {
        var current = nodes[0];
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
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
}
