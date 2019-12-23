package GameModel;
        import javax.swing.*;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Collections;



public class Deck {
    private ArrayList<Card> deck;

    public Deck() throws IOException {
        this.deck = new ArrayList<>();
        String[] suits = {"hearts","diamonds","spades","clubs"};
        String[] ranks = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};

        for(String suit:suits){
            for(String rank: ranks){
                String imageFile = rank + suit.charAt(0);
                String filedir = "resources/" +imageFile+ ".jpg";
                ImageIcon bf = new ImageIcon(filedir);
                deck.add(new Card(suit,rank,bf));
            }
        }
    }

    public ArrayList<Card> getDeck() { return deck;}

    public Card removeRandomCard(){

        Collections.shuffle(deck);
        return deck.remove(0);
    }
}
