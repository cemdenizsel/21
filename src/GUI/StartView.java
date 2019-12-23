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

    private JLabel maxScoreLabel;

    int maxScore ;

    public StartView(final Controller controller) {

        super(new GridBagLayout());
        this.controller = controller;
        setBackground(new Color(0,122,0));

        maxScore = controller.getTotal();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();



        maxScoreLabel = new JLabel("Max Score: "+ maxScore);
        startButton = new JButton("Start Game");

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
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.exitPressed();
            }
        });

        add(maxScoreLabel,gridBagConstraints);
        add(startButton,gridBagConstraints);
        add(exitButton,gridBagConstraints);
        setVisible(true);
    }


    public JButton getStartButton() { return startButton; }

    public JButton getExitButton() { return exitButton; }


    public void updateTotal(){
        if(controller.getTotal()>500)
        maxScore = controller.getTotal();
        maxScoreLabel.setText("Max Score: "+ maxScore);
    }

}


