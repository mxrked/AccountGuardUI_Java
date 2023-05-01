import javax.swing.*;
import java.util.ArrayList;

public class RemoveAccountWindow extends JFrame {
    private JPanel panelMain;

    public static void setUpWindow(RemoveAccountWindow window, String title, ArrayList<Integer> sizes) {
        /**
         * This is used
         * @param window = The window instance
         * @param title = The title of the window
         * @param sizes = The array of measurements for window (x,y)
         */
        window.setTitle(title);
        window.setSize(sizes.get(0), sizes.get(1));
        window.setResizable(false);
    }


    public RemoveAccountWindow() {
        /**
         * This is an instance of the RemoveAccountWindow
         */

        setContentPane(panelMain); // This will show the widgets in the app
    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        RemoveAccountWindow window = new RemoveAccountWindow();
        ArrayList<Integer> sizes = new ArrayList<>();

        // Adding the measurements to the sizes array
        sizes.add(900);
        sizes.add(900);

        setUpWindow(window, "AccountGuardUI - Remove Account Window", sizes);

        // Showing the app
        window.setVisible(true);

    }


}
