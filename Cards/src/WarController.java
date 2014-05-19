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

    public void player1Action() { // Lay cards on table

        // First the player lays down a card on his/her side of the table
        table.layCard(player1.playCard(), player1.getNumber());

        // Then the computer lays down a card on its side of the table
        table.layCard(player2.playCard(), player2.getNumber());
    }

    public void processLatestTable() { // Separate from laying cards on table so that the view has a chance to display the cards
        switch ( whoWon() ) {
            case 1: // player 1 wins
                player1.addToHand(table.pickupCards());
                this.gameState = GameState.STABLE;
                break;
            case 2: // player 2 wins
                player2.addToHand(table.pickupCards());
                this.gameState = GameState.STABLE;
                break;
            case -1: // tie
                // No player won this round yet, there is a tie.
                // Put one card out there face down
                // Allow the player to perform the play action again
                this.gameState = GameState.WARRING;
                break;
        }
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
