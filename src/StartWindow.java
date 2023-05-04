import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;
import classes.Account;

public class StartWindow extends JFrame {
    private JPanel mainPanel;
    private JLabel startWindow_MainHeadingTextLabel;
    private JLabel startWindow_MainHeadingImgLabel;
    private JLabel startWindow_SubTextLabel;
    private JButton startWindow_AddAccountBtn;
    private JButton startWindow_RemoveAccountBtn;
    private JButton startWindow_ViewAccountsBtn;
    private JButton startWindow_ExitBtn;
    private ImageIcon bgGradient;

    public static ArrayList<Account> storedAccounts = new ArrayList<>(); // THIS IS USED AS A GLOBAL THAT WILL HOLD THE ACCOUNTS

    public StartWindow() {

        // Displays the content
        setContentPane(mainPanel);

        // Clicking the "X" exit button closes the app
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Window setup
        setSize(750, 800);
        setResizable(false);
        setLocationRelativeTo(null); // Centers the window
        setTitle("AccountGuardUI - Start Window");
        Image titleBarIcon = new ImageIcon("assets/imgs/lock-logo.png").getImage();
        setIconImage(titleBarIcon);

        // Setting an image to the startWindow_MainHeadingImgLabel
        ImageIcon lockLogo = new ImageIcon("assets/imgs/lock-logo.png");
        startWindow_MainHeadingImgLabel.setPreferredSize(new Dimension(30, 30));
        Image scaledLockLogoImage = lockLogo.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledLockLogoIcon = new ImageIcon(scaledLockLogoImage);
        startWindow_MainHeadingImgLabel.setIcon(scaledLockLogoIcon);

        // Making the label the first thing tabbed on
        startWindow_MainHeadingTextLabel.setFocusable(true);
        startWindow_MainHeadingTextLabel.requestFocus();

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
        Color exitBtnDefaultBgColor = startWindow_ExitBtn.getBackground();
        Color exitBtnHoverBgColor = new Color(82, 124, 0);

        Color nonExitBtnDefaultBgColor = startWindow_AddAccountBtn.getBackground();
        Color nonExitBtnHoverBgColor = new Color(121, 182, 0);

        // Exit btn
        startWindow_ExitBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                startWindow_ExitBtn.setBackground(exitBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                startWindow_ExitBtn.setBackground(exitBtnDefaultBgColor);
            }
        });
        startWindow_ExitBtn.addActionListener(new ActionListener() {
            /**
             * This is used to close the app
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add Account btn
        startWindow_AddAccountBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                startWindow_AddAccountBtn.setBackground(nonExitBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                startWindow_AddAccountBtn.setBackground(nonExitBtnDefaultBgColor);
            }
        });
        startWindow_AddAccountBtn.addActionListener(new ActionListener() {
            /**
             * This is used to route to another window
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Routing to Add Account Window.");

                AddAccountWindow window = new AddAccountWindow();
                window.setVisible(true);

                // This makes it so the window will stay where to window was last position
                window.setLocation(getLocation());

                // Making the label the first thing tabbed on
                window.addAccountWindow_MainHeadingTextLabel.setFocusable(true);
                window.addAccountWindow_MainHeadingTextLabel.requestFocus();

                // Removing the ability to tab to the label once the user tabs to the next thing (addAccountWindow_AccountTypeTE)
                window.addAccountWindow_AccountTypeTE.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        window.addAccountWindow_MainHeadingTextLabel.setFocusable(false);
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        window.addAccountWindow_MainHeadingTextLabel.setFocusable(false);
                    }
                });

                setVisible(false);
            }
        });
        startWindow_AddAccountBtn.addFocusListener(new FocusListener() {
            /**
             * Removing the ability to tab to the label once the user tabs to the next thing (addAccount btn)
             * @param e the event to be processed
             */
            @Override
            public void focusGained(FocusEvent e) {
                startWindow_MainHeadingTextLabel.setFocusable(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                startWindow_MainHeadingTextLabel.setFocusable(false);
            }
        });
        // Remove Account btn
        startWindow_RemoveAccountBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                startWindow_RemoveAccountBtn.setBackground(nonExitBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                startWindow_RemoveAccountBtn.setBackground(nonExitBtnDefaultBgColor);
            }
        });
        startWindow_RemoveAccountBtn.addActionListener(new ActionListener() {
            /**
             * This is used to route to another window
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Routing to Remove Account Window.");

                RemoveAccountWindow window = new RemoveAccountWindow();
                window.setVisible(true);

                // Making the label the first thing tabbed on
                window.removeAccountWindow_MainHeadingTextLabel.setFocusable(true);
                window.removeAccountWindow_MainHeadingTextLabel.requestFocus();

                // Removing the ability to tab to the label once the user tabs to the next thing (addAccountWindow_AccountTypeTE)
                window.removeAccountWindow_MainHeadingTextLabel.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        window.removeAccountWindow_MainHeadingTextLabel.setFocusable(false);
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        window.removeAccountWindow_MainHeadingTextLabel.setFocusable(false);
                    }
                });

                // This makes it so the window will stay where to window was last position
                window.setLocation(getLocation());

                setVisible(false);
            }
        });

        // View Accounts btn
        startWindow_ViewAccountsBtn.addMouseListener(new MouseAdapter() {
            /**
             * This changes cursor when hovering/unhovering
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                startWindow_ViewAccountsBtn.setBackground(nonExitBtnHoverBgColor);
            }
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
                startWindow_ViewAccountsBtn.setBackground(nonExitBtnDefaultBgColor);
            }
        });
        startWindow_ViewAccountsBtn.addActionListener(new ActionListener() {
            /**
             * This is used to route to another window
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Routing to View Accounts Window.");

                // Adding accounts to the lists



                ViewAccountsWindow window = new ViewAccountsWindow();
                window.setVisible(true);

                DefaultListModel<String> typeModel = new DefaultListModel<>();
                DefaultListModel<String> emailModel = new DefaultListModel<>();
                DefaultListModel<String> passwordModel = new DefaultListModel<>();

                for (Account obj : storedAccounts) {
                    typeModel.addElement(obj.getType());
                    emailModel.addElement(obj.getEmail());
                    passwordModel.addElement(obj.getPassword());
                }

                window.viewAccountsWindow_AccountTypeList.setModel(typeModel);
                window.viewAccountsWindow_AccountEmailList.setModel(emailModel);
                window.viewAccountsWindow_AccountPasswordList.setModel(passwordModel);

//                for (Account obj : storedAccounts) {
//
//                    window.viewAccountsWindow_AccountTypeList.add(obj.getType());
//
//                }

                // Making the label the first thing tabbed on
                window.viewAccountsWindow_MainHeadingTextLabel.setFocusable(true);
                window.viewAccountsWindow_MainHeadingTextLabel.requestFocus();

                // Removing the ability to tab to the label once the user tabs to the next thing (addAccountWindow_AccountTypeTE)
                window.viewAccountsWindow_MainHeadingTextLabel.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        window.viewAccountsWindow_MainHeadingTextLabel.setFocusable(false);
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        window.viewAccountsWindow_MainHeadingTextLabel.setFocusable(false);
                    }
                });

                // This makes it so the window will stay where to window was last position
                window.setLocation(getLocation());

                setVisible(false);
            }
        });




    }


    public static void main(String[] args) {
        /**
         * This is where the magic happens
         */

        // Variables
        StartWindow window = new StartWindow();

        // Showing the app
        window.setVisible(true);

    }

}



