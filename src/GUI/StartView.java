package GUI;

import Controller.Controller;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class StartView extends JPanel {
    private JButton startButton;
    private JButton exitButton;
    private Controller controller;

    private JLabel highestScoreLabel;

    private int maxScore;

    public StartView(final Controller controller) {

        super();
        setLayout(null);
        this.controller = controller;
        setBackground(new Color(0,122,0));

        maxScore = controller.getHighestScore();


        highestScoreLabel = new JLabel("Highest Score: "+ maxScore);
        highestScoreLabel.setBounds(711,31,125,25);
        startButton = new JButton("Start Game");
        startButton.setBounds(711,375,100,25);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.startPressed();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        exitButton = new JButton("Exit Game");
        exitButton.setBounds(711,425,100,25);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exitPressed();
            }
        });

        add(highestScoreLabel);
        add(startButton);
        add(exitButton);
        setVisible(true);
    }

    public void updateTotal(){
        if(controller.getTotal()>=controller.getHighestScore()){
            maxScore = controller.getTotal();
            highestScoreLabel.setText("Highest Score: "+ maxScore);
        }
    }

}


