package ru.java1.lesson4_1;

import java.util.Arrays;

/**
 * Created by Abilis on 06.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = new int[100];

        //имитация отсортированного по возрастанию массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }

        System.out.println(getIndex(arr, 2));
        System.out.println(getIndex(arr, 51));
        System.out.println(getIndex(null, 100));

        System.out.println();
        System.out.println(getIndexBinary(arr, 2));
        System.out.println(getIndexBinary(arr, 51));
        System.out.println(getIndexBinary(null, 100));

        System.out.println();

        //и еще вот так можно. Все уже реализовано :)
        System.out.println(Arrays.binarySearch(arr, 6));

        System.out.println();
        System.out.println();

        System.out.println(getPosishn(arr, 2));
        System.out.println(getPosishn(arr, 51));
        System.out.println(getPosishn(null, 100));

    }

    //решение "в лоб"
    public static int getIndex(int[] arr, int value) {

        if (arr == null) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++)
            if (value == arr[i]) {
                return i;
            }

        return -1;
    }

    public static int getIndexBinary(int[] arr, int value) {

        if (arr == null) {
            return -1;
        }

        int minIndex = 0;
        int maxIndex = arr.length - 1;

        while (minIndex <= maxIndex) { //последняя итерация цикла - когда индексы стали равны друг другу

            int midIndex = minIndex + (maxIndex - minIndex) / 2; //находим индекс, который будет обозначать середину

            if (value < arr[midIndex]) { //если значение меньше значения в середине
                maxIndex = midIndex - 1;   //то теперь будем искать слева от середины
            }
            else if (value > arr[midIndex]) {   //если же значение больше значения в середине
                    minIndex = midIndex + 1;   //то теперь будем искать справа от середины
            }
            else {
                return midIndex; //если же значение равно тому, что в середине, значит, мы нашли то, что искали
                                    //по условию достаточно вернуть любой индекс, если значений в массиве несколько
            }
        }

        return -1; //ничего не нашли

    }

    public static int getPosishn(int[] arr, int a) {
        int possision = -1;

        try {


            int l;
            int end = arr.length;
            int i = end / 2 ;

            while (i >= 0 && i < end) {

                if (i == 0 && arr[i] != a) return  possision;
                if (arr[i] == a) return i;
                else if (arr[i] > a) {
                    l = end - i;
                    i = (l / 2) + l;
                } else if (arr[i] < a) {
                    l = i;
                    i = l + (l / 2);
                }


            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  e;
        }
        return possision;
    }

}