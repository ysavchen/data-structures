package org.example.data.structures.associative.array;

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

    @Override
    public V get(K key) {
        int bucketIndex = key.hashCode() % nodes.length;
        var current = nodes[bucketIndex];
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }

        int index = key.hashCode() % nodes.length;
        Node<K, V> newNode = new Node<>(key, value);

        var current = nodes[index];
        if (current == null) {
            nodes[index] = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(V value) {
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
