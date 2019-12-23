package GUI;

import Controller.Controller;
import GameModel.Game;

import javax.swing.*;

public class View extends JFrame {

    private Controller controller;
    private StartView startView;
    private SessionView sessionView;
    private RoundView roundView;

    public View(final Controller controller){
        super();
        this.controller = controller;

        startView = new StartView(controller);
        sessionView = new SessionView(controller);


        setTitle("Blackjack");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        JDialog.setDefaultLookAndFeelDecorated(true);
        int response = JOptionPane.showConfirmDialog(null, "Are you older than 18 years old?", "Validation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else if (response == JOptionPane.YES_OPTION) {
            setToStartView();
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
        setVisible(true);
    }

    public void setToRoundView() {
        roundView = new RoundView(controller);
        remove(getContentPane());
        repaint();
        setContentPane(roundView);
        validate();
    }

    public void setToStartView() {
        remove(getContentPane());
        repaint();
        setContentPane(startView);
        validate();
    }

    public void setToSessionView(){

        remove(getContentPane());
        repaint();
        setContentPane(sessionView);
        validate();
    }

    public SessionView getSessionView() { return sessionView;}

    public RoundView getRoundView() { return roundView;}

    public StartView getStartView() { return startView;}

}


