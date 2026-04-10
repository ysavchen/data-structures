package org.example.data.structures.associative.array;

/**
 * Хеш-таблица на основе массива с разрешением конфликтов методом цепочек
 * <p>
 * Амортизированная сложность операций c хеш-таблицей составляет O(1).
 */
public class HashTable<K, V> implements Map<K, V> {

    private static class Pair<K, V> {
        private final K key;
        private V value;

        private Pair<K, V> next = null;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Массив содержит бакеты, каждый бакет содержит список элементов.
     * <pre>{@code
     * 0 -> Pair<K, V>
     * 1 -> Pair<K, V>
     * 2 -> Pair<K, V> -> Pair<K, V>
     * }</pre>
     */
    private final Pair<K, V>[] pairs;

    private static final int INITIAL_CAPACITY = 10;

    private int size;

    public HashTable() {
        this.pairs = new Pair[INITIAL_CAPACITY];
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {
        int bucketIndex = key.hashCode() % pairs.length;
        Pair<K, V> newPair = new Pair<>(key, value);

        var current = pairs[bucketIndex];
        if (current == null) {
            pairs[bucketIndex] = newPair;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPair;
        }
        size++;
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
