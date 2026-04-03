package org.example.data.structures.associative.array;

public interface Map<K, V> {

    V get(K key);

    void put(K key, V value);

    boolean contains(V value);

    boolean isEmpty();

    int getSize();

}
