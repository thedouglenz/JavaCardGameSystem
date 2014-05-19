import java.util.ArrayList;

/**
 * Created by Doug on 5/18/2014.
 */
public class Hand {
    private int size;
    private ArrayList<Card> cards;

    public Hand(ArrayList<Card> cards) {
        this.size = cards.size();
        this.cards = cards;
    }

    public int getSize() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void printHand() {
        for(Card i : cards) {
            System.out.println(i.value + " " + i.suit);
        }
    }

    public Card removeFirstCard() {
        return cards.remove(0);
    }

    public void addToHand(ArrayList<Card> newCards) {
        cards.addAll(newCards);
    }
}
