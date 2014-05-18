import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Doug on 5/18/2014.
 *
 * This is the main window that will be used as the view for the application when it opens.
 *
 */
public class WarGUI extends JFrame {
    private static final Dimension WINDOWSIZE = new Dimension(500, 500);
    private static final String WINDOWTITLE = "Java War Game";
    private static final String CARDBACKVERTICAL = "assets/backv.png";
    private static final int VERTICAL = 1;
    private static final int HORIZONTAL = 2;
    private CardImagePanel playersOverturned;
    private CardImagePanel computersOverturned;
    private JPanel middleOfWindow;
    private JPanel computerPanel;
    private JPanel playerPanel;

    private WarController warController;

    public WarGUI(final WarController warController) {
        // Set constants
        this.setPreferredSize(WINDOWSIZE);
        this.setTitle(WINDOWTITLE);

        // Initialize some GUI components
        middleOfWindow = new JPanel();
        computerPanel = new JPanel();
        playerPanel = new JPanel();
        middleOfWindow.add(computerPanel, BorderLayout.NORTH);
        middleOfWindow.add(playerPanel, BorderLayout.SOUTH);

        // Give the GUI access to its controller
        this.warController = warController;

        // Give the GUI some more components
        playersOverturned = new CardImagePanel("assets/backh.png", HORIZONTAL);
        computersOverturned = new CardImagePanel("assets/backh.png", HORIZONTAL);


        playersOverturned.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Trigger the play action in the controller
                warController.player1Action();

                // Update the view after the new cards are played
                ArrayList<Card> playerCards = warController.getTableCards()[0];
                ArrayList<Card> computerCards = warController.getTableCards()[1];
                playerPanel.add(new CardImagePanel(playerCards.get(playerCards.size()-1).imagePath, VERTICAL) );
                computerPanel.add(new CardImagePanel(computerCards.get(computerCards.size()-1).imagePath, VERTICAL));

                // Check the game state
                if(warController.getGameState() == GameState.WARRING) {
                    computerPanel.add(new CardImagePanel(CARDBACKVERTICAL, VERTICAL));
                    playerPanel.add(new CardImagePanel(CARDBACKVERTICAL, VERTICAL));
                }
                displayWindow();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



        // Define layout stuff and add components to the window
        this.add(playersOverturned, BorderLayout.SOUTH);
        this.add(computersOverturned, BorderLayout.NORTH);
        this.add(middleOfWindow, BorderLayout.CENTER);
    }

    // The function that will display the WarGUI window
    public void displayWindow() {
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.pack();
        this.setVisible(true);
    }

}

