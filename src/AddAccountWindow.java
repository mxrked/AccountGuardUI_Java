import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import classes.Account;

public class AddAccountWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel addAccountWindow_GoBackBtnHolderPanel;
    private JButton addAccountWindow_GoBackBtn;
    private JTextField addAccountWindow_ConfirmAcountPasswordTE;
    public JTextField addAccountWindow_AccountTypeTE;
    private JButton addAccountWindow_AddAccountBtn;
    private JButton addAccountWindow_ClearBtn;
    public JLabel addAccountWindow_MainHeadingTextLabel;
    private JTextField addAccountWindow_AccountEmailTE;
    private JTextField addAccountWindow_AccountPasswordTE;
    private JLabel addAccountWindow_ErrorLabel;

    private ArrayList<Account> storedAccounts = StartWindow.storedAccounts;


    public AddAccountWindow() {


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
        setTitle("AccountGuardUI - Add Account Window");
        Image titleBarIcon = new ImageIcon("assets/imgs/lock-logo.png").getImage();
        setIconImage(titleBarIcon);

        // Btn colors
        Color exitClearBtnDefaultBgColor = addAccountWindow_GoBackBtn.getBackground();
        Color exitClearBtnHoverBgColor = new Color(82, 124, 0);

        Color addBtnDefaultBgColor = addAccountWindow_AddAccountBtn.getBackground();
        Color addBtnHoverBgColor = new Color(121, 182, 0);

        // Go Back Btn
        addAccountWindow_GoBackBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                addAccountWindow_GoBackBtn.setBackground(exitClearBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                addAccountWindow_GoBackBtn.setBackground(exitClearBtnDefaultBgColor);
            }
        });
        addAccountWindow_GoBackBtn.addActionListener(new ActionListener() {
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

        // Add Account Btn
        addAccountWindow_AddAccountBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                addAccountWindow_AddAccountBtn.setBackground(addBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                addAccountWindow_AddAccountBtn.setBackground(addBtnDefaultBgColor);
            }
        });
        addAccountWindow_AddAccountBtn.addActionListener(new ActionListener() {
            /**
             * This is used to add an account
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                Boolean emptyInputs = false;
                Boolean accountAlreadyExists = false;
                Boolean invalidEmail = false;

                String emptyInputsError = "Error: One or more inputs are empty or the first value is a space.";
                String accountAlreadyExistsError = "Error: That email is already in use.";
                String invalidEmailError = "Error: That email is invalid.";

                Account checkAccount = new Account(addAccountWindow_AccountTypeTE.getText(), addAccountWindow_AccountEmailTE.getText(), addAccountWindow_AccountPasswordTE.getText());

                // Checking if account already exists
                if (storedAccounts.contains(checkAccount)) {
                    accountAlreadyExists = true;

                    System.out.println(true);
                }

                // Checking if any of the inputs are empty or has a space
                if (addAccountWindow_AccountTypeTE.getText().isEmpty() || addAccountWindow_AccountTypeTE.getText().charAt(0) == ' ') {
                    emptyInputs = true;
                } else if (addAccountWindow_AccountEmailTE.getText().isEmpty() || addAccountWindow_AccountEmailTE.getText().charAt(0) == ' ') {
                    emptyInputs = true;
                } else if (addAccountWindow_AccountPasswordTE.getText().isEmpty() || addAccountWindow_AccountPasswordTE.getText().charAt(0) == ' ') {
                    emptyInputs = true;
                } else if (addAccountWindow_ConfirmAcountPasswordTE.getText().isEmpty() || addAccountWindow_ConfirmAcountPasswordTE.getText().charAt(0) == ' ') {
                    emptyInputs = true;
                }

                // Checking if the email input is valid or not
                String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher checkEmail = pattern.matcher(addAccountWindow_AccountEmailTE.getText());
                if (!checkEmail.matches()) {
                    invalidEmail = true;
                }

                // Displaying error text
                if (emptyInputs || invalidEmail) {
                    String errorMessage = "";
                    if (emptyInputs) {
                        errorMessage = emptyInputsError + "\n";
                    }
//                    if (accountAlreadyExists) {
//                        errorMessage = accountAlreadyExistsError + "\n";
//                    }
                    if (invalidEmail) {
                        errorMessage = invalidEmailError + "\n";
                    }
                    addAccountWindow_ErrorLabel.setText(errorMessage);
                    addAccountWindow_ErrorLabel.setForeground(Color.RED);
                    addAccountWindow_ErrorLabel.setVisible(true);
                } else {
                    String accountType = addAccountWindow_AccountTypeTE.getText();
                    String accountEmail = addAccountWindow_AccountEmailTE.getText();
                    String accountPassword = addAccountWindow_AccountPasswordTE.getText();


                    // Add account if not already in the array


                    Account account = new Account(accountType, accountEmail, accountPassword);
                    storedAccounts.add(account);
                }


            }
        });

        // Clear Inputs Btn
        addAccountWindow_ClearBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                addAccountWindow_ClearBtn.setBackground(exitClearBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                addAccountWindow_ClearBtn.setBackground(exitClearBtnDefaultBgColor);
            }
        });
        addAccountWindow_ClearBtn.addActionListener(new ActionListener() {
            /**
             * This is used to clear the text fields
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccountWindow_AccountTypeTE.setText("");
                addAccountWindow_AccountEmailTE.setText("");
                addAccountWindow_AccountPasswordTE.setText("");
                addAccountWindow_ConfirmAcountPasswordTE.setText("");
            }
        });

    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        AddAccountWindow window = new AddAccountWindow();

        // Showing the app
        window.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
