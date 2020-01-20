package com.itea.java.basic.l21.examples.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SwingExample {

    JLabel label;

    private SwingExample() {
        JFrame jFrame = createFrame();

        JButton jButton = new JButton("Моя первая кнопка");
        label = new JLabel("Моя первая метка");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(new Random().nextInt()));
            }
        });

        jFrame.add(label);
        jFrame.add(jButton);
    }

    private JFrame createFrame() {
        JFrame jFrame = new JFrame("Мое первое приложение");
        jFrame.setSize(400, 150);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        return jFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingExample::new);
        SwingExample swingExample = new SwingExample();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        swingExample.label.setText("Поспали 3 сек");
    }
}
