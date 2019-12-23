package GUI;

import Controller.Controller;
import GameModel.Hand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoundView extends JPanel {

    private JPanel bottomPanel;
    private JPanel topPanel;
    private JLabel dealerLabel;
    private JLabel playerLabel;
    private JButton hitButton;
    private JButton stayButton;
    private JButton pauseButton;
    private JButton resumeButton;

    private JLabel playerCard1;
    private JLabel playerCard2;
    private JLabel dealerCard0;
    private JLabel dealerCard1;
    private JLabel dealerCard2;
    private JLabel dealerCard3;
    private JLabel dealerCard4;
    private JLabel dealerCard5;
    private Hand dealerHand;
    private Hand playerHand;
    private Controller controller;
    private ArrayList<JLabel> playerCardLabels;
    private ArrayList<JLabel> dealerCardLabels;

    public RoundView (final Controller controller){
        super();
        this.controller = controller;
        playerCardLabels = new ArrayList<>();
        dealerCardLabels = new ArrayList<>();

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(new Color(0,122,0));

        topPanel = new JPanel();
        bottomPanel = new JPanel();

        pauseButton = new JButton("Pause");
        resumeButton = new JButton("Resume");



        playerHand = controller.getGame().getPlayerHand();
        dealerHand = controller.getGame().getDealerHand();


        setBottomPanel();
        setDealerCardPanel();

        add(topPanel);
        add(bottomPanel);


    }


    public void setBottomPanel(){
        bottomPanel.setLayout(null);
        bottomPanel.setBackground(new Color(0,122,0));



        playerLabel = new JLabel("Player: " +playerHand.getValue() );
        playerLabel.setBounds(780,350,100,50);

        hitButton = new JButton("Hit");
        hitButton.setBounds(1005,268,100,25);


        stayButton = new JButton("Stay");
        stayButton.setBounds(1160,268,100,25);

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.hitPressed();
                JLabel newCard = new JLabel();
                setCardPositions(newCard);
                newCard.setIcon(playerHand.getHand().get(playerHand.getHand().size() - 1).getImage());
                bottomPanel.add(newCard);
                playerLabel.setText("Player: " + playerHand.getValue());
                if(!controller.checkPlayerNotBusted()) {
                    JOptionPane.showMessageDialog(bottomPanel.getParent(),"You are busted!!! GAME OVER!");
                    controller.roundFinished();

                }

            }
        });
        stayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gameResult = controller.stayPressed();
                setDealersCardPositions();
                dealerLabel.setText("Dealer: " + dealerHand.getValue());
                if(gameResult == 0){
                    JOptionPane.showMessageDialog(bottomPanel.getParent(),"You are busted!!! GAME OVER!");
                    controller.roundFinished();
                }else if(gameResult == 1){
                    JOptionPane.showMessageDialog(bottomPanel.getParent(),"Congrats, You Win!!!");
                    controller.roundFinished();
                }else{
                    JOptionPane.showMessageDialog(bottomPanel.getParent(),"Game Tied!!!");
                    controller.gameTied();
                }


            }
        });



        playerCard1 = new JLabel();
        playerCard2 = new JLabel();


        playerCard1.setBounds(711,169,128,159);
        playerCard2.setBounds(825,169,128,159);

        playerCard1.setIcon(playerHand.getHand().get(0).getImage());
        playerCard2.setIcon(playerHand.getHand().get(1).getImage());

        bottomPanel.add(playerCard1);
        bottomPanel.add(playerCard2);

        playerCardLabels.add(playerCard1);
        playerCardLabels.add(playerCard2);





        bottomPanel.add(hitButton);
        bottomPanel.add(stayButton);
        bottomPanel.add(playerLabel);



    }

    public void setDealerCardPanel() {
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(0, 122, 0));
        dealerLabel = new JLabel("Dealer: ");
        dealerLabel.setBounds(780,5,100,16);

        topPanel.add(dealerLabel);

        dealerCard0 = new JLabel();
        dealerCard1 = new JLabel();
        dealerCard2 = new JLabel();
        dealerCard3 = new JLabel();
        dealerCard4 = new JLabel();
        dealerCard5 = new JLabel();

        dealerCard0.setBounds(711,41,128,159);
        dealerCard1.setBounds(825,41,128,159);
        dealerCard2.setSize(128,159);
        dealerCard3.setSize(128,159);
        dealerCard4.setSize(128,159);
        dealerCard5.setSize(128,159);

        dealerCard0.setIcon(dealerHand.getHand().get(0).getImage());
        dealerCard1.setIcon(new ImageIcon("C:\\Users\\BerkerGurcay\\IdeaProjects\\MVC\\resources\\blue.png"));

        dealerCardLabels.add(dealerCard0);
        dealerCardLabels.add(dealerCard1);
        dealerCardLabels.add(dealerCard2);
        dealerCardLabels.add(dealerCard3);
        dealerCardLabels.add(dealerCard4);
        dealerCardLabels.add(dealerCard5);



        topPanel.add(dealerCard0);
        topPanel.add(dealerCard1);
        topPanel.add(dealerLabel);

    }

    public void setCardPositions(JLabel newCard){
        int lastCardsX = playerCardLabels.get(playerCardLabels.size()-1).getX();
        int lastCardsY = playerCardLabels.get(playerCardLabels.size()-1).getY();
        newCard.setBounds(lastCardsX,lastCardsY,128,159);
        for(JLabel card : playerCardLabels ){
            card.setLocation(card.getX()-128,card.getY());
        }
        playerCardLabels.add(newCard);

    }

    public void setDealersCardPositions(){
        int sizeOfDealerHand= dealerHand.getHand().size();
        if(sizeOfDealerHand > 2) {
            for (int i = 0; i < sizeOfDealerHand; ++i) {
                JLabel label = dealerCardLabels.get(i);
                if(i<2){
                    label.setLocation(label.getX()-128,label.getY());

                }else{
                    label.setLocation((dealerCardLabels.get(i-1).getX()+124),dealerCard0.getY());
                }
                label.setIcon(dealerHand.getHand().get(i).getImage());
                topPanel.add(label);
            }
        }else
            dealerCard1.setIcon(dealerHand.getHand().get(1).getImage());

    }

}
