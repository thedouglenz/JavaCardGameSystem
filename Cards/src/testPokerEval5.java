/**
 * Created by douglas lenz on 5/18/2014.
 */
public class testPokerEval5 {

    public static void main(String[] args) {
        Deck testDeck = new Deck();

        testDeck.shuffleDeck();

        Hand testHand = testDeck.dealHand(5);

        testHand.printHand();

        System.out.println();

        PokerHandEvaluator5Card testEvaluator = new PokerHandEvaluator5Card(testHand);

    }

}
