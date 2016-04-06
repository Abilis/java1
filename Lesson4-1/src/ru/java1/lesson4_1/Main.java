package ru.java1.lesson4_1;

/**
 * Created by Abilis on 06.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(getFact(-2));

    }

    public static long getFact(long n) {

        if (n < 0) {
            throw new ArithmeticException("Факториал не определен для числа " + n);
        }
        if (n == 0) {
            return 1;
        }

        if (n != 1) {
            n = n * getFact(n - 1);
        }

        return n;
    }

}
