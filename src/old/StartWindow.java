package old;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StartWindow extends JFrame {
    public JPanel panelMain;
    private ImageIcon bgGradient;


    public static void setUpWindow(StartWindow window, String title, ArrayList<Integer> sizes) {
        /**
         * This is used to setup the window itself
         * @param window = The window instance
         * @param title = The title of the window
         * @param sizes = The array of measurements for window (x,y)
         */
        window.setTitle(title);
        window.setSize(sizes.get(0), sizes.get(1));
        window.setResizable(false);
    }

    public static void addingBgToWindow(JPanel panelMain, ImageIcon bgGradient) {
        /**
         * This is used to add a background image to the panelMain
         */

        bgGradient = new ImageIcon("assets/imgs/bg.png");
        JLabel bgGradientLabel = new JLabel(bgGradient);

        panelMain.setPreferredSize(new Dimension(bgGradient.getIconWidth(), bgGradient.getIconHeight()));

        panelMain.add(bgGradientLabel, BorderLayout.CENTER);

        bgGradientLabel.setBounds(0, 0, bgGradient.getIconWidth(), bgGradient.getIconHeight());

        panelMain.setOpaque(false);
    }

    public StartWindow() {
        /**
         * This is an instance of the StartWindow
         */


        setContentPane(panelMain); // This will show the widgets in the app
        setVisible(true);

        addingBgToWindow(panelMain, bgGradient); // Adding the background image



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
