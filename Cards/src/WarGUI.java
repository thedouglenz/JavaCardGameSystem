import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Douglas Lenz on 5/18/2014.
 *
 * This is the main window that will be used as the view for a War game when it opens.
 *
 */
public class WarGUI extends JFrame {
    private static final Dimension WINDOWSIZE = new Dimension(900, 500);
    private static final String WINDOWTITLE = "Java War Game";
    private static final String CARDBACKHORIZONTAL = "assets/backh.png";
    private static final String CARDBACKVERTICAL = "assets/backv.png";
    private static final int VERTICAL = 1;
    private static final int HORIZONTAL = 2;
    private CardImagePanel playersOverturned;
    private CardImagePanel computersOverturned;
    private JPanel middleOfWindow;
    private JPanel computerPanel;
    private JPanel playerPanel;
    private JProgressBar playerProgress;

    private WarController warController;

    public WarGUI(final WarController wc) {
        // Some window adjustments
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(WINDOWSIZE);
        this.setTitle(WINDOWTITLE);

        // Initialize some GUI components
        middleOfWindow = new JPanel();
        computerPanel = new JPanel();
        playerPanel = new JPanel();
        playerProgress = new JProgressBar(JProgressBar.VERTICAL);
        playerProgress.setMaximum(52);
        playerProgress.setMinimum(0);
        playerProgress.setValue(0);
        playerProgress.setPreferredSize(new Dimension(100, 500));
        middleOfWindow.add(computerPanel, BorderLayout.NORTH);
        middleOfWindow.add(playerPanel, BorderLayout.SOUTH);

        // Give the GUI access to its controller
        this.warController = wc;

        // Give the GUI some components
        playersOverturned = new CardImagePanel(CARDBACKHORIZONTAL, HORIZONTAL);
        computersOverturned = new CardImagePanel(CARDBACKHORIZONTAL, HORIZONTAL);


        playersOverturned.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Trigger the play action in the controller
                warController.player1Action();

                // Update the view after the new cards are played
                final ArrayList<Card> playerCards = warController.getTableCards()[0];
                final ArrayList<Card> computerCards = warController.getTableCards()[1];

                computerPanel.add(new CardImagePanel(computerCards.get(computerCards.size() - 1).imagePath, VERTICAL));
                playerPanel.add(new CardImagePanel(playerCards.get(playerCards.size() - 1).imagePath, VERTICAL));

                playerPanel.revalidate();
                computerPanel.revalidate();
                refresh();

                try {
                    Thread.sleep(200);
                } catch(InterruptedException ex) {
                    ex.printStackTrace();
                }

                warController.processLatestTable();


                // Check the game state
                if(warController.getGameState() == GameState.WARRING) {
                    computerPanel.add(new CardImagePanel(CARDBACKVERTICAL, VERTICAL));
                    playerPanel.add(new CardImagePanel(CARDBACKVERTICAL, VERTICAL));
                } else {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            computerPanel.removeAll();
                            playerPanel.removeAll();
                        }
                    });
                }

                playerProgress.setValue(warController.player1.getCurrentHandSize());
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
        this.add(playerProgress, BorderLayout.EAST);
    }

    // The function that will display the WarGUI window
    public void displayWindow() {
        this.pack();
        this.setVisible(true);
    }

    private void refresh() {
        this.repaint();
        this.revalidate();
        this.repaint();
    }

}

