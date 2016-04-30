package ru.java1.lesson6_1.gui;

import exceptions.IncorrectInputDataException;
import exceptions.TooBigResultException;
import ru.java1.lesson6_1.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Abilis on 30.04.2016.
 */
public class MainWindow {

    private static MainWindow instance;

    //создаем компоненты
    private JFrame mainWindow = new JFrame("Калькулятор");
    private Dimension dimMainWondow = new Dimension(370, 255);

    //метка с сообщением о том, что здесь происходит
    private JLabel titleLabel = new JLabel("Введите два неотрицательных числа");

    //метки с полями ввода операндов
    private JLabel operandFirstLabel = new JLabel("Введите первое число:");
    private JLabel operandSecondLabel = new JLabel("Введите второе число:");

    private JTextField operandFirstTextField = new JTextField(10);
    private JTextField operandSecondTextField = new JTextField(10);

    //метка для сообщения об ошибках
    private JLabel mesOfErrorsLabel = new JLabel();

    //метка для сообщений и кнопка отключения
    private JLabel funMessageLabel = new JLabel("Размышляете над операцией?");
    private JButton offFunMessagesButton = new JButton("Отключить сообщения");

    public JLabel getFunMessageLabel() {
        return funMessageLabel;
    }

    //кнопки вычисления
    private JButton plusButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multButton = new JButton("*");
    private JButton divButton = new JButton("/");

    //кнопка выхода
    private JButton closeButton = new JButton("Закрыть");

    //а вто здесь эта штуковина нужна. Хотя и без нее можно обойтись
    private MainWindow() {

    }

    public static MainWindow getInstance() {
        if (instance == null) {
            synchronized (MainWindow.class) {
                if (instance == null) instance = new MainWindow();
            }
        }
        return instance;
    }


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

        //установка настроек метки с приветствием
        titleLabel.setHorizontalAlignment(0);

        //установка настроек метки с funMessage
        funMessageLabel.setHorizontalAlignment(0);
        funMessageLabel.setFont(new Font(null, Font.ITALIC, 13));

        //расставляем компоненты

        //1 ряд. Метка с приветствием
        mainWindow.add(titleLabel, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //2 ряд. Метка с funMessage
        mainWindow.add(funMessageLabel, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));


        //3 ряд. Ставим метки с описанием и поля ввода операндов
        mainWindow.add(operandFirstLabel, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        mainWindow.add(operandFirstTextField, new GridBagConstraints(2, 2, 2, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //4 ряд. Второй ряд метки с описанием и полем ввода второго операнда
        mainWindow.add(operandSecondLabel, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        mainWindow.add(operandSecondTextField, new GridBagConstraints(2, 3, 2, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //5 ряд. Скрытое сообщение, где будут сообщаться об ошибках и результате
        mainWindow.add(mesOfErrorsLabel, new GridBagConstraints(0, 4, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //6 ряд. Кнопки с изображенями математических операторов
        mainWindow.add(plusButton, new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 1, 1));
        mainWindow.add(subtractButton, new GridBagConstraints(1, 5, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 1, 1));
        mainWindow.add(multButton, new GridBagConstraints(2, 5, 1, 1, 0.0, 1.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 1, 1));
        mainWindow.add(divButton, new GridBagConstraints(3, 5, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 1, 1));



        //7 ряд. Кнопка отключения funMessage
        mainWindow.add(offFunMessagesButton, new GridBagConstraints(0, 6, 2, 1, 1.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

        //Кнопка "Закрыть"
        mainWindow.add(closeButton, new GridBagConstraints(2, 6, 2, 1, 1.0, 0.0, GridBagConstraints.NORTH,
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

        //обработка нажатия на кнопку "отключить сообщения"
        offFunMessagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.getFunThread().interrupt();
            }
        });

    }

}