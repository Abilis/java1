package ru.java1.lesson4_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Abilis on 06.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        Life[] creatures = new Life[8];

        creatures[0] = new Woman(getRandomDate(1980, 10), getRandomDate(2050, 20), 50, 165, "Alice", "Selezneva", false);
        creatures[1] = new Woman(getRandomDate(1980, 10), getRandomDate(2050, 20), 55, 167, "Maria", "Antos", false);
        creatures[2] = new Man(getRandomDate(1980, 10), getRandomDate(2030, 20), 80, 180, "Kianu", "Mobs", true);
        creatures[3] = new Man(getRandomDate(1980, 10), getRandomDate(2030, 20), 100, 185, "Ivan", "Ivanov", false);
        creatures[4] = new Dog(getRandomDate((new Date().getYear() + 1900), -10), getRandomDate(2010, 5), 5, 80, "Barbos",
                130, true, 4, 42, 20, getSkills());
        creatures[5] = new Dog(getRandomDate((new Date().getYear() + 1900), -10), getRandomDate(2012, 5), 5, 80, "Tizik",
                120, true, 5, 45, 23, getSkills());
        creatures[6] = new Cat(getRandomDate((new Date().getYear() + 1900), -10), getRandomDate(2010, 5), 3, 22, "Murka",
                50, false, 4, 30, 9);
        creatures[7] = new Parrot(getRandomDate((new Date().getYear() + 1900), -10), getRandomDate(2060, 15), 1, 30,
                "Jora", 80, true, 2, 0, 70, true);


        //подсчитываем общий вес всех существ
        System.out.println("Общий вес всех существ: " + getTotalWeight(creatures));

        //подсчитываем средний вес животных
        System.out.println("Средний вес всех животных: " + getAverageWeightAnimals(creatures));

        //подсчитываем средний вес людей
        System.out.println("Средний вес всех людей: " + getAverageWeightHumans(creatures));

        System.out.println();
        System.out.println();
        //накормим всех едой
        eatPlease(creatures);

        System.out.println();
        System.out.println();
        //выводим возраст всех существ
        printAgeAllCreatures(creatures);
    }

    private static Date getRandomDate(int startYear, int deltaYear) {

        int randomDeltaYear = (int) (Math.random() * deltaYear); //генерируем случайное число от 0 до deltaYear

        String dateStr = String.valueOf(startYear + randomDeltaYear);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date randomDate = null;

        try {
            randomDate = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Неверные входные данные!");
        }

        return randomDate;
    }

    private static ArrayList<String> getSkills() {
        ArrayList<String> skills = new ArrayList<String>();

        skills.add("Апорт!");
        skills.add("Лежать!");
        skills.add("Сидеть!");
        skills.add("Фу!");

        return skills;
    }

    private static int getTotalWeight(Life[] arr) {

        int weight = 0;

        for (Life life : arr) {
            weight += life.weight;
        }
        return weight;
    }

    private static int getAverageWeightAnimals(Life[] arr) {

        int weight = 0;
        int countAnimal = 0;
        for (Life life : arr) {

            if (life instanceof Cat) {
                Cat cat = (Cat) life;
                weight += cat.weight;
                countAnimal++;
            }
            else if (life instanceof Dog) {
                Dog dog = (Dog) life;
                weight += dog.weight;
                countAnimal++;
            }
            else if (life instanceof Parrot) {
                Parrot parrot = (Parrot) life;
                weight += parrot.weight;
                countAnimal++;
            }

        }
        int averageWeight = weight / countAnimal;
        return averageWeight;
    }

    private static int getAverageWeightHumans(Life[] arr) {

        int weight = 0;
        int countHuman = 0;
        for (Life life : arr) {

            if (life instanceof Man) {
                Man man = (Man) life;
                weight += man.weight;
                countHuman++;
            }
            else if (life instanceof Woman) {
                Woman woman = (Woman) life;
                weight += woman.weight;
                countHuman++;
            }

        }
        int averageWeight = weight / countHuman;
        return averageWeight;


    }

    private static void eatPlease(Life[] arr) {

        for (Life life : arr) {
            if (life instanceof Human) {
                Human human = (Human) life;
                human.doEat("человеческая еда");
            }
            else if (life instanceof Animal) {
                Animal animal = (Animal) life;
                animal.doEat("еда для животных");
            }
        }

    }

    private static void printAgeAllCreatures(Life[] arr) {

        for (Life life : arr) {
            System.out.println("Возраст " + life.getClass().getSimpleName() + " " + life.name + ": " +
                    (new Date().getYear() - life.dateBorn.getYear()));
        }

    }

}