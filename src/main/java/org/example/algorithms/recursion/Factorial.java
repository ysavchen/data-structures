package org.example.algorithms.recursion;

/**
 * Факториал - это произведение всех натуральных чисел от {@code 1} до {@code n}.<br/>
 * Факториал обозначается как {@code n!}.<br/>
 * {@code n! = 1 * 2 * ... * (n - 1) * n}
 */
public class Factorial {

    /**
     * Вычисление факториала с помощью цикла
     */
    public static int loopFactorial(int x) {
        int accumulator = 1;
        while (x > 1) {
            accumulator *= x;
            x -= 1;
        }
        return accumulator;
    }

    /**
     * Вычисление факториала с помощью рекурсии<br/>
     * При рекурсивном вычислении факториала может произойти переполнение стека.<br/>
     * Чтобы решить эту проблему можно заменить рекурсию на цикл.
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
