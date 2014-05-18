import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Doug on 5/18/2014.
 */
public class CardImagePanel extends JPanel {

    private String filename;
    private BufferedImage image;

    private static final int VERTICAL = 1;
    private static final int HORIZONTAL = 2;

    public CardImagePanel(String filename, int orientation) {
        this.filename = filename;
        if(orientation == HORIZONTAL) {
            this.setPreferredSize(new Dimension(200, 90));
        } else if (orientation == VERTICAL) {
            this.setPreferredSize(new Dimension(90, 200));
        } else {
            this.setPreferredSize(new Dimension(90, 200));
        }
        tryGetImage();
    }

    private boolean tryGetImage() {
        try {
            image = ImageIO.read(new File(filename));
        } catch(IOException e) {
            return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 150, 90, Color.darkGray, null);
    }
}
