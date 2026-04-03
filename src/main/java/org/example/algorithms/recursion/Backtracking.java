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

    public static void main(String[] args) {
        generate("ab", "");
    }
}
