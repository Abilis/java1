package ru.java1.lesson3_4;

/**
 * Created by Abilis on 01.04.2016.
 */
public class MainClass {


    public static void main(String[] args) {

        //создаем юнит
        Hero hero = new Hero("Путешественник");

        //создаем поле
        Field field = new Field(20, 10);

        System.out.println(field.getField().length);
        System.out.println(field.getField()[0].length);

    }

}
