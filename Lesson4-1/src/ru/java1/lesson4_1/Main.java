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
        System.out.println(getIndexBinary(arr, 6));
        System.out.println(getIndexBinary(arr, 50));
        System.out.println(getIndexBinary(null, 100));

        System.out.println();

        //и еще вот так можно. Все уже реализовано :)
        System.out.println(Arrays.binarySearch(arr, 6));

        System.out.println();
        System.out.println();

//        System.out.println(getPosishn(arr, 2));
//        System.out.println(getPosishn(arr, 51));
//        System.out.println(getPosishn(null, 100));

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

        while (minIndex <= maxIndex) {

            int midIndex = minIndex + (maxIndex - minIndex) / 2;

            if (value < arr[midIndex]) {
                maxIndex = midIndex - 1;
            }
            else if (value > arr[midIndex]) {
                minIndex = midIndex + 1;
            }
            else {
                return midIndex;
            }

        }

        return -1;

    }



}