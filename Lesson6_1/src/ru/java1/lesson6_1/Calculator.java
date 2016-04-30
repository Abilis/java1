package ru.java1.lesson6_1;

import ru.java1.lesson6_1.gui.MainWindow;

import javax.swing.*;

/**
 * Created by Abilis on 30.04.2016.
 */
public class Calculator {

    private static MainWindow mainWindowFrame;
    private static JLabel funMessageLabel;
    private static String[] funMessages;
    private static Thread funThread;

    public static Thread getFunThread() {
        return funThread;
    }

    public static void main(String[] args) {

        //создаем форму калькулятора и инициализиуем ее
        mainWindowFrame = MainWindow.getInstance();
        mainWindowFrame.init();

        //чтобы было немного поинтереснее
        funThread = new FunThread();
        funThread.setDaemon(true);
        funThread.start();

    }

    private static class FunThread extends Thread {

        @Override
        public void run() {

            funMessageLabel = mainWindowFrame.getFunMessageLabel();

            funMessages = new String[10];
            funMessages[0] = "А сколько будет 2 + 2 * 2?";
            funMessages[1] = "Этот калькулятор - демо-версия виндовского";
            funMessages[2] = "Неизвестно, сколько существует Perfect Numbers";
            funMessages[3] = "Давай уже, жми чего-нибудь!";
            funMessages[4] = "1,01 в степени 365 примерно равно 37";
            funMessages[5] = "1 в любой степени равно 1";
            funMessages[6] = "0,99 в степени 365 примерно равно 0,026";
            funMessages[7] = "Хороший дизайн, не правда ли?";
            funMessages[8] = "Слова ничего не значат, покажите код! (Линус Торвальд)";
            funMessages[9] = "TCP vs UDP. На чьей стороне ты?";

            while (true) {

                try {
                    Thread.sleep(2500);
                    int index = (int) (java.lang.Math.random() * funMessages.length);
                    funMessageLabel.setText(funMessages[index]);
                } catch (InterruptedException e) {
                    break;
                }
            }

        }

    }

}
