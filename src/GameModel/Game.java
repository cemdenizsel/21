package GameModel;
import java.io.IOException;

public class Game {
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;
    private int total = 500;

    public Game()  throws IOException {


    }

    public void dealHands() throws IOException{
        deck = new Deck();
        playerHand = new Hand(deck);
        dealerHand = new Hand(deck);
    }

    public void bet(int bet) {
        if(bet <= total && bet > 0)
            total -= bet;
    }

    public Hand getPlayerHand() { return playerHand; }

    public void setPlayerHand(Card c) { playerHand.drawCard(c); }

    public Hand getDealerHand() { return dealerHand; }

    public Deck getDeck() { return deck; }

    public int getTotal() { return total; }

    public void setTotal(int total) { this.total = total ; }

    public void addToTotal(int bet) { this.total += bet; }

    public void hit(){
        Card card = deck.removeRandomCard();
        playerHand.drawCard(card);
    }

    public void setDealerHand(){
        while (dealerHand.getValue()<16)
        {
            dealerHand.drawCard(deck.removeRandomCard());
        }
    }
}
