package ru.java1.lesson3_4;

/**
 * Created by Abilis on 01.04.2016.
 */
public abstract class Unit {

    protected String name;
    protected int x;
    protected int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Unit(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    //х и у = координаты, куда нужно привести юнит
    protected void move(int x, int y, Unit unit) throws InterruptedException {

        Field.draw(unit);

        //сравниваем координаты юнита с координатами гекса
        //если они равны - пришли

        while (true) {

            Thread.sleep(1000);

            if (x == this.x && y == this.y) {
                break;
            }

            if (this.x < x && this.x < Field.getWidth()) {
                moveRight();
            }
            else if (this.x > x) {
                moveLeft();
            }

            else if (this.y < y) {

                if (this.x < Field.getWidth()) {
                    moveRightDown();
                }
                else {
                    moveLeftDown();
                }

            }
            else if (this.y > y) {

                if (this.x > 0) {
                    moveLeftUp();
                }
                else {
                    moveRightUp();
                }

            }

            Field.draw(unit);

        }

        System.out.println(name + " достиг заданных координат: " + x + ", " + y);

    }

    protected void moveRight() {

        this.x++;
        System.out.println(name + " шагнул на правый гекс. Текущие координаты: " + this.x + ", " + this.y);

    }

    protected void moveRightUp() {

        this.x++;
        this.y--;
        System.out.println(name + " шагнул на правый верхний гекс. Текущие координаты: " + this.x + ", " +this.y);

    }

    protected void moveLeftUp() {

        this.y--;
        System.out.println(name + " шагнул на левый верхний гекс. Текущие координаты: " + this.x + ", " + this.y);

    }

    protected void moveLeft() {

        this.x--;
        System.out.println(name + " шагнул на левый гекс. Текущие координаты: " + this.x + ", " + this.y);

    }

    protected void moveLeftDown() {

        this.y++;
        System.out.println(name + " шагнул на левый нижний гекс. Текущие координаты: " + this.x + ", " + this.y);

    }

    protected void moveRightDown() {

        this.x++;
        this.y++;
        System.out.println(name + " шагнул на правый нижний гекс. Текущие координаты: " + this.x + ", " + this.y);

    }



}
