package org.example.data.structures.associative.array;

import java.util.ArrayList;
import java.util.List;

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
    private final List<Pair<K, V>> pairs;

    public AssociativeArray() {
        this.pairs = new ArrayList<>();
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
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        Pair<K, V> entry = new Pair<>(key, value);
        pairs.add(entry);
    }

    @Override
    public boolean contains(V value) {
        for (Pair<K, V> entry : pairs) {
            if (entry.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return pairs.isEmpty();
    }

    @Override
    public int getSize() {
        return pairs.size();
    }
}
