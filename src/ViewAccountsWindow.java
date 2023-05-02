import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ViewAccountsWindow extends JFrame {
    private JPanel mainPanel;

    private ImageIcon bgGradient;


    public ViewAccountsWindow() {

        // Displays the content
        setContentPane(mainPanel);

        // Clicking the "X" exit button, brings user back to start window
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                StartWindow window = new StartWindow();
                window.setVisible(true);

                // This makes it so the window will stay where to window was last position
                window.setLocation(getLocation());

                setVisible(false);

            }
        });

        // Window setup
        setSize(750, 800);
        setResizable(false);
        setLocationRelativeTo(null); // Centers the window
        setTitle("AccountGuardUI - View Accounts Window");
        Image titleBarIcon = new ImageIcon("assets/imgs/lock-logo.png").getImage();
        setIconImage(titleBarIcon);

        // Adding a background image to mainPanel
        bgGradient = new ImageIcon("assets/imgs/bg.png");
        Border border = new Border() {
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.drawImage(bgGradient.getImage(), x, y, width, height, null);
            }
            public Insets getBorderInsets(Component c) {
                return new Insets(bgGradient.getIconHeight(), bgGradient.getIconWidth(), bgGradient.getIconHeight(), bgGradient.getIconWidth());
            }
            public boolean isBorderOpaque() {
                return true;
            }
        };
        mainPanel.setBorder(border);
        mainPanel.setOpaque(false);

        // Btn colors

    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        ViewAccountsWindow window = new ViewAccountsWindow();

        // Showing the app
        window.setVisible(true);

    }
}
