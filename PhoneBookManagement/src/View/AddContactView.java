package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import Modules.*;

public class AddContactView extends JFrame
{
    // components
    JButton cancelButton, addButton;
    JLabel firstNameLabel, lastNameLabel, phoneNumberLabel;
    JTextField firstNameField, lastNameField, phoneNumberField;
    JPanel buttonPanel, labelPanel, contentPanel;

    // instance data
    User user;

    // constructor
    public AddContactView(User user)
    {
        // initialize the user
        this.user = user;

        // set up the JFrame
        setTitle("Add Contact");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize JButtons
        cancelButton = new JButton("Go Back");
        addButton = new JButton("Add Contact");
        Color c1 = Color.blue;
        Color c2 = new Color(111, 0, 255);
        cancelButton.setForeground(Color.white);
        addButton.setForeground(Color.white);
        cancelButton.setBackground(c1);
        addButton.setBackground(c2);
        cancelButton.setOpaque(true);
        addButton.setOpaque(true);
        cancelButton.setBorderPainted(false);
        addButton.setBorderPainted(false);

        // initialize JLabels
        firstNameLabel = new JLabel("   First Name ");
        lastNameLabel = new JLabel("   Last Name ");
        phoneNumberLabel = new JLabel("   Phone Number ");

        // initialize JTextFields
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        phoneNumberField = new JTextField();

        // initialize buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(cancelButton);
        buttonPanel.add(addButton);

        // initialize labelPanel
        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 2));
        labelPanel.add(firstNameField);
        labelPanel.add(firstNameLabel);
        labelPanel.add(lastNameField);
        labelPanel.add(lastNameLabel);
        labelPanel.add(phoneNumberField);
        labelPanel.add(phoneNumberLabel);

        // initialize contentPanel
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1));
        contentPanel.add(labelPanel);
        contentPanel.add(buttonPanel);

        // add content to JFrame and center it
        this.add(contentPanel);
        this.setLocationRelativeTo(null);
    }

    // methods for adding action listeners to buttons
    public void addCancelButtonListener(ActionListener listener)
    { cancelButton.addActionListener(listener); }
    public void addAddButtonListener(ActionListener listener)
    { addButton.addActionListener(listener); }

    // accessors and mutators
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getFirstName() { return firstNameField.getText(); }
    public String getLastName() { return lastNameField.getText(); }
    public String getPhoneNumber() { return phoneNumberField.getText(); }
}
