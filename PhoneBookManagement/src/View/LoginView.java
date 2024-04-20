package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private final JButton loginButton, registerButton;

    public LoginView()
    {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize the components
        usernameField = new JTextField(10); // <-- parameter refers to max field size
        passwordField = new JPasswordField(10);

        // create JPanel with grid layout to hold components

            // add text fields and labels
            JPanel panel = new JPanel(new GridLayout(4, 2));
            panel.add(new JLabel("  Username: "));
            panel.add(usernameField);
            panel.add(new JLabel("  Password: "));
            panel.add(passwordField);

            // add buttons to panel
            registerButton = new JButton("Register");
            loginButton = new JButton("Login");

            // colorize the buttons
            Color c1 = Color.blue;
            Color c2 = new Color(111, 0, 255);

            loginButton.setForeground(Color.white);
            loginButton.setBackground(c1);
            registerButton.setForeground(Color.white);
            registerButton.setBackground(c2);

            registerButton.setOpaque(true);
            loginButton.setOpaque(true);

            loginButton.setBorderPainted(false);
            registerButton.setBorderPainted(false);

            panel.add(registerButton);
            panel.add(loginButton);

            // add panel
            add(panel);
            setLocationRelativeTo(null);
    }

    // action listeners for the buttons
    public void addLoginButtonListener(ActionListener actionListener)
    {
        loginButton.addActionListener(actionListener);
    }
    public void addRegisterButtonListener(ActionListener actionListener) { registerButton.addActionListener(actionListener); }


    // getters for the text fields
    public String getUsername() { return this.usernameField.getText(); }
    public String getPassword() { return this.passwordField.getText(); }


}
