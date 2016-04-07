package ru.java1.lesson4_1;

import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public class Woman extends Human {

    protected boolean isPregnancy;

    public Woman(Date dateBorn, Date dateDie, int weight, int height, String name, String lastName, boolean isPregnancy) {
        super(dateBorn, dateDie, weight, height, name, lastName);
        this.isPregnancy = isPregnancy;
    }

    @Override
    protected void move() {
        System.out.println(getClass().getSimpleName() + " " + name + " двигается");
    }

    @Override
    protected void voice() {
        System.out.println(getClass().getSimpleName() + " " + name + " интересуется \"Опять нажрался, зараза?!\"");
    }

    @Override
    public void doEat(String nameOfFood) {
        System.out.println(getClass().getSimpleName() + " " + name + " кушает " + nameOfFood);
    }
}
