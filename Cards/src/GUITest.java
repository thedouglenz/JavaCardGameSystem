import javax.swing.*;
import java.awt.*;

/**
 * Created by douglas lenz on 5/18/2014.
 *
 * Quick GUI test
 *
 * Just new an instance up in the main function to ensure yourself all the cards can be displayed.
 * Tests a full deck of cards, unshuffled.
 *
 */
public class GUITest extends JFrame {
    Deck testDeck;
    JPanel panel;

    public GUITest() {

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER,2,2));

        testDeck = new Deck();

        for(Card c : testDeck.cards) {
            panel.add(new CardImagePanel(c.imagePath, 1));
        }
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}
