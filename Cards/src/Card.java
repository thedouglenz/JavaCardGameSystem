/**
     ${PROJECT_NAME}
     05, 2014
     Created by Doug on 5/18/2014.

     ${PACKAGE_NAME}
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

    public Suit getSuit() {
        return this.suit;
    }

}
