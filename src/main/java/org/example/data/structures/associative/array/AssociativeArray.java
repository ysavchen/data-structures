package org.example.data.structures.associative.array;

import java.util.Objects;

/**
 * Ассоциативный массив со сложностью операций O(n)
 */
public class AssociativeArray<K, V> implements Map<K, V> {

    private static class Pair<K, V> {
        private final K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Массив содержит бакеты, каждый бакет содержит элемент.<br/>
     * В случае коллизии элемент затирается новой записью.
     * <pre>{@code
     * 0 -> Pair<K, V>
     * 1 -> Pair<K, V>
     * 2 -> Pair<K, V>
     * }</pre>
     */
    private final Pair<K, V>[] pairs;

    private int size;

    public AssociativeArray() {
        this.pairs = new Pair[10];
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> entry : pairs) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        for (Pair<K, V> entry : pairs) {
            if (entry == null) {
                break;
            }

            if (Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }

        Pair<K, V> entry = new Pair<>(key, value);
        pairs[size] = entry;
        size++;
    }

    @Override
    public boolean contains(V value) {
        for (Pair<K, V> entry : pairs) {
            if (entry == null) {
                return false;
            }

            if (Objects.equals(entry.value, value)) {
                return true;
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
