package GameModel;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HandTest {
    @Test
    public void drawCardTest() throws IOException {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);
        int value = hand.getValue();

        assertEquals(2,hand.getHand().size());


        hand.drawCard(new Card("spades","Ten"));
        assertEquals(3,hand.getHand().size());
        assertEquals(value+10,hand.getValue());
    }

    @Test
    public void getAcesTest() throws IOException {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);
        int aces = hand.getAces();

        hand.drawCard(new Card("spades","Ace"));
        assertEquals(aces+1,hand.getAces());

    }

    @Test
    public void adjustForAceTest() throws IOException {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);

        hand.getHand().remove(0);
        hand.getHand().remove(0);
        hand.setValue(0);
        hand.setAces(0);

        hand.drawCard(new Card("spades","Ace"));
        hand.drawCard(new Card("clubs","Ace"));
        hand.adjustForAce();

        assertEquals(1,hand.getAces());
        assertEquals(12,hand.getValue());

        hand.drawCard(new Card("clubs","Ten"));
        hand.adjustForAce();
        assertEquals(12,hand.getValue());
        assertEquals(0,hand.getAces());

        hand.drawCard(new Card("diamonds","Nine"));
        assertEquals(21,hand.getValue());

    }

    @Test
    public void getValueTest() throws IOException {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);

        hand.setValue(1000);
        assertEquals(1000,hand.getValue());
    }

    @Test
    public void getNumberOfAces() throws IOException {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);

        hand.setAces(100);
        assertEquals(100,hand.getAces());
    }
}
