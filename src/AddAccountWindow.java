import javax.swing.*;
import java.util.ArrayList;

public class AddAccountWindow extends JFrame {
    private JPanel panelMain;

    public static void setUpWindow(AddAccountWindow window, String title, ArrayList<Integer> sizes) {
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


    public AddAccountWindow() {
        /**
         * This is an instance of the AddAccountWindow
         */

        setContentPane(panelMain); // This will show the widgets in the app
    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        AddAccountWindow window = new AddAccountWindow();
        ArrayList<Integer> sizes = new ArrayList<>();

        // Adding the measurements to the sizes array
        sizes.add(900);
        sizes.add(900);

        setUpWindow(window, "AccountGuardUI - Add Account Window", sizes);

        // Showing the app
        window.setVisible(true);

    }


}
