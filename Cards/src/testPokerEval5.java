/**
 * Created by douglas lenz on 5/18/2014.
 */
public class testPokerEval5 {

    /*
    A test class to ensure that the Poker Hand Evaluator is working correctly
     */
    public static void main(String[] args) {

        for(int i=0; i < 50; ++i) {
            Deck testDeck = new Deck();

            testDeck.shuffleDeck();

            Hand testHand = testDeck.dealHand(5);
            testHand.printHand();
            System.out.println();
            PokerHandEvaluator5Card testEvaluator = new PokerHandEvaluator5Card(testHand);
        }
        //PokerHandEvaluator5Card testEvaluator = new PokerHandEvaluator5Card(testHand);

    }

}
