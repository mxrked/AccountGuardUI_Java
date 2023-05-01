import javax.swing.*;
import java.util.ArrayList;

public class StartWindow extends JFrame {
    public JPanel panelMain;


    public static void setUpWindow(StartWindow window, String title, ArrayList<Integer> sizes) {
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


    public StartWindow() {
        /**
         * This is an instance of the StartWindow
         */

        setContentPane(panelMain); // This will show the widgets in the app

    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        StartWindow window = new StartWindow();
        ArrayList<Integer> sizes = new ArrayList<>();

        // Adding the measurements to the sizes array
        sizes.add(700);
        sizes.add(700);

        setUpWindow(window, "AccountGuardUI - Start Window", sizes);

        // Showing the app
        window.setVisible(true);

    }
}
