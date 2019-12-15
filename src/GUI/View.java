package GUI;

import Controller.Controller;
import javax.swing.*;

public class View extends JPanel {
    private JFrame frame;
    private JPanel panel;
    private Controller controller;


    public View(){
        frame = new JFrame();
        frame.setTitle("Blackjack");
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public Controller getController() { return controller; }

}


