package ru.java1.lesson3_4;

/**
 * Created by Abilis on 01.04.2016.
 */
public class MainClass {


    public static void main(String[] args) {

        //создаем юнит в гексе с индексом х, у
        Hero hero = new Hero("Путешественник", 5, 1);

        //создаем поле
        Field field = new Field(5, 3);

        //заставляем юнит передвинуться на гекс с координатами х, у
        System.out.println("Текущие координаты " + hero.name + ": " + hero.x + ", " + hero.y);

        try {
            hero.move(1, 3, hero);
        } catch (InterruptedException e) {
            System.out.println("Что-то не так, печаль-беда :(");
        }



    }

}
