package ru.java1.lesson6_1.exceptions;

/**
 * Created by Abilis on 30.04.2016.
 */
public class CalculatorException extends RuntimeException {
    public CalculatorException(String message) {
        super(message);
    }
}
