package ru.java1.lesson6_1;

import exceptions.IncorrectInputDataException;
import exceptions.TooBigResultException;

/**
 * Created by Abilis on 30.04.2016.
 */
public class Math implements MathOperations {

    private static Math instance;

    private Math() {

    }

    //хз, зачем здесь потокобезопасный синглтон, но пусть будет
    public static Math getInstance() {
        if (instance == null) {
            synchronized (Math.class) {
                if (instance == null) instance = new Math();
            }
        }
        return instance;
    }

    @Override
    public double getSum(String str1, String str2) throws TooBigResultException {

        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);

        } catch (NumberFormatException e) {
            throw new IncorrectInputDataException("Введенные данные не являются числами");
        }

        if (num1 < 0 || num2 < 0) {
            throw new IncorrectInputDataException("Допустимы только неотрицательные числа!");
        }

         double result = num1 + num2;

        if (result > 10_000) {
            throw new TooBigResultException("Вычисленный результат слишком большой! (" + result + ")");
        }

        return result;
    }

    @Override
    public double getSub(String str1, String str2) throws TooBigResultException {
        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);

        } catch (NumberFormatException e) {
            throw new IncorrectInputDataException("Введенные данные не являются числами");
        }

        if (num1 < 0 || num2 < 0) {
            throw new IncorrectInputDataException("Допустимы только неотрицательные числа!");
        }

        double result = num1 - num2;

        if (result > 10_000) {
            throw new TooBigResultException("Вычисленный результат слишком большой! (" + result + ")");
        }

        return result;
    }

    @Override
    public double getMult(String str1, String str2) throws TooBigResultException {
        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);

        } catch (NumberFormatException e) {
            throw new IncorrectInputDataException("Введенные данные не являются числами");
        }

        if (num1 < 0 || num2 < 0) {
            throw new IncorrectInputDataException("Допустимы только неотрицательные числа!");
        }

        double result = num1 * num2;

        if (result > 10_000) {
            throw new TooBigResultException("Вычисленный результат слишком большой! (" + result + ")");
        }

        return result;
    }

    @Override
    public double getDiv(String str1, String str2) throws TooBigResultException {
        double num1;
        double num2;

        try {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);

        } catch (NumberFormatException e) {
            throw new IncorrectInputDataException("Введенные данные не являются числами");
        }

        if (num1 < 0 || num2 < 0) {
            throw new IncorrectInputDataException("Допустимы только неотрицательные числа!");
        }

        if (num2 == 0) {
            throw new IncorrectInputDataException("Нельзя делить на 0!");
        }

        double result = num1 / num2;

        if (result > 10_000) {
            throw new TooBigResultException("Вычисленный результат слишком большой! (" + result + ")");
        }

        return result;
    }
}
