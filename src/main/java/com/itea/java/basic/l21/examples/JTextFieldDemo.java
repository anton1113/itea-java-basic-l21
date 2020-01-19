package com.itea.java.basic.l21.examples;

import javax.swing.*;
import java.awt.*;

public class JTextFieldDemo {

    private JTextFieldDemo() {
        JFrame jFrame = createJFrame();
        JTextField jTextField = new JTextField(16);
        JLabel jLabel = new JLabel();
        JLabel caretLabel = new JLabel();
        jTextField.addActionListener((actionEvent) ->
                jLabel.setText(new StringBuilder(jTextField.getText()).reverse().toString()));
        jTextField.addCaretListener(caretEvent -> caretLabel.setText("Курсор на позиции " + caretEvent.getDot()));
        jFrame.add(jTextField);
        jFrame.add(jLabel);
        jFrame.add(caretLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JTextFieldDemo::new);
    }

    private JFrame createJFrame() {
        JFrame jFrame = new JFrame("JTextField demo application");
        jFrame.setSize(225, 140);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout());
        jFrame.setVisible(true);
        return jFrame;
    }
}
