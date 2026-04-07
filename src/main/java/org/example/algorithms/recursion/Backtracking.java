package org.example.algorithms.recursion;

/**
 * Backtracking - это метод решения задач, где требуется перебор вариантов.
 */
public class Backtracking {

    private static void generate1(String alphabet, String buffer) {
        if (buffer.length() == alphabet.length()) {
            System.out.println(buffer);
            return;
        }

        for (char ch : alphabet.toCharArray()) {
            generate1(alphabet, buffer + ch);
        }
    }

    private static void generate2(String buffer, int n) {
        if (n == 0) {
            System.out.println(buffer);
            return;
        }

        generate2(buffer + "a", n - 1);
        generate2(buffer + "b", n - 1);
    }

    public static void main(String[] args) {
        //generate1("ab", "");
        generate2("", 2);
    }
}
