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

    public StartView(final Controller controller) {

        super(new GridBagLayout());
        setBackground(new Color(0,122,0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();


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

        add(startButton,gridBagConstraints);
        add(exitButton,gridBagConstraints);
        setVisible(true);
    }


    public JButton getStartButton() { return startButton; }

    public JButton getExitButton() { return exitButton; }


}


