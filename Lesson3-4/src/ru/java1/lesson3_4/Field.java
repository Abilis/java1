package ru.java1.lesson3_4;

import java.util.ArrayList;

/**
 * Created by Abilis on 01.04.2016.
 */
public class Field {

    private int width;
    private int height;

    private Hexagon[][] field;

    public Hexagon[][] getField() {
        return field;
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        //инициализируем поле
        field = new Hexagon[width][height];

        //заполняем поле гексами
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Hexagon();
            }
        }

    }
}
