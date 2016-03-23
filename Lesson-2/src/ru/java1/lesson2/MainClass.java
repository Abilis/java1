package ru.java1.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Abilis on 23.03.2016.
 */
public class MainClass {

    public static void main(String[] args) {

        String firstStr = "Начало работы";

        System.out.println(firstStr);

        int[] firstArr = new int[20];
        int[][] secondArr = new int[20][20];

        //заполняем первый одномерный массив
        for (int i = 0; i < firstArr.length; i++) {
            firstArr[i] = i + 1;
        }

        //заполняем второй двумерный массив
        for (int i = 0; i < secondArr.length; i++) {

            for (int j = 0; j < secondArr.length; j++) {
                secondArr[i][j] = i + j;
            }

        }

        int sumFirst = 0;
        int sumSecond = 0;
        //подсчет суммы значений в массивах и вывод на консоль
        for (int i = 0; i < firstArr.length; i++) {
            sumFirst += firstArr[i];
        }

        System.out.println("Сумма значений первого массива: " + sumFirst);

        for (int i = 0; i < secondArr.length; i++) {
            for (int j = 0; j < secondArr.length; j++) {
                sumSecond += secondArr[i][j];
            }
        }

        System.out.println("Сумма значений второго массива: " + sumSecond);

        //Вычисление среднего значения массивов
        System.out.println("Среднее значение первого массива: " + (double) sumFirst / firstArr.length);
        System.out.println("Среднее значение второго массива: " + (double) sumSecond / (secondArr.length *secondArr.length ));


        /*Теперь если в массиве есть положительное число, то увеличиваем сумму на 3, если отрицательное, то уменьшаем в 2. (Хм, при текущем условии заполнения
          отрицательного никогда не будет). А если встречаем числа 2, 4, 8, то ничего не делаем (даже не прибавляем к сумме, реализовано так) */

        //обрабатываем первый массив

        int firstSumAfterProcessing = 0;
        int secondSumAfterProcessing = 0;

        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] == 2 || firstArr[i] == 4 || firstArr[i] == 8) {
                //ничего не делаем
            }
            else if (firstArr[i] > 0) {
                firstSumAfterProcessing += (3 + firstArr[i]); //значение элемента тоже учитываем
            }
            else if (firstArr[i] < 0) { //при текущем заполнении выполняться никогда не будет.
                firstSumAfterProcessing /= 2;
                firstSumAfterProcessing += firstArr[i]; //учитываем значение элемента
            }

        }

        //обрабатываем второй массив
        for (int i = 0; i < secondArr.length; i++) {
            for (int j = 0; j < secondArr.length; j++) {
                if (secondArr[i][j] == 2 || secondArr[i][j] == 4 || secondArr[i][j] == 8) {
                    //ничего не делаем
                }
                else if (secondArr[i][j] > 0) {
                    secondSumAfterProcessing += (3 + secondArr[i][j]);
                }
                else if (secondArr[i][j] < 0) {
                    secondSumAfterProcessing /= 2;
                    secondSumAfterProcessing += secondArr[i][j];
                }
            }
        }

        //Посмотрим, что получилось
        System.out.println("Среднее значение первого массива после обработки: " + (double) firstSumAfterProcessing / firstArr.length);
        System.out.println("Среднее значение второго массива после обработки: " + (double) secondSumAfterProcessing / (secondArr.length *secondArr.length ));




        //калькулятор, который на вход будет принимать 2 числа и операцию, выполнять вычисления, выводить результат

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float inputSNum1 = 0.0f;
        float inputSNum2 = 0.0f;
        String inputOperator = "";
        float result = 0.0f;

        System.out.println();
        System.out.println("Это калькулятор Java");

        while (true) {

            System.out.println("Введите операцию (+, -, *, /) и 2 цифры (y - для выхода):");

            try {
                inputOperator = reader.readLine();
                if (inputOperator.equalsIgnoreCase("y")) {
                    break;
                }

                inputSNum1 = Float.parseFloat(reader.readLine());
                inputSNum2 = Float.parseFloat(reader.readLine());

                if (inputOperator.equals("+")) {
                    result = inputSNum1 + inputSNum2;
                }
                else if (inputOperator.equals("-")) {
                    result = inputSNum1 - inputSNum2;
                }
                else if (inputOperator.equals("*")) {
                    result = inputSNum1 * inputSNum2;
                }
                else if (inputOperator.equals("/")) {
                    if (inputSNum2 != 0) {
                        result = inputSNum1 / inputSNum2;
                    }
                    else {
                        throw new ArithmeticException();
                    }
                }
                else {
                    throw new Exception();
                }

                System.out.println(inputOperator + " " + inputSNum1 + " " + inputSNum2);
                System.out.println("Итог: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Не удалось поделить на ноль :(");

            } catch (Exception e) {
                System.out.println("Некорректный ввод данных");
            }



        } //конец цикла первого калькулятора
        System.out.println("Калькулятор OFF");


        try {
            System.out.println("Сейчас запустится более крутой калькулятор...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Не получилось :(");
        }

        System.out.println("Поехали!");

        //хм, поскольку будет вводиться сколько угодно чисел, придется хранить их в списке, который мы не проходили.
        //В принципе, можно реализовать и массивом, но тогда придется прикручивать велосипед для пересоздавания массива

        String inputNumS = "";
        float inputNum = 0.0f;
        ArrayList<Float> listOfNumbers = new ArrayList<Float>();
        float result2 = 0.0f;

        while (true) {

            System.out.println("Введите операцию (+, -, *, /) и числа (y - для выхода, end - конец ввода чисел):");

            try {

                inputOperator = reader.readLine();
                if (inputOperator.equalsIgnoreCase("y")) {
                    break;
                }

                while (true) {

                    System.out.println("Вводите числа. end - для вычисления");

                    try {

                        inputNumS = reader.readLine();

                        if (inputNumS.equals("end")) {
                            break;
                        }

                        inputNum = Float.parseFloat(inputNumS);
                        listOfNumbers.add(inputNum);
                    } catch (Exception e) {
                        System.out.println("Не удалось распознать число. Попробуйте еще раз");
                    }

                } //конец цикла ввода чисел

                if (inputOperator.equals("+")) {

                    for (double num : listOfNumbers) {
                        result2 += num;
                    }

                }
                else if (inputOperator.equals("-")) {

                    if (listOfNumbers.size() == 2) {
                        result2 = listOfNumbers.get(0) + listOfNumbers.get(1);
                    }
                    else {
                        System.out.println("Непонятно, что от чего отнимать");
                        throw new IOException();
                    }

                }
                else if (inputOperator.equals("*")) {

                    for (double num : listOfNumbers) {
                        result2 *= num;
                    }

                }
                else if (inputOperator.equals("/")) {

                    if (listOfNumbers.size() == 2) {

                        if (listOfNumbers.get(1) == 0) {
                            throw new ArithmeticException();
                        }

                        result2 = listOfNumbers.get(0) / listOfNumbers.get(1);

                        //округляем результат до сотых в большую сторону
                        BigDecimal bd = new BigDecimal(result2);
                        bd = bd.setScale(2, BigDecimal.ROUND_UP);
                        result2 = bd.floatValue();
                    }
                    else {
                        System.out.println("Непонятно, что на что делить");
                        throw new IOException();
                    }


                }

                System.out.print(inputOperator + " ");

                for (double num : listOfNumbers) {
                    System.out.print(num + " ");
                }
                System.out.println();
                System.out.println("Итог: " + result2);

            } catch (ArithmeticException e) {
                System.out.println("Не удалось поделить на ноль. Сейчас попробуем еще раз...");
            }
            catch (IOException e) {
                System.out.println("Что-то пошло не так. Попробуем еще раз");
            }

            //обнуляем список и result2
            result2 = 0;
            listOfNumbers.clear();

        } //конец цикла второго калькулятора




        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Не получилось закрыть поток :(");
        }

      } //конец метода мейн


}
