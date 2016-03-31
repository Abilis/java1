package ru.java1.lesson3_2;

import java.util.ArrayList;

/**
 * Created by Abilis on 31.03.2016.
 */
public class Bakery {

    public static void main(String[] args) {

        ArrayList<Cake> cakes = new ArrayList<Cake>(10);

        cakes.add(new Cake(2, 200, 100, "Вкусный кекс"));
        cakes.add(new Cake(3, 300, 166, "Кекс для великана"));
        cakes.add(new Cake(1, 85, 100, "Демо-версия кекса"));
        cakes.add(new Cake(2, 180, 95, "Пирожное \"Картошка\""));
        cakes.add(new Cake(1, 94, 35, "Мини-версия"));
        cakes.add(new Cake(1, 58, 28, "Пробный кекс"));
        cakes.add(new Cake(2, 170, 75, "Кекс с пониженным содержанием кекса"));
        cakes.add(new Cake(2, 160, 110, "Очень вкусный кекс"));
        cakes.add(new Cake(3, 210, 318, "Булочка без ничего"));
        cakes.add(new Cake(3, 250, 256, "Кекс без изюма"));

        System.out.println();

        for (Cake cake : cakes) {
            System.out.println(cake);
        }

        System.out.println();

        //добавляем четным кексам 20 грамм муки, нечетным - 30 миллилитров воды и снова печем
        for (int i = 0; i < cakes.size(); i++) {

            Cake currentCake = cakes.get(i);
            Cake secondCake;

            if (i % 2 == 0) {
                secondCake = new Cake(currentCake.getEggs(), currentCake.addMeal(20), currentCake.getWater(), currentCake.getName() + " +20 грамм муки");
            }
            else {
                secondCake = new Cake(currentCake.getEggs(), currentCake.getMeal(), currentCake.addWather(30), currentCake.getName() + " +30 миллилитров воды");
            }
            cakes.set(i, secondCake); //заменяем кекс в списке
        }

        System.out.println();

        for (Cake cake : cakes) {
            System.out.println(cake);
        }

    }

}
