package ru.java1.lesson4_1;

import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public class Man extends Human {

    protected boolean hasBeard;

    public Man(Date dateBorn, Date dateDie, int weight, int height, String name, String lastName, boolean hasBeard) {
        super(dateBorn, dateDie, weight, height, name, lastName);
        this.hasBeard = hasBeard;
    }

    @Override
    protected void move() {
        System.out.println(getClass().getSimpleName() + " " + name + " двигается");
    }

    @Override
    protected void voice() {
        System.out.println(getClass().getSimpleName() + " " + name + " что-то декларирует с броневичка");
    }

    @Override
    public void doEat(String nameOfFood) {
        System.out.println(getClass().getSimpleName() + " " + name + " кушает " + nameOfFood);
    }
}
