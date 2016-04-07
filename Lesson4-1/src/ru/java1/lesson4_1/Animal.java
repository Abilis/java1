package ru.java1.lesson4_1;

import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public abstract class Animal extends Life implements Eat {

    protected int lenght;
    protected boolean gender; //true - male, false - female
    protected int amountLegs;
    protected int amountTeeth;

    public Animal(Date dateBorn, Date dateDie, int weight, int height, String name, int lenght, boolean gender, int amountLegs, int amountTeeth) {
        super(dateBorn, dateDie, weight, height, name);
        this.lenght = lenght;
        this.gender = gender;
        this.amountLegs = amountLegs;
        this.amountTeeth = amountTeeth;
    }

    protected abstract void move();

    protected abstract void voice();


}
