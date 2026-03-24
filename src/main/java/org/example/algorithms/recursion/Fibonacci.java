package org.example.algorithms.recursion;

public class Fibonacci {

    private static int fibonacci(int x) {
        if (x == 1 || x == 0) {
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    public static void main(String[] args) {
        int result = fibonacci(3);
        System.out.println("Result: " + result);
    }
}
