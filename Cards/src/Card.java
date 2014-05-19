/**
     05, 2014
     Created by Doug on 5/18/2014.

    A Card class to encapsulate the value(or rank), suit, and associated image of a card. Associated images are String relative paths.
    Use image path with BufferedImage

 **/
public class Card {

    int value;
    Suit suit;
    String imagePath;

    public Card(int value, Suit suit, String imagePath) {
        this.value = value;
        this.suit = suit;
        this.imagePath = imagePath;
    }

    public void printThisCard() {
        System.out.println(this.value + " " + this.suit);
    }

    public int getValue() {
        return value;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Suit getSuit() {
        return this.suit;
    }

}
