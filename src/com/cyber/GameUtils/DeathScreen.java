package com.cyber.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class DeathScreen {
    public Boolean isCorrect;
    public TriviaQuestion question;

    private double x; private double y;
    private double actualX; private double actualY;
    private int width; private int height;

    private JFrame frame;
    private JLabel messageLabel;
    private JButton[] answerlist = new JButton[4];
    private JPanel panel;

    public DeathScreen(){
        question = new TriviaQuestion();
        isCorrect = null;

        createWindow();
    }

    private void createWindow(){
        frame = new JFrame("Death Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //credits: https://www.dreamincode.net/forums/topic/311043-simple-java-gui-quiz/
        messageLabel = new JLabel(question.question);

        for(int i = 0; i < 4; i++){
            answerlist[i] = new JButton(question.answers[i]);
        }

        panel = new JPanel();
        panel.add(messageLabel);
        for(int i = 0; i < 4; i++){
            answerlist[i].addActionListener(e -> {
                isCorrect = e.getActionCommand().equals(question.correctAnswer);
            });
            panel.add(answerlist[i]);
        }

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public void closeWindow(){
        frame.setVisible(false);
        frame.dispose();
    }

}
