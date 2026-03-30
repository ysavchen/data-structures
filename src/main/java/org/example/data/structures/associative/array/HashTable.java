package org.example.data.structures.associative.array;

import org.example.data.structures.array.DynamicArray;
import org.example.data.structures.array.DynamicArrayImpl;

/**
 * Хеш-таблица на основе массива с разрешением конфликтов методом цепочек
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

    private final DynamicArray<Pair<K, V>> pairs;

    public HashTable() {
        this.pairs = new DynamicArrayImpl<>();
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V value) {

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
        return pairs.getSize();
    }
}
