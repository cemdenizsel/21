package GameModel;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() throws IOException {
        this.deck = new ArrayList<Card>();
        String[] suits = {"hearts","diamonds","spades","clubs"};
        String[] ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};

        Map<String,Integer> values = Card.values;
        for(String suit:suits){
            for(String rank: ranks){
                int value = values.get(rank);
                String imageFile = Integer.toString(value) + suit.charAt(0);
                String filedir = "resources/" +imageFile+ ".jpg";
                ImageIcon bf = new ImageIcon(filedir);
                deck.add(new Card(false,suit,rank,bf));
            }
        }
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public Card removeRandomCard(){
        Random random = new Random();
        int r = random.nextInt(52);
        return deck.remove(r);
    }

}
