import java.util.ArrayList;

/**
 * Created by Doug on 5/18/2014.
 */
public class Deck {

    final int NUMBEROFCARDS = 52;
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>(NUMBEROFCARDS);

        for(int i=0; i < 13; ++i) {
            // Set all hearts
            cards.add(new Card(i+1, Suit.HEARTS, "assets/h"+(i+1)+".png"));
        }
        for(int i=0; i < 13; ++i) {
            // Set all diamonds
            cards.add(new Card(i+1, Suit.DIAMONDS, "assets/d"+(i+1)+".png"));
        }
        for(int i=0; i < 13; ++i) {
            // Set all spades
            cards.add(new Card(i+1, Suit.SPADES, "assets/s"+(i+1)+".png"));
        }
        for(int i=0; i < 13; ++i) {
            // Set all clubs
            cards.add(new Card(i+1, Suit.CLUBS, "assets/c"+(i+1)+".png"));
        }
    }

    public void printDeck() {
        for(Card i : cards) System.out.println(i.value + " " + i.suit);
    }

    public void shuffleDeck() {
        ArrayList<Card> temp = new ArrayList<Card>();
        for(int i=0; i < NUMBEROFCARDS; ++i) {
            int choose = (int)(Math.random() * (NUMBEROFCARDS-i));
            temp.add(cards.get(choose));
            cards.remove(choose);
        }
        cards = temp;
    }

    public Card peekTopCard() {
        return cards.get(0);
    }
    public Card peekBottomCard() {
        return cards.get(cards.size() - 1);
    }

    public Card removeTopCard() {
        return cards.remove(0);
    }

    public Hand dealHand(int n) {
        ArrayList<Card> cardsForHand = new ArrayList<Card>();
        for(int j=0; j<n; ++j) {
            cardsForHand.add(cards.remove(0));
        }
        return new Hand(cardsForHand);
    }

    public int getSize() {
        return cards.size();
    }
}
