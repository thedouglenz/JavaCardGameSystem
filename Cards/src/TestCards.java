/**
 * Created by Doug on 5/18/2014.
 */
public class TestCards {

    public static void main(String[] args) {
        Deck testDeck = new Deck();
        testDeck.shuffleDeck();

        //d.printDeck();

        //Card a = d.removeTopCard();
        //a.printThisCard();

        //Hand testHand = testDeck.dealHand(5);
        //testHand.printHand();

        Player testPlayer1 = new Player(1);
        testPlayer1.setHand(testDeck.dealHand(26));
        testPlayer1.printCurrentHand();

        Player testPlayer2 = new Player(2);
        testPlayer2.setHand(testDeck.dealHand(26));
        testPlayer2.printCurrentHand();

        System.out.println("Size of deck now: " + testDeck.getSize());
    }
}
