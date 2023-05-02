package old;

import javax.swing.*;
import java.awt.*;
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

    public static void addingBgToWindow(JPanel panelMain) {
        /**
         * This is used to add a background image to the panelMain
         */
        // panelMain.setLayout(new BorderLayout());

        // Set the size of the panel to the size of the parent container
        panelMain.setPreferredSize(new Dimension(900, 900));

        // Create a scaled version of the background image to fill the panel
        ImageIcon bgGradient = new ImageIcon("assets/imgs/bg.png");
        Image image = bgGradient.getImage().getScaledInstance(panelMain.getPreferredSize().width, panelMain.getPreferredSize().height, Image.SCALE_SMOOTH);
        ImageIcon scaledGradient = new ImageIcon(image);
        JLabel bgGradientLabel = new JLabel(scaledGradient);

        panelMain.add(bgGradientLabel, BorderLayout.CENTER);

        bgGradientLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bgGradientLabel.setVerticalAlignment(SwingConstants.CENTER);

        System.out.println(bgGradient);

        panelMain.setOpaque(false);

    }

    public AddAccountWindow() {
        /**
         * This is an instance of the AddAccountWindow
         */

        setContentPane(panelMain); // This will show the widgets in the app
        panelMain.setLayout(new BorderLayout());
        addingBgToWindow(panelMain); // Adding the background image


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
