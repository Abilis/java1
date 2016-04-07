package ru.java1.lesson4_1;

/**
 * Created by Abilis on 06.04.2016.
 */
public class Main {
    public static Object cat;

    static {
        class Cat{
            String name = "Пушок";
        }

        Cat myCat = new Cat();
        myCat = (Cat) cat;
     //   System.out.println(myCat.name);
    }

    public static void main(String[] args) {

    }

}