package com.itea.java.basic.l21.examples;

import javax.swing.*;
import java.util.Random;

public class BoundsExample {

    private BoundsExample() {

        JFrame jFrame = new JFrame("Bounds example");
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton aButton = new JButton("A");
        JButton bButton = new JButton("B");
        JButton cButton = new JButton("C");
        JButton dButton = new JButton("D");

        aButton.setBounds(10, 10, 100, 100);
        bButton.setBounds(120, 10, 100, 15);
        cButton.setBounds(25, 145, 64, 32);

        int tenPercent = (int) jFrame.getSize().getHeight() / 10;

        dButton.setBounds(200, 200, 3 * tenPercent, tenPercent);

        aButton.addActionListener((actionEvent -> bButton.setBounds(getRandomPixel(), getRandomPixel(), bButton.getSize().width, bButton.getSize().height)));

        jFrame.add(aButton);
        jFrame.add(bButton);
        jFrame.add(cButton);
        jFrame.add(dButton);

        jFrame.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BoundsExample::new);
    }

    private int getRandomPixel() {
        return new Random().nextInt(400);
    }
}
