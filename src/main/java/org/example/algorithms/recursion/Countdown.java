package org.example.algorithms.recursion;

public class Countdown {

    /**
     * Когда вы пишете рекурсивную функцию, в ней необходимо указать, в какой момент следует прервать рекурсию.
     * Вот почему каждая рекурсивная функция состоит из двух частей: базового случая и рекурсивного случая.
     * В рекурсивном случае функция вызывает сама себя.
     * В базовом случае функция себя не вызывает... чтобы предотвратить зацикливание.
     */
    private static void countdown(int i) {
        System.out.println("i = " + i);

        if (i <= 0) {
            return; // базовый случай
        } else {
            countdown(i - 1); // рекурсивый случай
        }
    }

    public static void main(String[] args) {
        countdown(10);
    }
}
