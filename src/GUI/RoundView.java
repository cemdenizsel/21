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
    private JLabel playerCardHit;
    private JLabel dealerCard0;
    private JLabel dealerCard1;
    private JLabel dealerCard2;
    private JLabel dealerCard3;
    private JLabel dealerCard4;
    private JLabel dealerCard5;
    private JLabel dealerCard6;
    private Hand dealerHand;
    private Hand playerHand;
    private Controller controller;
    private ArrayList<JLabel> playerCardLabels;
    private ArrayList<JLabel> dealerCardLabels;

    private Timer timer;
    private JLabel timerLabel ;
    int duration = 30;
    int  timeLeft;

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

        timerLabel =  new JLabel("Time left: 30 ");

        playerHand = controller.getGame().getPlayerHand();
        dealerHand = controller.getGame().getDealerHand();

        setTimer();
        setBottomPanel();
        setTopPanel();

        add(topPanel);
        add(bottomPanel);


    }

    public Timer getTimer(){
        return timer;
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



        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.pausePressed();
                hitButton.setEnabled(false);
                stayButton.setEnabled(false);
                pauseButton.setEnabled(false);
                resumeButton.setEnabled(true);


            }
        });

        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controller.resumePressed();
                hitButton.setEnabled(true);
                stayButton.setEnabled(true);
                resumeButton.setEnabled(false);
                pauseButton.setEnabled(true);

            }
        });

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
               stay();
            }
        });



        playerCard1 = new JLabel();
        playerCard2 = new JLabel();


        playerCard1.setBounds(711,169,128,159);
        playerCard2.setBounds(825,169,128,159);
        timerLabel.setBounds(500,160,120,150);

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

    public void setTimer(){
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                duration--;
                timerLabel.setText("Time Left: " + duration);
                if(duration ==0){
                    stay();
                }
            }
        };
         timer = new Timer(1000 ,taskPerformer);
        timer.start();
    }

    private void stay() {
        int gameResult = controller.stayPressed();
        setDealersCardPositions();
        topPanel.validate();
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


    public void setTopPanel() {
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(0, 122, 0));
        dealerLabel = new JLabel("Dealer: ");
        dealerLabel.setBounds(780,5,100,16);

        timerLabel.setBounds(50,10,100,20);
        topPanel.add(timerLabel);
        topPanel.add(dealerLabel);


        pauseButton.setBounds(1160,66,100,25);


        resumeButton.setBounds(1160,91,100,25);
        resumeButton.setEnabled(false);

        dealerCard0 = new JLabel();
        dealerCard1 = new JLabel();
        dealerCard2 = new JLabel();
        dealerCard3 = new JLabel();
        dealerCard4 = new JLabel();
        dealerCard5 = new JLabel();
        dealerCard6 = new JLabel();

        dealerCard0.setBounds(711,41,128,159);
        dealerCard1.setBounds(825,41,128,159);
        dealerCard2.setSize(128,159);
        dealerCard3.setSize(128,159);
        dealerCard4.setSize(128,159);
        dealerCard5.setSize(128,159);

        dealerCard0.setIcon(dealerHand.getHand().get(0).getImage());
        dealerCard1.setIcon(new ImageIcon("resources/blue.png"));

        dealerCardLabels.add(dealerCard0);
        dealerCardLabels.add(dealerCard1);
        dealerCardLabels.add(dealerCard2);
        dealerCardLabels.add(dealerCard3);
        dealerCardLabels.add(dealerCard4);
        dealerCardLabels.add(dealerCard5);
        dealerCardLabels.add(dealerCard6);



        topPanel.add(dealerCard0);
        topPanel.add(dealerCard1);
        topPanel.add(dealerLabel);
        topPanel.add(pauseButton);
        topPanel.add(resumeButton);

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
            int firstCardsX = 0;
            int firstCardsY = 0;
            for (int i = 0; i < sizeOfDealerHand; ++i) {
                JLabel label = dealerCardLabels.get(i);
                if(i==0){
                    label.setLocation(label.getX()-(128*(sizeOfDealerHand-2)),label.getY());
                    firstCardsX = label.getX();
                    firstCardsY = label.getY();
                }else{
                    label.setLocation(firstCardsX+(i*128),firstCardsY);
                    label.setIcon(dealerHand.getHand().get(i).getImage());
                }
                topPanel.add(label);
            }
        }else
            dealerCard1.setIcon(dealerHand.getHand().get(1).getImage());

    }

}
