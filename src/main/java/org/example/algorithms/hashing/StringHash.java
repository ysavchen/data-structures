package org.example.algorithms.hashing;

/**
 * Хеш строки
 */
public class StringHash {

    /**
     * Полиномиальный хеш считается по формуле:<br/>
     * {@code h("Y-x") = (89 * 3^2 + 45 * 3 + 120) mod 2^32}<br/>
     * {@code 89, 45, 120} - десятичные коды ascii символов {@code Y, -, x}<br/>
     * {@code 89 * 3^2} - каждый код ascii символа домножается на число в степени<br/>
     * {@code 3^2} - длина строки в степени 2 (<длина строки> - 1, т.е. 3 - 1 = 2)<br/>
     * {@code 45 * 3^1} - код ascii домножается на 3^1<br/>
     * {@code 120 * 3^0} - код ascii домножается на 3^0
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
