package ru.java1.lesson3_2;

import java.util.Date;

/**
 * Created by Abilis on 31.03.2016.
 */
public class Cake {

    private int eggs;
    private int meal; //мука в граммах
    private int water; //вода в миллилитрах

    private String name; //название кеса
    private Date timeForCook; //время приготовления в секундах
    private int weigth; //масса в граммах

    public int getEggs() {
        return eggs;
    }

    public String getName() {
        return name;
    }

    public int getMeal() {
        return meal;
    }

    public int getWater() {
        return water;
    }

    public Cake (int eggs, int meal, int wather, String name) {
        this.eggs = eggs;
        this.meal = meal;
        this.water = wather;
        this.name = name;
        initialTimeForCook(eggs, meal, wather);
        inirialWeigth(eggs, meal, wather);
        System.out.println("Кекс \"" + this.name + "\" готов!");
    }


    private void initialTimeForCook(int eggs, int meal, int water) {

        //чем больше объем ингредиентов, тем дольше время приготовления
        int cookingTime = eggs * 100 + meal + water; //в миллисекундах

        Date date1 = new Date(); //перед началом приготовления

        try {
            Thread.sleep(cookingTime);
        } catch (InterruptedException e) {
            System.out.println("При приготовлении кекса произошла ошибка");
        }

        Date date2 = new Date(); //после окончания приготовления

        long differenceMilliSeconds = date2.getTime() - date1.getTime();

        timeForCook = new Date(differenceMilliSeconds * 1000); //время приготовления. Умножим реальное время на 1000, чтобы было что показать в тустринге
    }

    private void inirialWeigth(int eggs, int meal, int water) {
        weigth = eggs * 40 + meal + water / 20;
    }



    @Override
    public String toString() {
        return "Кекс " + "\"" + name + "\"" + " массой " + weigth + " грамм приготовлен за " + timeForCook.getMinutes() + " минут " +
                timeForCook.getSeconds() + " секунд";
    }

    //метод добавляет некоторое количество муки к тому количеству, которое уже есть в кексе. Используется для создания нового кекса на основе уже имеющегося
    public int addMeal (int meal) {
        return this.meal + meal;
    }

    //метод добавляет некоторое количество воды к тому количеству, которое уже есть в кексе. Используется для создания нового кекса на основе уже имеющегося
    public int addWather (int wather) {
        return this.water + wather;
    }
}
