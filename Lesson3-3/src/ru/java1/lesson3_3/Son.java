package ru.java1.lesson3_3;

/**
 * Created by Abilis on 31.03.2016.
 */
public class Son extends Father {

    protected int number = 40;



    public int getGreatGrandFatherNumber() {
        return ((GreatGrandFather)this).number;
    }

}
