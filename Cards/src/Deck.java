import java.util.ArrayList;

/**
 * Created by Douglas Lenz on 5/18/2014.
 *
 * A Deck class. Represents a standard playing card deck of 52 cards. Constructor initializes all cards to the deck in order:
 * Hearts, Diamonds, Spades, Clubs. Has operations to shuffle the deck, print to console, peek top card, peek bottom card, remove top card
 * deal a hand, and give the current size of the deck.
 *
 * Dealing a hand operation actually removes cards from the instance of deck, so it is important to check how large or small the
 * deck is. The same goes for removing top card.
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

    public void addToBottom(Card c) {
        cards.add( c );
    }
    public void addToBottom(ArrayList<Card> c) {
        cards.addAll( c );
    }

    public void addToTop(Card c) {
        cards.add( 0, c );
    }

    public void addToTop(ArrayList<Card> c) {
        cards.addAll( 0, c );
    }

    public int getSize() {
        return cards.size();
    }
}
