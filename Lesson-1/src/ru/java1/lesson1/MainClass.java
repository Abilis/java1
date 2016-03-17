package ru.java1.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Abilis on 17.03.2016.
 */
public class MainClass {

    private static int num = 10;
    private static String str;

    public static void main(String[] args) {

        System.out.println(num);

        str = "Hello!";
        System.out.println(str);
        System.out.println("Строка выше была инициализирована чуть позже");

        System.out.println("Второе задание сейчас начнется...");
        System.out.println();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Не получилось :(");
        }

        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String sNum;
        int num;

        while (true) {

            System.out.println("Введи в меня цифру(y-для выхода):");

            try {
                sNum = bufferedReader.readLine();
                num = Integer.parseInt(sNum);
                System.out.println("ты ввел цифру " + num + " - крутая цифра кстати");
            } catch (Exception e) {
                break;
            }

        }
        System.out.println("Ну воооот, а так хорошо общались");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Не получилось :(");
        }

        if (System.out.printf("А в команде вывода этой строки не успользовалось \";\"") != null) {

        }
    }

}
