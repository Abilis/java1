package ru.java1.lesson6_1.gui;

import exceptions.IncorrectInputDataException;
import exceptions.TooBigResultException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Abilis on 30.04.2016.
 */
public class MainWindow {

    //создаем компоненты
    private JFrame mainWindow = new JFrame("Калькулятор");
    private Dimension dimMainWondow = new Dimension(350, 230);

    //метки с полями ввода операндов
    private JLabel operandFirstLabel = new JLabel("Введите первое число:");
    private JLabel operandSecondLabel = new JLabel("Введите второе число:");

    private JTextField operandFirstTextField = new JTextField(10);
    private JTextField operandSecondTextField = new JTextField(10);

    //метка для сообщения об ошибках
    private JLabel mesOfErrorsLabel = new JLabel();

    //кнопки вычисления
    private JButton plusButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multButton = new JButton("*");
    private JButton divButton = new JButton("/");

    //кнопка выхода
    private JButton closeButton = new JButton("Закрыть");


    //инициализация
    public void init() {

        //установка настроек формы
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(false);
        mainWindow.setSize(dimMainWondow);

        mainWindow.setLayout(new GridBagLayout());

        //установка настроек скрытого поля с сообщенями об ошибках
        mesOfErrorsLabel.setForeground(Color.RED);
        mesOfErrorsLabel.setHorizontalAlignment(0);

        //расставляем компоненты

        //1 ряд
        //ставим метки с описанием и поля ввода операндов
        mainWindow.add(operandFirstLabel, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        mainWindow.add(operandFirstTextField, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //2 ряд
        mainWindow.add(operandSecondLabel, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        mainWindow.add(operandSecondTextField, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //3 ряд. Скрытое сообщение, где будут сообщаться об ошибках и результате
        mainWindow.add(mesOfErrorsLabel, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //4 ряд. Кнопки с изображенями математических операторов
        mainWindow.add(plusButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        mainWindow.add(subtractButton, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        mainWindow.add(multButton, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        mainWindow.add(divButton, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //4 ряд. Кнопка "Закрыть"
        mainWindow.add(closeButton, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));


        //делаем форму видимой
        mainWindow.setVisible(true);


        //обработчики

        //обработка нажатия на кнопку "Закрыть"
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.dispose();
            }
        });

        //Обработка нажатия на кнопку "+"
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ru.java1.lesson6_1.Math math = ru.java1.lesson6_1.Math.getInstance();
                double result = 0;

                try {
                    result = math.getSum(operandFirstTextField.getText(), operandSecondTextField.getText());
                    mesOfErrorsLabel.setText(operandFirstTextField.getText() + " + " +
                    operandSecondTextField.getText() + " = " + result);

                } catch (TooBigResultException e1) {
                    mesOfErrorsLabel.setText(e1.getMessage());

                } catch (IncorrectInputDataException e2) {
                    mesOfErrorsLabel.setText(e2.getMessage());
                }
            }
        });

        //Обработка нажатия на кнопку "-"
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ru.java1.lesson6_1.Math math = ru.java1.lesson6_1.Math.getInstance();
                double result = 0;

                try {
                    result = math.getSub(operandFirstTextField.getText(), operandSecondTextField.getText());
                    mesOfErrorsLabel.setText(operandFirstTextField.getText() + " - " +
                            operandSecondTextField.getText() + " = " + result);
                } catch (TooBigResultException e1) {
                    mesOfErrorsLabel.setText(e1.getMessage());

                } catch (IncorrectInputDataException e2) {
                    mesOfErrorsLabel.setText(e2.getMessage());
                }
            }
        });

        //Обработка нажатия на кнопку "*"
        multButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ru.java1.lesson6_1.Math math = ru.java1.lesson6_1.Math.getInstance();
                double result = 0;

                try {
                    result = math.getMult(operandFirstTextField.getText(), operandSecondTextField.getText());
                    mesOfErrorsLabel.setText(operandFirstTextField.getText() + " * " +
                            operandSecondTextField.getText() + " = " + result);
                } catch (TooBigResultException e1) {
                    mesOfErrorsLabel.setText(e1.getMessage());

                } catch (IncorrectInputDataException e2) {
                    mesOfErrorsLabel.setText(e2.getMessage());
                }
            }
        });

        //Обработка нажатия на кнопку "/"
        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ru.java1.lesson6_1.Math math = ru.java1.lesson6_1.Math.getInstance();
                double result = 0;

                try {
                    result = math.getDiv(operandFirstTextField.getText(), operandSecondTextField.getText());
                    mesOfErrorsLabel.setText(operandFirstTextField.getText() + " / " +
                            operandSecondTextField.getText() + " = " + result);
                } catch (TooBigResultException e1) {
                    mesOfErrorsLabel.setText(e1.getMessage());

                } catch (IncorrectInputDataException e2) {
                    mesOfErrorsLabel.setText(e2.getMessage());
                }
            }
        });


    }

}
