import java.util.ArrayList;

/**
 * Created by Doug on 5/18/2014.
 */
public class Table {
    private ArrayList<Card>[] tableCards;
    private int sides;

    public Table(int sides) {
        this.sides = sides;
        tableCards = new ArrayList[sides];
        for(int i=0; i < sides; ++i) {
            tableCards[i] = new ArrayList<Card>();
        }
    }

    public ArrayList<Card>[] getTableCards() {
        return tableCards;
    }

    public void layCard(Card c, int side) {
        side--; // Fix side to correspond to the index of tableCards
        tableCards[side].add(c);
    }

    public ArrayList<Card> pickupCards() {
        ArrayList<Card> pickup = new ArrayList<Card>();
        for(int i = 0; i < sides; ++i) {
            pickup.addAll(tableCards[i]);
            tableCards[i].clear();
        }
        return pickup;
    }

    public int getSides() {
        return this.sides;
    }

    public ArrayList<Card> getSideCards(int side) {
        return tableCards[side - 1];
    }
}
