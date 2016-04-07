package ru.java1.lesson4_1;


import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public class Parrot extends Animal {

    protected int lenghtWings;
    protected boolean flyable;

    public Parrot(Date dateBorn, Date dateDie, int weight, int height, String name, int lenght, boolean gender,
                  int amountLegs, int amountTeeth, int lenghtWings, boolean flyable) {
        super(dateBorn, dateDie, weight, height, name, lenght, gender, amountLegs, amountTeeth);
        this.lenghtWings = lenghtWings;
        this.flyable = flyable;
    }

    @Override
    protected void move() {
        System.out.println(getClass().getSimpleName() + " " + name + " двигается");
    }

    @Override
    protected void voice() {
        System.out.println(getClass().getSimpleName() + " " + name + " требует пиастров");
    }

    @Override
    public void doEat(String nameOfFood) {
        System.out.println(getClass().getSimpleName() + " клюет " + nameOfFood);
    }
}
