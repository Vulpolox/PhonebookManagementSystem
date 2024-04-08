package View;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame
{
    // controls or components as needed
    private JTextField usernameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, cancelButton;

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
        cancelButton = new JButton("Cancel");

        // create a panel and add components
            JPanel panel = new JPanel(new GridLayout(5, 2));

            // add labels and fields
            panel.add(new JLabel("Username: "));
            panel.add(usernameField);
            panel.add(new JLabel("Password: "));
            panel.add(passwordField);
            panel.add(new JLabel("Confirm Password: "));
            panel.add(confirmPasswordField);

            // add buttons
            panel.add(registerButton);
            panel.add(cancelButton);

        // add panel to the frame and set its visibility
        add(panel);
        setVisible(true);
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
