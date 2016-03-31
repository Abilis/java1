package ru.java1.lesson3_3;

/**
 * Created by Abilis on 31.03.2016.
 */
public class GreatGrandFather {

    protected int number = 10;

    private int getNumber() {
        return this.number;
    }

    protected int getParentNumber() {
        return this.getNumber();
    }

}
