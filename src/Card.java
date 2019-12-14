import java.awt.image.BufferedImage;

public class Card {
    boolean face;
    String suit;
    int value;
    BufferedImage image;

public Card(boolean face,String suit, int value, BufferedImage image){
    this.face = face;
    this.suit = suit;
    this.value = value;
    this.image = image;
}

public boolean getFace(){
    return face;
}

public int getValue(){
    return value;
}

public String getSuit(){
    return suit;
}

public BufferedImage getImage(){
    return image;
}

public void setFace(boolean face){
    this.face = face;
}

public void setValue(int value){
    this.value = value;
}

public void setSuit(String suit){
    this.suit = suit;
}

public void setImage(BufferedImage image){
    this.image =  image;
}
}
