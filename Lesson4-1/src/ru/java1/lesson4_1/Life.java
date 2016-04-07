package ru.java1.lesson4_1;

import java.util.Date;

/**
 * Created by Abilis on 07.04.2016.
 */
public abstract class Life {

    protected Date dateBorn;
    protected Date dateDie;
    protected int weight;
    protected int height;
    protected String name;

    public Life(Date dateBorn, Date dateDie, int weight, int height, String name) {
        this.dateBorn = dateBorn;
        this.dateDie = dateDie;
        this.weight = weight;
        this.height = height;
        this.name = name;
    }
}
