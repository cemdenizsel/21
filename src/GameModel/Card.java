package GameModel;
import javax.swing.*;
import java.util.Map;

public class Card {
    private boolean face;
    private String suit;
    private int value;
    private ImageIcon image;
    private String rank;
    public static Map<String,Integer> values = Map.ofEntries(Map.entry("Two",2),Map.entry("Three",3),Map.entry("Four",4),Map.entry("Five",5),
            Map.entry("Six",6),Map.entry("Seven",7),Map.entry("Eight",8),Map.entry("Nine",9),Map.entry("Ten",10),Map.entry("Jack",10),
            Map.entry("Queen",10),Map.entry("King",10),Map.entry("Ace",11));

    public Card(boolean face,String suit, String rank, ImageIcon image){
        this.face = face;
        this.suit = suit;
        this.rank = rank;
        this.value = values.get(rank);
        this.image = image;
    }

    public boolean getFace() { return face; }

    public int getValue() { return value; }

    public String getSuit() { return suit; }

    public String getRank() { return rank; }

    public ImageIcon getImage() { return image; }

    public void setFace(boolean face) { this.face = face; }

    public void setValue(int value) { this.value = value; }

    public void setSuit(String suit) { this.suit = suit; }

    public void setImage(ImageIcon image) { this.image =  image; }

}
