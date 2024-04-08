package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame
{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

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
            panel.add(new JLabel("Username: "));
            panel.add(usernameField);
            panel.add(new JLabel("Password: "));
            panel.add(passwordField);

            // add buttons to panel
            registerButton = new JButton("Register");
            loginButton = new JButton("Login");
            panel.add(registerButton);
            panel.add(loginButton);

            // add panel
            add(panel);
            setVisible(true);
    }

    public void addLoginButtonListener(ActionListener actionListener)
    {
        loginButton.addActionListener(actionListener);
    }

    public void addRegisterButtonListener(ActionListener actionListener)
    {
        registerButton.addActionListener(actionListener);
    }
}
