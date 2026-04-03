package org.example.data.structures.associative.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Хеш-таблица на основе массива с разрешением конфликтов методом цепочек
 * <p>
 * Средняя сложность операций над хеш-таблицами составляет O(1 + α), где a - коэффициент заполнения хеш-таблицы.
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
