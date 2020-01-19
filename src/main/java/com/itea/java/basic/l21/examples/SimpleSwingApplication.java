package com.itea.java.basic.l21.examples;

import javax.swing.*;

public class SimpleSwingApplication {

    private SimpleSwingApplication() {
        JFrame jFrame = new JFrame("Simple Swing application");

        jFrame.setSize(275, 100);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel("Swing means powerful GUIs");

        jFrame.add(jLabel);

        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleSwingApplication();
    }
}
