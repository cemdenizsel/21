package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RoundView extends JPanel {

    private JPanel panel;
    private JPanel playerCardPanel;
    private JPanel dealerCardPanel;
    private JLabel dealerLabel;
    private JLabel playerLabel;
    private JButton hitButton;
    private JButton stayButton;
    private JButton pauseButton;
    private JButton resumeButton;

    JLabel playerCard1;
    JLabel playerCard2;
    JLabel playerCardHit;
    JLabel dealerCard0;
    JLabel dealerCard2;
    JLabel dealerCard1;
    JLabel dealerCardHit;

    public RoundView (){
        super();
        dealerCardPanel = new JPanel();
        playerCardPanel = new JPanel();
        hitButton = new JButton();
        stayButton = new JButton();
        pauseButton = new JButton();
        resumeButton = new JButton();

        dealerLabel = new JLabel();
        playerLabel = new JLabel();

        playerCard1 = new JLabel();
        playerCard2 = new JLabel();
        dealerCard0 = new JLabel();
        dealerCard1 = new JLabel();
        playerCardHit = new JLabel();
        dealerCard2 = new JLabel();
        dealerCard2 = new JLabel();
        dealerCardHit = new JLabel();


        setBackground(new Color(0, 122, 0));
        dealerCardPanel.setBackground(new Color(0, 122, 0));
        playerCardPanel.setBackground(new Color(0, 122, 0));

        setLayout(new FlowLayout());
        hitButton.setText("  Hit");
        hitButton.setEnabled(true);
        stayButton.setText("  Stay");
        stayButton.setEnabled(true);

        dealerLabel.setText("  Dealer:  ");
        playerLabel.setText("  Player:  ");

        add(hitButton);
        add(stayButton);
        playerCardPanel.add(playerLabel);
        dealerCardPanel.add(dealerLabel);

        setLayout(new BorderLayout());
        add(dealerCardPanel, BorderLayout.CENTER);
        add(playerCardPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public JLabel getDealerLabel() { return dealerLabel; }

    public JLabel getPlayerLabel() { return playerLabel; }

    public void setDealerLabel(JLabel dealerLabel) { this.dealerLabel = dealerLabel; }

    public void setPlayerLabel(JLabel playerLabel) { this.playerLabel = playerLabel; }
}
