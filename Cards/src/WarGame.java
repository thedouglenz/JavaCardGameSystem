/**
 * Created by Doug on 5/18/2014.
 */
public class WarGame {
    public static void main(String[] args) {
        // Create the CONTROLLER object and pass it the important MODELS
        WarController warController = new WarController(new Deck(), new Player(1), new Player(2));

        // Create the VIEW object and pass it the controller object
        WarGUI window = new WarGUI(warController);


        // Display the VIEW
        window.displayWindow();



        //GUITest guiTest = new GUITest();
    }
}
