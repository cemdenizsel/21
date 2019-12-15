package GUI;

import javax.swing.*;

public class RoundView extends View {

    private JPanel panel;
    private JPanel playerCardPanel;
    private JPanel dealerCardPanel;
    private JLabel dealerLabel;
    private JLabel playerLabel;
    private JButton hitButton;
    private JButton stayButton;
    private JButton pauseButton;
    private JButton resumeButton;


    public JLabel getDealerLabel() {
        return dealerLabel;
    }

    public JLabel getPlayerLabel() {
        return playerLabel;
    }

    public void setDealerLabel(JLabel dealerLabel) {
        this.dealerLabel = dealerLabel;
    }

    public void setPlayerLabel(JLabel playerLabel) {
        this.playerLabel = playerLabel;
    }
}
