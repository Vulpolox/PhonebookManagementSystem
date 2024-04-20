package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import Modules.*;

public class EditContactView extends JFrame
{
    // components
    JButton cancelButton, editButton, removeButton;
    JLabel firstNameLabel, lastNameLabel, phoneNumberLabel;
    JTextField firstNameField, lastNameField, phoneNumberField;
    JPanel buttonPanel, labelPanel, contentPanel;

    // instance data
    User user;
    Contact contactToEdit;

    // constructor
    public EditContactView(User user, Contact contactToEdit)
    {
        // initialize instance data
        this.user = user;
        this.contactToEdit = contactToEdit;

        // set up the JFrame
        setTitle("Edit Contact");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize JButtons
        cancelButton = new JButton("Go Back");
        editButton = new JButton("Update Contact");
        removeButton = new JButton("Remove Contact");
        Color c1 = Color.blue;
        Color c2 = new Color(111, 0, 255);
        Color c3 = new Color(194, 39, 204, 255);
        cancelButton.setForeground(Color.white);
        editButton.setForeground(Color.white);
        removeButton.setForeground(Color.white);
        cancelButton.setBackground(c1);
        editButton.setBackground(c2);
        removeButton.setBackground(c3);
        cancelButton.setOpaque(true);
        editButton.setOpaque(true);
        removeButton.setOpaque(true);
        cancelButton.setBorderPainted(false);
        editButton.setBorderPainted(false);
        removeButton.setBorderPainted(false);

        // initialize JLabels
        firstNameLabel = new JLabel("   First Name ");
        lastNameLabel = new JLabel("   Last Name ");
        phoneNumberLabel = new JLabel("   Phone Number ");

        // initialize JTextFields
        firstNameField = new JTextField(contactToEdit.getFirstname());
        lastNameField = new JTextField(contactToEdit.getLastname());
        phoneNumberField = new JTextField(contactToEdit.getPhoneNumber());

        // initialize buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(cancelButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);

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
    public void addEditButtonListener(ActionListener listener)
    { editButton.addActionListener(listener); }
    public void addRemoveButtonListener(ActionListener listener)
    { removeButton.addActionListener(listener); }

    // accessors and mutators
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Contact getContactToEdit() { return contactToEdit; }
    public void setContactToEdit(Contact contactToEdit) { this.contactToEdit = contactToEdit; }
    public String getNewFirstName() { return firstNameField.getText(); }
    public String getNewLastName() { return lastNameField.getText(); }
    public String getNewPhoneNumber() { return phoneNumberField.getText(); }
}
