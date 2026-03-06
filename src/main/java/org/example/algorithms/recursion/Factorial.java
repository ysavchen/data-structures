package org.example.algorithms.recursion;

public class Factorial {

    /**
     * Вычисление факториала с помощью цикла
     */
    public static int loopFactorial(int x) {
        int accumulator = 1;
        int i = x;
        while (i > 1) {
            accumulator *= i;
            i -= 1;
        }
        return accumulator;
    }

    /**
     * Вычисление факториала с помощью рекурсии
     */
    private static int factorial(int x) {
        if (x == 1 || x == 0) {
            return 1;
        }
        return x * factorial(x - 1);
    }

    public static void main(String[] args) {
        int result = factorial(3);
        System.out.println("Result: " + result);
    }
}
