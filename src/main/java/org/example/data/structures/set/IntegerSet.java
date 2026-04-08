package org.example.data.structures.set;

public class IntegerSet implements Set<Integer> {

    private final Integer[][] elementData;

    private final int capacity;

    private int size;

    public IntegerSet(int capacity) {
        this.elementData = new Integer[capacity][capacity];
        this.capacity = capacity;
    }

    /**
     * При добавлении элемента в корзину, используется итерация по элементам для поиска пустой ячейки,
     * так как не известно, какая ячейка пустая, что создает время работы O(n), где n - количество ячеек в корзине.</br>
     * Можно создать класс Bucket c переменной size, и сразу будет известно, какая ячейка пустая,
     * но я решил сделать пример максимально простым.
     */
    @Override
    public void add(Integer element) {
        Integer[] bucket = elementData[element % capacity];
        for (Integer cell : bucket) {
            if (cell != null && cell.equals(element)) {
                return; // не добавляем дубликат во множество
            } else if (cell == null) {
                cell = element;
                size++;
                return;
            }
        }
    }

    @Override
    public boolean contains(Integer element) {
        Integer[] bucket = elementData[element % capacity];
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
    public void delete(Integer element) {
        Integer[] bucket = elementData[element % capacity];
        int index = 0;
        for (Integer cell : bucket) {
            if (cell == null) {
                return;
            } else if (cell.equals(element)) {
                int lastElementIndex = bucket.length - 1;
                if (index == lastElementIndex) {
                    bucket[index] = null;
                } else {
                    bucket[index] = bucket[lastElementIndex];
                    bucket[lastElementIndex] = null;
                }
                size--;
                return;
            }
            index++;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer[] bucket : elementData) {
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
