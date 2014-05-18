/**
 * Created by Doug on 5/18/2014.
 */

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

}
