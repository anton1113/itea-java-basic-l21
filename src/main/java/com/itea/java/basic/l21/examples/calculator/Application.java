package com.itea.java.basic.l21.examples.calculator;

import com.itea.java.basic.l21.examples.calculator.components.Calculator;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Calculator::new);
    }
}
