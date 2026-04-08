package org.example.data.structures.associative.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Хеш-таблица на основе массива с разрешением конфликтов методом цепочек
 * <p>
 * Амортизированная сложность операций над хеш-таблицами составляет O(1).
 */
public class HashTable<K, V> implements Map<K, V> {

    private static class Pair<K, V> {
        private final K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Массив содержит бакеты, каждый бакет содержит список элементов.
     * <pre>{@code
     * 0 -> LinkedList<Pair<K, V>>
     * 1 -> LinkedList<Pair<K, V>>
     * 2 -> LinkedList<Pair<K, V>>
     * }</pre>
     */
    private final List<Pair<K, V>> pairs;

    public HashTable() {
        this.pairs = new ArrayList<>();
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public boolean contains(V value) {
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
