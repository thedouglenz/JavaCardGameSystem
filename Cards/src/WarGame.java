/**
 * Created by Doug on 5/18/2014.
 */
public class WarGame {
    public static void main(String[] args) {
        // Create the controller object and pass it the important models
        WarController warController = new WarController(new Deck(), new Player(1), new Player(2));

        // Create the view object and pass it the controller object
        WarGUI window = new WarGUI(warController);


        // Display the view
        //window.displayWindow();
        GUITest guiTest = new GUITest();
    }
}
