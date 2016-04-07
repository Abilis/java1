package ru.java1.lesson4_1;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public class Dog extends Animal {

    protected int speed;
    protected ArrayList<String> skills;

    public Dog(Date dateBorn, Date dateDie, int weight, int height, String name, int lenght, boolean gender,
               int amountLegs, int amountTeeth, int speed, ArrayList<String> skills) {
        super(dateBorn, dateDie, weight, height, name, lenght, gender, amountLegs, amountTeeth);
        this.speed = speed;
        this.skills = skills;
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
        System.out.println(getClass().getSimpleName() + " " + name + " кушает " + nameOfFood + " и погавкивает");
    }
}
