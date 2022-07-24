package com.zoolatech.lecture1.tasks._1;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */

//MARK: SWING APP!!!!
public class Number1 {

    public static void main(String[] args) {
        new Number1();
    }

    //MARK: BEGGINING
    private final JTextField textField;
    final JPanel numberPanel;
    final JPanel choicePanel;
    final JPanel resultPanel;
    final JRadioButton buttonForKilometer;
    final JRadioButton buttonForMiles;
    final JButton resultButton;
    final JLabel labelForNumberPanel;
    final JLabel labelForChoiсePanel;
    final JLabel labelForResultPanel;
    final JFrame frame;
    float result;

    public Number1() {

        //MARK: VARIABLES
        buttonForKilometer = new JRadioButton();
        buttonForMiles = new JRadioButton();
        resultButton = new JButton();
        numberPanel = new JPanel();
        choicePanel = new JPanel();
        resultPanel = new JPanel();
        textField = new JTextField(10);
        frame = new JFrame();
        float result = 0F;

        //SETTING UP APP INTERFACE WITH SWING FRAMEWORK:
        //MARK: BUTTONS
        buttonForKilometer.setBounds(0, 0, 50, 50);
        buttonForKilometer.setText("km");
        buttonForMiles.setBounds(0, 0, 50, 50);
        buttonForMiles.setText("mile");
        resultButton.setBounds(170, 195, 80, 30);
        resultButton.setText("Result");

        //MARK: LABELS
        labelForNumberPanel = new JLabel
                ("<html><body>Write down a distance that you<br>wanna convert to something</body></html>", JLabel.CENTER);
        labelForChoiсePanel = new JLabel
                ("<html><body>Choose unit of distance you<br>wanna to convert to something</body></html>", JLabel.CENTER);
        labelForResultPanel = new JLabel
                ("Results are: " + result, JLabel.CENTER);

        // MARK: FIRST TEXT FIELD TO WRITE DOWN A NUMBER TO CONVERT
        textField.setSize(200, 50);
        textField.setBorder(BorderFactory.createBevelBorder(30, Color.black, Color.BLUE));

        //MARK: NUMBER PANEL. USER INPUTS A NUMBER WHICH HE/SHE/IT WANNA TO CONVERT.
        numberPanel.setBackground(Color.CYAN);
        numberPanel.setBounds(80, 20, 250, 80);
        numberPanel.add(labelForNumberPanel, BorderLayout.NORTH);
        numberPanel.add(textField, BorderLayout.SOUTH);

        //MARK: CHOICE PANEL. USER CHOOSE A UNIT OF DISTANCE TO CONVERT HIS/HER/ITS NUMBER.
        choicePanel.setBackground(Color.ORANGE);
        choicePanel.setBounds(80, 110, 250, 80);
        choicePanel.add(labelForChoiсePanel, BorderLayout.NORTH);
        choicePanel.add(buttonForKilometer, BorderLayout.SOUTH);
        choicePanel.add(buttonForMiles, BorderLayout.SOUTH);

        //MARK: RESULT PANEL. USER CAN SEE THE RESULTS OF THE CALCULATION :)
        resultPanel.setBackground(Color.yellow);
        resultPanel.setBounds(80, 230, 250, 30);
        resultPanel.add(labelForResultPanel, BorderLayout.NORTH);

        //MARK: FRAME. SOMETHING LIKE A VIEW :)
        frame.setResizable(false);
        frame.setSize(400, 300);
        frame.add(numberPanel);
        frame.add(choicePanel);
        frame.add(resultPanel);
        frame.add(resultButton);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Convert Everything");
        frame.setLayout(null);
        frame.setVisible(true);
        //MARK: SETTING UP ENDED

        resultButton.addActionListener(e -> buttonAction());
    }

    //MARK: LOGICS
    public void buttonAction() {

        //MARK: SOME MAGIC HERE!
        String text = textField.getText();
        result = Float.parseFloat(text);
        float resultForKilometer =  result * 1.609347F;
        float resultForMiles = result / 1.609347F;

        if (buttonForKilometer.getModel().isSelected()) {
            labelForResultPanel.setText("Results are: " +  resultForKilometer);
        }
        else if (buttonForMiles.getModel().isSelected()) {
            labelForResultPanel.setText("Results are: " +  resultForMiles);

        }
    }
}

//MARK: CLASSIC NOOBY WAY ;)
class Number1Original {
    Float mile;
    Float kilometer;

    void somethingToKilometer() {
        mile = 0F;
        kilometer = 0F;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose units of distance you wanna to convert to something");
        System.out.println("Type a number of unit you want:");
        System.out.println("1. Kilometer, 2. Miles");

        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.println("Type amout of kilometers to convert");
                kilometer = scanner.nextFloat();
                System.out.println("Results are:" + kilometer / 1.609347F);
            }
            case 2 -> {
                System.out.println("Type amout of miles to convert");
                mile = scanner.nextFloat();
                System.out.println("Results are:" + mile * 1.609347F);
            }
            default -> System.out.println("Error");
        }
    }
}