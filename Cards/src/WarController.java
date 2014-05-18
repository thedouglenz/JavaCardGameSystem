import java.util.ArrayList;

/**
 * Created by Doug on 5/18/2014.
 *
 * The controller class helps mediate between the WarGUI and the Deck and Player models
 */
public class WarController {

    Deck deck;
    Player player1;
    Player player2;
    Table table;
    GameState gameState;

    public WarController(Deck deck, Player player1, Player player2) {
        this.deck = deck;
        this.player1 = player1;
        this.player2 = player2;

        initializeNewGame();
        this.gameState = GameState.STABLE;
    }

    public boolean gameOver() {
        if(player1.handEmpty() || player2.handEmpty()) {
            this.gameState = GameState.OVER;
            return true;
        } else {
            return false;
        }
    }

    public void initializeNewGame() {
        // reset the deck
        deck = new Deck();

        // clear the table
        table = new Table(2);

        // shuffle the cards
        deck.shuffleDeck();

        // deal the cards
        player1.setHand(deck.dealHand(26));
        player2.setHand(deck.dealHand(26));
    }

    public void player1Action() {

        // First the player lays down a card on his/her side of the table
        table.layCard(player1.playCard(), player1.getNumber());

        // Then the computer lays down a card on its side of the table
        table.layCard(player2.playCard(), player2.getNumber());

        // ----- DEBUG
        System.out.println("Table Side 1:");
        for(Card c : table.getSideCards(player1.getNumber())) {
            System.out.println(c.value + " " + c.suit + "\t");
        }
        System.out.println("Table Side 2:");
        for(Card c : table.getSideCards(player2.getNumber())) {
            System.out.println(c.value + " "  + c.suit + "\t");
        }

        // Then a comparison is made between the values of all cards on the table

    }

    public void processLatestTable() {
        switch (whoWon()) {
            case 1:
                player1.addToHand(table.pickupCards());
                this.gameState = GameState.STABLE;
                System.out.println("Player 1 wins this round"); // -- DEBUG
                break;
            case 2:
                player2.addToHand(table.pickupCards());
                this.gameState = GameState.STABLE;
                System.out.println("Player 2 wins this round"); // -- DEBUG
                break;
            case -1:
                // No player won this round yet, there is a tie.
                // Put one card out there face down
                // Allow the player to perform the play action again
                this.gameState = GameState.WARRING;
                System.out.println("No winner this round, going to war."); // -- DEBUG
                break;
        }
        System.out.println("Player 1 cards in hand: " + player1.getCurrentHandSize());
        System.out.println("Player 2 cards in hand: " + player2.getCurrentHandSize());
    }

    public int whoWon() {
        if(table.getSideCards(1).get(table.getSideCards(1).size()-1).value
                > table.getSideCards(2).get(table.getSideCards(2).size()-1).value) {
            // Player 1 wins
            return  1;
        } else if(table.getSideCards(1).get(table.getSideCards(1).size()-1).value
                < table.getSideCards(2).get(table.getSideCards(2).size()-1).value) {
            // Computer wins
            return 2;
        } else {
            // There is a tie
            return -1;
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public ArrayList<Card>[] getTableCards() {
        return table.getTableCards();
    }

}
