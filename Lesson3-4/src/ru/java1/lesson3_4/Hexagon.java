package ru.java1.lesson3_4;

/**
 * Created by Abilis on 01.04.2016.
 */
public class Hexagon {

    private int indexX;
    private int indexY;
    private boolean isEmpty;

    public boolean isEmpty() {
        return isEmpty;
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public Hexagon(int indexX, int indexY) {
        this.indexX = indexX;
        this.indexY = indexY;
        isEmpty = true;
    }
}
