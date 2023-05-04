import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import classes.Account;

public class ViewAccountsWindow extends JFrame {
    private JPanel mainPanel;
    private JButton viewAccountsWindow_GoBackButton;
    public JLabel viewAccountsWindow_MainHeadingTextLabel;
    public JList viewAccountsWindow_AccountTypeList;
    public JList viewAccountsWindow_AccountEmailList;
    public JList viewAccountsWindow_AccountPasswordList;
    private JButton refreshAccountsButton;
    private JLabel viewAccountsWindow_CurrentNumberOfAccountsLabel;

    private ImageIcon bgGradient;

    public void addAccountsFromArrayListToLists() {
        /**
         * This is used to add the account info to each of the respected lists
         */


        // Updating the number of accounts label
        String numberOfAccounts = "You currently have " + viewAccountsWindow_AccountTypeList.getModel().getSize() + " accounts stored.";
        viewAccountsWindow_CurrentNumberOfAccountsLabel.setText(numberOfAccounts);
    }

    public ViewAccountsWindow() {

        // Array of stored accounts
        ArrayList<Account> storedAccounts = StartWindow.storedAccounts;

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

        // Adding text to number of accounts label
        String numberOfAccounts = "You currently have " + viewAccountsWindow_AccountTypeList.getModel().getSize() + " accounts stored.";
        viewAccountsWindow_CurrentNumberOfAccountsLabel.setText(numberOfAccounts);

        // Btn colors
        Color exitClearBtnDefaultBgColor = viewAccountsWindow_GoBackButton.getBackground();
        Color exitClearBtnHoverBgColor = new Color(82, 124, 0);

        Color refreshBtnDefaultBgColor = refreshAccountsButton.getBackground();
        Color refreshBtnHoverBgColor = new Color(121, 182, 0);

        // Go Back Btn
        viewAccountsWindow_GoBackButton.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                viewAccountsWindow_GoBackButton.setBackground(exitClearBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                viewAccountsWindow_GoBackButton.setBackground(exitClearBtnDefaultBgColor);
            }
        });
        viewAccountsWindow_GoBackButton.addActionListener(new ActionListener() {
            /**
             * This is used to go back to the start window
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                StartWindow window = new StartWindow();
                window.setVisible(true);

                // This makes it so the window will stay where to window was last position
                window.setLocation(getLocation());

                setVisible(false);
            }
        });
        // Refresh Accounts Btn
        refreshAccountsButton.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                refreshAccountsButton.setBackground(refreshBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                refreshAccountsButton.setBackground(refreshBtnDefaultBgColor);
            }
        });
        refreshAccountsButton.addActionListener(new ActionListener() {
            /**
             * This is used refresh/add the accounts and label
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccountsFromArrayListToLists();
            }
        });
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
