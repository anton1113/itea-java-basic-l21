package com.itea.java.basic.l21.examples;

import javax.swing.*;
import java.awt.*;

public class SimpleEventApplication {

    private SimpleEventApplication() {

        JFrame jFrame = new JFrame("Simple Event application");

        jFrame.setSize(240, 90);
        jFrame.setLayout(new FlowLayout());

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton alphaButton = new JButton("Alpha");
        JButton betaButton = new JButton("Beta");
        JLabel jLabel = new JLabel("Please press the button");

        alphaButton.addActionListener((actionEvent) -> jLabel.setText("Alpha button pressed"));
        betaButton.addActionListener((actionEvent -> jLabel.setText("Beta button pressed")));

        jFrame.add(alphaButton);
        jFrame.add(betaButton);
        jFrame.add(jLabel);

        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleEventApplication::new);
    }
}
