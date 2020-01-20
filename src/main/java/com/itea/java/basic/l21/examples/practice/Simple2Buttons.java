package com.itea.java.basic.l21.examples.practice;

import javax.swing.*;
import java.awt.*;

public class Simple2Buttons {

    private Simple2Buttons() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(250, 150);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());

        JButton buttonA = new JButton("Button A");
        JButton buttonB = new JButton("Button B");

        buttonA.setBackground(Color.CYAN);
        buttonB.setBackground(new Color(48, 10, 36));

        JLabel label = new JLabel();

        buttonA.addActionListener(action -> label.setText("Button A has been pressed"));
        buttonB.addActionListener(action -> label.setText("Button B has been pressed"));

        jFrame.add(buttonA);
        jFrame.add(buttonB);
        jFrame.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Simple2Buttons::new);
    }
}
