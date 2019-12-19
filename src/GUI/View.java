package GUI;

import Controller.Controller;
import GameModel.Game;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private Controller controller;
    private StartView startView;
    private SessionView sessionView;
    private RoundView roundView;

    public View(){
        controller = new Controller(this);

        startView = new StartView();
        sessionView = new SessionView();
        roundView = new RoundView();

        setTitle("Blackjack");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        setVisible(true);
    }

    public Controller getController() { return controller; }

    public void setToRoundView() { setContentPane(roundView); }

    public void setToStartView() {setContentPane(startView); }

    public void setToSessionView(){ setContentPane(sessionView); }

    public JPanel getSessionView() { return sessionView;}

    public JPanel getRoundView() { return roundView;}

    public JPanel getStartView() { return startView;}

}


