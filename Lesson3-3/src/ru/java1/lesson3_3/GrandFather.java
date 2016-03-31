package ru.java1.lesson3_3;

/**
 * Created by Abilis on 31.03.2016.
 */
public class GrandFather extends GreatGrandFather {

    protected int number = 20;


    protected int getNumber() {
        return this.number;
    }

    @Override
    protected int getParentNumber() {
        return super.getParentNumber();
    }

}
