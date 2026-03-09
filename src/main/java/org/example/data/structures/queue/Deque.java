package org.example.data.structures.queue;

/**
 * Deque - double ended queue (двусторонняя очередь)<br/>
 * Дек позволяет добавлять и извлекать элементы с обоих концов.
 */
public interface Deque<T> {

    /**
     * Вставка нового элемента в конец
     */
    void pushBack(T element);

    /**
     * Получение и удаление последнего элемента
     */
    T popBack();

    /**
     * Вставка нового элемента в начало
     */
    void pushFront(T element);


    /**
     * Получение и удаление первого элемента
     */
    T popFront();

    /**
     * Пустая очередь или нет
     */
    boolean isEmpty();

    /**
     * Количество элементов в очереди
     */
    int getSize();

}
