package GameModel;
        import javax.swing.*;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Map;


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

    public ArrayList<Card> getDeck() { return deck; }

    public Card removeRandomCard(){

        Collections.shuffle(deck);
        return deck.remove(0);
    }
}
