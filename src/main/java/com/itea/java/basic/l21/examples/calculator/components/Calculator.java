package com.itea.java.basic.l21.examples.calculator.components;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculator {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;

    private int currX = 0;
    private int currY = 0;

    private String firstOperand;
    private String secondOperand;
    private String operation;
    private String result;

    private int currentOperand = 1;

    private JTextField display = createDisplay();

    public Calculator() {
        JFrame jFrame = createFrame();
        jFrame.add(display);
        addButtons(jFrame);
    }

    private void addButtons(JFrame jFrame) {
        JButton button7 = createButton("7");
        JButton button8 = createButton("8");
        JButton button9 = createButton("9");
        JButton buttonDivision = createButton("/");
        JButton button4 = createButton("4");
        JButton button5 = createButton("5");
        JButton button6 = createButton("6");
        JButton buttonMultiply = createButton("*");
        JButton button1 = createButton("1");
        JButton button2 = createButton("2");
        JButton button3 = createButton("3");
        JButton buttonSubtract = createButton("-");
        JButton button0 = createButton("0");
        JButton buttonDot = createButton(".");
        JButton buttonResult = createButton("=");
        JButton buttonPlus = createButton("+");

        addDigitButtonListener(button0);
        addDigitButtonListener(button1);
        addDigitButtonListener(button2);
        addDigitButtonListener(button3);
        addDigitButtonListener(button4);
        addDigitButtonListener(button5);
        addDigitButtonListener(button6);
        addDigitButtonListener(button7);
        addDigitButtonListener(button8);
        addDigitButtonListener(button9);
        addDigitButtonListener(buttonDot);

        addOperationButtonListener(buttonPlus);
        addOperationButtonListener(buttonSubtract);
        addOperationButtonListener(buttonMultiply);
        addOperationButtonListener(buttonDivision);

        addResultButtonListener(buttonResult);

        jFrame.add(button7);
        jFrame.add(button8);
        jFrame.add(button9);
        jFrame.add(buttonDivision);
        jFrame.add(button4);
        jFrame.add(button5);
        jFrame.add(button6);
        jFrame.add(buttonMultiply);
        jFrame.add(button1);
        jFrame.add(button2);
        jFrame.add(button3);
        jFrame.add(buttonSubtract);
        jFrame.add(button0);
        jFrame.add(buttonDot);
        jFrame.add(buttonResult);
        jFrame.add(buttonPlus);
    }

    private JTextField createDisplay() {
        JTextField jTextField = new JTextField();
        int width = WIDTH;
        int height = HEIGHT / 10;
        jTextField.setBounds(currX, currY, width, height);
        updateXY(width, height);
        return jTextField;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        int width = WIDTH / 4;
        int height = (int) (HEIGHT * 0.75 / 4);
        button.setBounds(currX, currY, width, height);
        updateXY(width, height);
        return button;
    }

    private void addDigitButtonListener(JButton jButton) {
        jButton.addActionListener(actionEvent -> {
            result = null;
            if (currentOperand == 1) {
                if (firstOperand == null) {
                    firstOperand = "";
                }
                firstOperand += jButton.getText();
            } else {
                if (secondOperand == null) {
                    secondOperand = "";
                }
                secondOperand += jButton.getText();
            }
            updateDisplay();
        });
    }

    private void addOperationButtonListener(JButton jButton) {
        jButton.addActionListener(actionEvent -> {
            if (currentOperand == 1 && firstOperand == null) {
                return;
            }
            if (result != null) {
                currentOperand = 1;
                firstOperand = result;
                result = null;
            }
            if (currentOperand == 1) {
                currentOperand = 2;
            }
            operation = jButton.getText();
            updateDisplay();
        });
    }

    private void addResultButtonListener(JButton jButton) {
        jButton.addActionListener(actionEvent -> {
            result = getResult();
            flush();
            updateDisplay();
        });
    }

    private JFrame createFrame() {
        JFrame jFrame = new JFrame("Calculator");
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setLayout(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        return jFrame;
    }

    private void updateXY(int x, int y) {
        currX += x;
        if (currX >= WIDTH) {
            currX = 0;
            currY += y;
        }
    }

    private void updateDisplay() {
        String output;
        if (result != null) {
            output = result;
        } else {
            output = displayFormat(firstOperand) + displayFormat(operation) + displayFormat(secondOperand);
        }
        display.setText(output);
    }

    private String displayFormat(String text) {
        if (text == null) {
            return "";
        }
        return text + " ";
    }

    private String getResult() {
        double op1 = Double.parseDouble(firstOperand);
        double op2 = Double.parseDouble(secondOperand);
        NumberFormat nf = new DecimalFormat("##.###");
        switch (operation) {
            case "+" : return nf.format(op1 + op2);
            case "-" : return nf.format(op1 - op2);
            case "*" : return nf.format(op1 * op2);
            case "/" : return nf.format(op1 / op2);
            default: throw new IllegalStateException("Invalid operation!");
        }
    }

    private void flush() {
        currentOperand = 1;
        firstOperand = "";
        secondOperand = "";
        operation = "";
    }
}
