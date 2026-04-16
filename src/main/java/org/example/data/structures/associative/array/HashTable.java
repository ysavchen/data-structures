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

    // todo: сделать увеличение размера хеш-таблицы
    private static final int INITIAL_CAPACITY = 17;

    private int size;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        this.nodes = new Node[initialCapacity];
    }

    /**
     * Хеш-функция отображает множество значений {@code key} на множество бакетов хеш-таблицы
     *
     * @return int индекс бакета хеш-таблицы
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % nodes.length;
    }

    /**
     * Найденный элемент перемещается в начало цепочки (MTF)
     */
    @Override
    public V get(K key) {
        int index = hash(key);
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
        int index = hash(key);
        var head = nodes[index];
        if (head != null) {
            newNode.next = head;
        }
        nodes[index] = newNode;

        size++;
        return true;
    }

    private Node<K, V> search(K key) {
        var current = nodes[hash(key)];

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
        for (var current : nodes) {
            while (current != null) {
                if (Objects.equals(current.value, value)) {
                    return true;
                }
                current = current.next;
            }
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
