package ru.java1.lesson4_2;

/**
 * Created by Abilis on 07.04.2016.
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }

        System.out.println(getPosishn(arr, 0));
        System.out.println(getPosishn(arr, 2));
        System.out.println(getPosishn(arr, 18));
        System.out.println(getPosishn(arr, 20));
        System.out.println(getPosishn(null, 2));


    }


    public static int getPosishn(int[] arr, int a) {
        int possision = -1;

        try {


            int l = 0;
            int end = arr.length;
            int i = end / 2;
            if (a <= arr[end-1]) {

                while (i >= 0 && i < end) {

                    if (arr[i] == a) return i;

                    else if (arr[i] > a) {
                        i = l + (i - l) / 2;
                        if(arr[i] == a) return i;
                        if(i == l) return  possision;
                    }
                    else if (arr[i] < a) {
                        l = i;
                        i = l + (end - l) / 2;
                    }


                }
            } else  return possision;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

        return possision;
    }
}
