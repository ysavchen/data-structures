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
    public static int loopFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Вычисление факториала с помощью рекурсии<br/>
     * При рекурсивном вычислении факториала может произойти переполнение стека.<br/>
     * Чтобы решить эту проблему можно заменить рекурсию на цикл.
     */
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int result = loopFactorial(3);
        System.out.println("Result: " + result);
    }
}
