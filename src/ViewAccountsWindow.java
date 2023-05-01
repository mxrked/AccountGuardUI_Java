import javax.swing.*;
import java.util.ArrayList;

public class ViewAccountsWindow extends JFrame {
    private JPanel panelMain;

    public static void setUpWindow(ViewAccountsWindow window, String title, ArrayList<Integer> sizes) {
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


    public ViewAccountsWindow() {
        /**
         * This is an instance of the ViewAccountsWindow
         */

        setContentPane(panelMain); // This will show the widgets in the app
    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        ViewAccountsWindow window = new ViewAccountsWindow();
        ArrayList<Integer> sizes = new ArrayList<>();

        // Adding the measurements to the sizes array
        sizes.add(900);
        sizes.add(900);

        setUpWindow(window, "AccountGuardUI - View Accounts Window", sizes);

        // Showing the app
        window.setVisible(true);

    }


}
