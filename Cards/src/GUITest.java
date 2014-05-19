import javax.swing.*;
import java.awt.*;

/**
 * Created by douglas lenz on 5/18/2014.
 *
 * Quick GUI test
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
