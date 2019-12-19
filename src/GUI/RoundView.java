package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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

    JLabel playerCard1;
    JLabel playerCard2;
    JLabel playerCardHit;
    JLabel dealerCard0;
    JLabel dealerCard2;
    JLabel dealerCard1;
    JLabel dealerCardHit;

    public RoundView () throws IOException {
        super();

        panel.setBackground(new Color(0, 122, 0));
        dealerCardPanel.setBackground(new Color(0, 122, 0));
        playerCardPanel.setBackground(new Color(0, 122, 0));

        panel.setLayout(new FlowLayout());
        hitButton.setText("  Hit");
        hitButton.setEnabled(false);
        stayButton.setText("  Stay");
        stayButton.setEnabled(false);

        dealerLabel.setText("  Dealer:  ");
        playerLabel.setText("  Player:  ");

        panel.add(hitButton);
        panel.add(stayButton);
        playerCardPanel.add(playerLabel);
        dealerCardPanel.add(dealerLabel);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(dealerCardPanel, BorderLayout.CENTER);
        add(playerCardPanel, BorderLayout.SOUTH);

    }

    public JLabel getDealerLabel() { return dealerLabel; }

    public JLabel getPlayerLabel() { return playerLabel; }

    public void setDealerLabel(JLabel dealerLabel) { this.dealerLabel = dealerLabel; }

    public void setPlayerLabel(JLabel playerLabel) { this.playerLabel = playerLabel; }
}
