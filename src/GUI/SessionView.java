package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

public class SessionView extends JPanel {
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton withdrawButton;
    private JButton betButton;
    private JLabel totalAmount;


    private ImageIcon backOfCard;

    Controller controller;

    SessionView(final Controller controller){
        super();
        this.controller = controller;
        this.backOfCard = new ImageIcon("resources/blue.png");

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(new Color(0,122,0));
        topPanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.setBackground(new Color(0,122,0));
        bottomPanel.setBackground(new Color(0,122,0));

        setBottomPanel();
        setTopPanel();

        add(topPanel);
        add(bottomPanel);

    }

    public void setBottomPanel(){
        bottomPanel.setLayout(null);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(100,268,95,25);

        betButton = new JButton("Bet");
        betButton.setBounds(1336,268,95,25);

        JTextField betField = new JTextField("Enter your bet amount here");
        betField.setBounds(1160,268,155,25);
        betField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                betField.setText(null);
            }
        });




        totalAmount = new JLabel("Your total is: " +controller.getTotal() );
        totalAmount.setBounds(1045,268,150,25);

        JLabel card1 = new JLabel();
        JLabel card2 = new JLabel();
        card1.setBounds(711,169,128,159);
        card1.setIcon(backOfCard);
        card2.setBounds(825,169,128,159);
        card2.setIcon(backOfCard);


        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.withdrawPressed();
            }
        });

        betButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.betPressed(Integer.parseInt(betField.getText()));
                    totalAmount.setText("Your total is: " +controller.getTotal());

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(topPanel.getParent(),"Please enter a number!");
                }catch (IOException exception){
                    exception.printStackTrace();
                }
            }
        });

        bottomPanel.add(withdrawButton);
        bottomPanel.add(card1);
        bottomPanel.add(card2);

        bottomPanel.add(totalAmount);
        bottomPanel.add(betButton);
        bottomPanel.add(betField);
    }

    public void setTopPanel(){
        topPanel.setLayout(null);

        JLabel card1 = new JLabel();
        JLabel card2 = new JLabel();
        card1.setBounds(711,41,128,159);
        card1.setIcon(backOfCard);
        card2.setBounds(825,41,128,159);
        card2.setIcon(backOfCard);

        topPanel.add(card1);
        topPanel.add(card2);
    }
    public void setTotalLabel(){
        totalAmount.setText("Your total is: " + controller.getTotal());
    }

}
