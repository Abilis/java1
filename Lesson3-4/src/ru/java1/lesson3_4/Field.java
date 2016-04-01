package ru.java1.lesson3_4;


/**
 * Created by Abilis on 01.04.2016.
 */
public class Field {

    private static int width;
    private static int height;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private static Hexagon[][] field;

    public Hexagon[][] getField() {
        return field;
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        //инициализируем поле
        field = new Hexagon[height][width];

        //заполняем поле гексами
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Hexagon(i, j);
            }
        }

    }

    //метод отрисовывает игровое поле
    public static void draw(Unit unit) {

        for (int i = 0; i < field.length; i++) {

            if ((i & 1) == 1) {
                System.out.print(" ");
            }

            for (int j = 0; j < field[i].length; j++) {

                if (unit.getX() - 1 == field[i][j].getIndexY() && unit.getY() - 1 == field[i][j].getIndexX()) {
                    System.out.print(" U");
                }
                else {
                    System.out.print(" O");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }

}
