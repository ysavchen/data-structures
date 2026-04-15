package org.example.algorithms.hashing;

/**
 * Хеш строки
 */
public class StringHash {

    /**
     * Полиномиальный хеш считается по формуле:<br/>
     *
     * <p>
     * Хорошие простые числа:<br/>
     * {@code 10^9 + 7}<br/>
     * {@code 10^9 + 9}
     * <p>
     * Время работы: O(n)
     */
    public static long hash(String str) {
        long p = 1_000_000_007L; // 10^9 + 7
        long r = 4_294_967_296L; // 2^32

        long h = 0L;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            h = (h * p + chars[i]) % r;
        }

        return h;
    }
}
