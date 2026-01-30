package org.example.algorithms.recursion;

public class Countdown {

    public static void main(String[] args) {
        new Countdown().countdown(10);
    }

    /**
     * Когда вы пишете рекурсивную функцию, в ней необходимо указать, в какой момент следует прервать рекурсию.
     * Вот почему каждая рекурсивная функция состоит из двух частей: базового случая и рекурсивного случая.
     * В рекурсивном случае функция вызывает сама себя.
     * В базовом случае функция себя не вызывает... чтобы предотвратить зацикливание.
     */
    private void countdown(int i) {
        System.out.println("print " + i);

        if (i <= 0) {
            return; // базовый случай (базис)
        } else {
            countdown(i - 1); // рекурсивый случай
        }
    }
}
