package ru.java1.lesson6_1.exceptions;

/**
 * Created by Abilis on 30.04.2016.
 */
public class IncorrectInputDataException extends CalculatorException {
    public IncorrectInputDataException(String message) {
        super(message);
    }
}
