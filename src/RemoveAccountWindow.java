import classes.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveAccountWindow extends JFrame {
    private JPanel mainPanel;
    private JButton removeAccountWindow_RemoveAccountBtn;
    private JTextField removeAccountWindow_AccountTypeTE;
    private JTextField removeAccountWindow_AccountEmailTE;
    private JTextField removeAccountWindow_AccountPasswordTE;
    private JButton removeAccountWindow_ClearInputsBtn;
    private JButton removeAccountWindow_GoBackBtn;
    public JLabel removeAccountWindow_MainHeadingTextLabel;
    private JLabel removeAccountWindow_ErrorLabel;


    public RemoveAccountWindow() {

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
        setTitle("AccountGuardUI - Remove Account Window");
        Image titleBarIcon = new ImageIcon("assets/imgs/lock-logo.png").getImage();
        setIconImage(titleBarIcon);

        // Btn colors
        Color exitClearBtnDefaultBgColor = removeAccountWindow_GoBackBtn.getBackground();
        Color exitClearBtnHoverBgColor = new Color(82, 124, 0);

        Color removeBtnDefaultBgColor = removeAccountWindow_RemoveAccountBtn.getBackground();
        Color removeBtnHoverBgColor = new Color(121, 182, 0);

        // Go Back Btn
        removeAccountWindow_GoBackBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                removeAccountWindow_GoBackBtn.setBackground(exitClearBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                removeAccountWindow_GoBackBtn.setBackground(exitClearBtnDefaultBgColor);
            }
        });
        removeAccountWindow_GoBackBtn.addActionListener(new ActionListener() {
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

        // Remove Account Btn
        removeAccountWindow_RemoveAccountBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                removeAccountWindow_RemoveAccountBtn.setBackground(removeBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                removeAccountWindow_RemoveAccountBtn.setBackground(removeBtnDefaultBgColor);
            }
        });
        removeAccountWindow_RemoveAccountBtn.addActionListener(new ActionListener() {
            /**
             * This is used to remove an account
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Removed Account!");

                Boolean emptyInputs = false;
                Boolean accountDoesNotExists = false;
                Boolean noAccounts = false;

                String emptyInputsError = "Error: One or more inputs are empty or the first value is a space.";
                String accountDoesNotExistsError = "Error: That account does not exist.";
                String noAccountsError = "Error: There are no accounts stored.";


                // Checking if any of the inputs are empty or has a space
                if (removeAccountWindow_AccountTypeTE.getText().isEmpty() || removeAccountWindow_AccountTypeTE.getText().charAt(0) == ' ') {
                    emptyInputs = true;
                } else if (removeAccountWindow_AccountEmailTE.getText().isEmpty() || removeAccountWindow_AccountEmailTE.getText().charAt(0) == ' ') {
                    emptyInputs = true;
                } else if (removeAccountWindow_AccountPasswordTE.getText().isEmpty() || removeAccountWindow_AccountPasswordTE.getText().charAt(0) == ' ') {
                    emptyInputs = true;
                }

                // If no accounts/account exists
                if (storedAccounts.size() != 0) {

                    Account account = new Account(removeAccountWindow_AccountTypeTE.getText(), removeAccountWindow_AccountEmailTE.getText(), removeAccountWindow_AccountPasswordTE.getText());

                    for (Account acc : storedAccounts) {
                        if (!acc.equals(account)) {
                            accountDoesNotExists = true;
                            break;
                        }
                    }
                } else {
                    noAccounts = true;
                }

                // Displaying error text
                if (emptyInputs) {
                    removeAccountWindow_ErrorLabel.setVisible(true);
                    removeAccountWindow_ErrorLabel.setText(emptyInputsError);
                }

                if (accountDoesNotExists) {
                    removeAccountWindow_ErrorLabel.setVisible(true);
                    removeAccountWindow_ErrorLabel.setText(accountDoesNotExistsError);
                }

                if (noAccounts) {
                    removeAccountWindow_ErrorLabel.setVisible(true);
                    removeAccountWindow_ErrorLabel.setText(noAccountsError);
                }


                // Adding account if things are correct
                if (!emptyInputs && !accountDoesNotExists && !noAccounts) {
                    removeAccountWindow_ErrorLabel.setVisible(false);
                    removeAccountWindow_ErrorLabel.setText("Error: PLACE_TEXT_HERE");


                }


            }
        });


        // Clear Inputs Btn
        removeAccountWindow_ClearInputsBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                removeAccountWindow_ClearInputsBtn.setBackground(exitClearBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                removeAccountWindow_ClearInputsBtn.setBackground(exitClearBtnDefaultBgColor);
            }
        });
        removeAccountWindow_ClearInputsBtn.addActionListener(new ActionListener() {
            /**
             * This is used to clear the text fields
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAccountWindow_AccountTypeTE.setText("");
                removeAccountWindow_AccountEmailTE.setText("");
                removeAccountWindow_AccountPasswordTE.setText("");
            }
        });

    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        RemoveAccountWindow window = new RemoveAccountWindow();

        // Showing the app
        window.setVisible(true);

    }
}
