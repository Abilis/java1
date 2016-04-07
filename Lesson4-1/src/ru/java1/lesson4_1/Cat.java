package ru.java1.lesson4_1;

import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public class Cat extends Animal {

    protected int amountLifes;

    public Cat(Date dateBorn, Date dateDie, int weight, int height, String name, int lenght, boolean gender,
               int amountLegs, int amountTeeth, int amountLifes) {
        super(dateBorn, dateDie, weight, height, name, lenght, gender, amountLegs, amountTeeth);
        this.amountLifes = amountLifes;
    }

    @Override
    protected void move() {
        System.out.println(getClass().getSimpleName() + " " + name + " двигается");
    }

    @Override
    protected void voice() {
        System.out.println(getClass().getSimpleName() + " " + name + " мяукает");
    }

    @Override
    public void doEat(String nameOfFood) {
        System.out.println(getClass().getSimpleName() + " " + name + " кушает " + nameOfFood + " и мурлычет");
    }
}
