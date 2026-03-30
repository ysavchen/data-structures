package org.example.data.structures.associative.array;

import org.example.data.structures.array.DynamicArray;
import org.example.data.structures.array.DynamicArrayImpl;

/**
 * Ассоциативный массив со сложностью операций O(n)
 */
public class AssociativeArray<K, V> implements Map<K, V> {

    private static class Entry<K, V> {
        private final K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final DynamicArray<Entry<K, V>> entries;

    public AssociativeArray() {
        this.entries = new DynamicArrayImpl<>();
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < entries.getSize(); i++) {
            Entry<K, V> entry = entries.getElement(i);
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void set(K key, V value) {
        for (int i = 0; i < entries.getSize(); i++) {
            Entry<K, V> entry = entries.getElement(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        Entry<K, V> entry = new Entry<>(key, value);
        entries.addElement(entry);
    }

    @Override
    public boolean contains(V value) {
        for (int i = 0; i < entries.getSize(); i++) {
            Entry<K, V> entry = entries.getElement(i);
            if (entry.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }
}
