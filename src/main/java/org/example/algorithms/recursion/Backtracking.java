package org.example.algorithms.recursion;

/**
 * Backtracking - это метод решения задач, где требуется перебор вариантов.
 */
public class Backtracking {

    private static void generate(String alphabet, String buffer) {
        if (buffer.length() == alphabet.length()) {
            System.out.println(buffer);
            return;
        }

        for (char ch : alphabet.toCharArray()) {
            generate(alphabet, buffer + ch);
        }
    }

    private static void generate2(String current, int n) {
        if (n == 0) {
            System.out.println(current);
            return;
        }

        generate2(current + "a", n - 1);
        generate2(current + "b", n - 1);
    }

    public static void main(String[] args) {
        //generate("ab", "");
        generate2("", 2);
    }
}
