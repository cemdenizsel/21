package GameModel;

import java.io.IOException;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private int value = 0;
    private int numberOfAces = 0;

    public Hand()  throws IOException {
        this.hand = new ArrayList<Card>();
        Deck deck = new Deck();
        drawCard(deck.removeRandomCard());
        drawCard(deck.removeRandomCard());
        adjustForAce();
    }

    public void drawCard(Card card){
        hand.add(card);
        if (card.getRank()== "Ace")
            numberOfAces++;
        value += card.getValue();
    }

    public int getValue(){
        return value;
    }

    public int getAces(){
        return numberOfAces;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void adjustForAce(){
        if (value > 21 && numberOfAces > 0) {
            value -= 10;
            numberOfAces--;
        }
    }
}


