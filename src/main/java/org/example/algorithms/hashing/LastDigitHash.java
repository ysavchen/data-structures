package org.example.algorithms.hashing;

/**
 * Хэш-функция отображает элементы большого множества в элементы малого.
 */
public class LastDigitHash {

    /**
     * Хэш-функция, которая вычисляет последнюю цифру от числа {@code x}<br/>
     * {@code F(x) = x % 10}
     * <p>
     * Большое множество - все значения int.<br/>
     * Малое множество - элементы от 0 до 9.
     */
    public static int hash(int x) {
        return x % 10;
    }
}
