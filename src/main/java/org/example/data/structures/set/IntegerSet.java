package org.example.data.structures.set;

/**
 * Множество целых чисел
 */
public class IntegerSet implements Set<Integer> {

    /**
     * Хеш-таблица с разрешением коллизий методом цепочек.<br/>
     * Первый массив содержит бакеты, каждый бакет содержит список элементов (в виде массива).
     * <pre>{@code
     * 0 -> int[]
     * 1 -> int[]
     * 2 -> int[]
     * }</pre>
     */
    private final Integer[][] hashTable;

    private final int capacity;

    private int size;

    public IntegerSet(int capacity) {
        this.hashTable = new Integer[capacity][capacity];
        this.capacity = capacity;
    }

    /**
     * Для Integer hashCode == value
     */
    @Override
    public boolean add(Integer element) {
        Integer[] bucket = hashTable[element % capacity];
        for (Integer cell : bucket) {
            if (cell != null && cell.equals(element)) {
                return false; // не добавляем дубликат во множество
            } else if (cell == null) {
                cell = element;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Integer element) {
        Integer[] bucket = hashTable[element % capacity];
        for (Integer cell : bucket) {
            if (cell == null) {
                return false;
            } else if (cell.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Integer element) {
        Integer[] bucket = hashTable[element % capacity];
        int index = 0;
        for (Integer cell : bucket) {
            if (cell == null) {
                return false;
            } else if (cell.equals(element)) {
                int lastElementIndex = bucket.length - 1;
                if (index == lastElementIndex) {
                    bucket[index] = null;
                } else {
                    bucket[index] = bucket[lastElementIndex];
                    bucket[lastElementIndex] = null;
                }
                size--;
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer[] bucket : hashTable) {
            int index = 0;
            for (Integer integer : bucket) {
                builder.append(integer);
                if (index != bucket.length - 1) {
                    builder.append(", ");
                }
                index++;
            }
        }
        return builder.toString();
    }
}
