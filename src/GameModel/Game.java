package GameModel;

import java.io.IOException;

public class Game {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;
    private int total = 500;

    public Game() throws IOException {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    public void bet(int bet) {
        if(bet <= total)
            total -= bet;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
