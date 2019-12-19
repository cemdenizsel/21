package GUI;

import Controller.Controller;
import javax.swing.*;

public class View extends JFrame {
    //private JFrame frame;
    private Controller controller;
    private StartView startView;
    private SessionView sessionView;
    private RoundView roundView;

    public View(){

        setTitle("Blackjack");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        setVisible(true);
    }

    public Controller getController() { return controller; }

    //public JFrame getFrame(){}


    public void initRoundView(){
        roundView = new RoundView();
        add(roundView);
        revalidate();
        setVisible(true);
    }

    public void initStartView(){
        startView = new StartView();
        add(startView);
    }

    public void initSessionView(){
        sessionView = new SessionView();
        add(sessionView);

    }
}


