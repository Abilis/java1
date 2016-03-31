package ru.java1.lesson3_3;

/**
 * Created by Abilis on 31.03.2016.
 */
public abstract class GreatGrandFather {

    protected int number = 10;

    protected int getNumber() {
        return this.number;
    }

    protected abstract int getParentNumber();

}
