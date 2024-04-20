package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame
{
    // controls or components as needed
    private final JTextField usernameField;
    private final JPasswordField passwordField, confirmPasswordField;
    private final JButton registerButton, cancelButton;

    public RegisterView()
    {
        setTitle("Register");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize components
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        confirmPasswordField = new JPasswordField(10);
        registerButton = new JButton("Register");
        cancelButton = new JButton("Go Back");

        // create a panel and add components
            JPanel panel = new JPanel(new GridLayout(5, 2));

            // add labels and fields
            panel.add(new JLabel("  Username: "));
            panel.add(usernameField);
            panel.add(new JLabel("  Password: "));
            panel.add(passwordField);
            panel.add(new JLabel("  Confirm Password: "));
            panel.add(confirmPasswordField);

            // colorize and add the buttons
            Color c1 = Color.blue;
            Color c2 = new Color(111, 0, 255);

            cancelButton.setForeground(Color.white);
            cancelButton.setBackground(c1);
            registerButton.setForeground(Color.white);
            registerButton.setBackground(c2);

            registerButton.setOpaque(true);
            cancelButton.setOpaque(true);

            cancelButton.setBorderPainted(false);
            registerButton.setBorderPainted(false);

            panel.add(registerButton);
            panel.add(cancelButton);

        // add panel to the frame and set its visibility
        add(panel);
        setLocationRelativeTo(null);
    }

    public void addCancelButtonListener(ActionListener listener)
    {
        cancelButton.addActionListener(listener);
    }

    public void addRegisterButtonListener(ActionListener listener)
    {
        registerButton.addActionListener(listener);
    }

    public String getUsername() { return this.usernameField.getText(); }
    public String getPassword() { return new String(this.passwordField.getText()); }

    public String getConfirmPassword()
    {
        return new String(confirmPasswordField.getText());
    }

}
