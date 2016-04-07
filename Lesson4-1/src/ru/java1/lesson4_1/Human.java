package ru.java1.lesson4_1;

import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public abstract class Human extends Life implements Eat {

    protected String lastName;

    public Human(Date dateBorn, Date dateDie, int weight, int height, String name, String lastName) {
        super(dateBorn, dateDie, weight, height, name);
        this.lastName = lastName;
    }

    protected abstract void move();

    protected abstract void voice();

}
