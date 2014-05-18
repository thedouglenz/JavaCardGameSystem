import java.util.ArrayList;

/**
 * Created by Doug on 5/18/2014.
 */
public class Player {
    private int number;
    private Hand currentHand;

    public Player(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setHand(Hand h) {
        this.currentHand = h;
    }

    public void addToHand(ArrayList<Card> newCards) {
        currentHand.addToHand(newCards);
    }

    public void printCurrentHand() {
        System.out.println("Player " + this.number);
        currentHand.printHand();
    }

    public boolean handEmpty() {
        if(currentHand.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getCurrentHandSize() {
        return currentHand.getSize();
    }

    public Card playCard() {
        return currentHand.removeFirstCard();
    }

}
