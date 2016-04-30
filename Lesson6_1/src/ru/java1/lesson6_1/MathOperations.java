package ru.java1.lesson6_1;

import ru.java1.lesson6_1.exceptions.TooBigResultException;

/**
 * Created by Abilis on 30.04.2016.
 */
public interface MathOperations {

    double getSum(String str1, String str2) throws TooBigResultException;

    double getSub(String str1, String str2) throws TooBigResultException;

    double getMult(String str1, String str2) throws TooBigResultException;

    double getDiv(String str1, String str2) throws TooBigResultException;

}
