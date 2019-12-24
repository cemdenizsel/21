package GameModel;
import java.io.IOException;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private int value = 0;
    private int numberOfAces = 0;
    private Deck deck;

    public Hand(Deck deck)  throws IOException {
        this.hand = new ArrayList<Card>();
        this.deck = deck;
        drawCard(deck.removeRandomCard());
        drawCard(deck.removeRandomCard());
        adjustForAce();

    }

    public void drawCard(Card card){
        hand.add(card);
        if (card.getRank().equals("Ace"))
            numberOfAces++;
        value += card.getValue();
    }

    public void adjustForAce() {
        if (value > 21 && numberOfAces > 0) {
            value -= 10;
            numberOfAces--;
        }
    }

    public int getValue() { return value; }

    public int getAces() { return numberOfAces; }

    public void setValue(int value) { this.value = value; }

    public void setAces(int value) { this.numberOfAces = value; }

    public ArrayList<Card> getHand() {
        return hand;
    }
}



