package View;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

import Modules.*;

public class ContactsView extends JFrame
{
    // components for ContactsView
    private JButton editContactButton, addContactButton, createCSVButton, logoutButton;
    private JList<Contact> contactsList;
    private JPanel buttonPanel, contentPanel;

    // instance data
    private Contact selectedContact = null;
    private User user = null;


    // constructor
    public ContactsView(User user)
    {
        // initialize the user
        this.user = user;

        // JFrame setup
        setTitle("Contacts");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize JList
        UserDataAccess uda = new UserDataAccess();
        Contact[] contacts = uda.getContacts(user);
        this.contactsList = new JList<>(contacts);
        this.contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // initialize JButtons
        editContactButton = new JButton("Edit Contact");
        addContactButton = new JButton("Add Contact");
        createCSVButton = new JButton("Export to CSV");
        logoutButton = new JButton("Logout");
        Color c1 = Color.blue;
        Color c2 = new Color(111, 0, 255);
        Color c3 = new Color(137, 72, 222, 255);
        Color c4 = new Color(194, 39, 204, 255);
        editContactButton.setForeground(Color.white);
        addContactButton.setForeground(Color.white);
        createCSVButton.setForeground(Color.white);
        logoutButton.setForeground(Color.white);
        editContactButton.setBackground(c1);
        addContactButton.setBackground(c2);
        createCSVButton.setBackground(c3);
        logoutButton.setBackground(c4);
        editContactButton.setOpaque(true);
        addContactButton.setOpaque(true);
        createCSVButton.setOpaque(true);
        logoutButton.setOpaque(true);
        editContactButton.setBorderPainted(false);
        addContactButton.setBorderPainted(false);
        createCSVButton.setBorderPainted(false);
        logoutButton.setBorderPainted(false);

        // initialize buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(editContactButton);
        buttonPanel.add(addContactButton);
        buttonPanel.add(createCSVButton);
        buttonPanel.add(logoutButton);

        // initialize contentPanel
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1));
        contentPanel.add(new JScrollPane(contactsList));
        contentPanel.add(buttonPanel);

        // add content to the JFrame and center it
        this.add(contentPanel);
        this.setLocationRelativeTo(null);
    }

    // methods for adding ActionListeners to JButtons
    public void addEditButtonListener(ActionListener listener)
    { editContactButton.addActionListener(listener); }
    public void addAddContactButtonListener(ActionListener listener)
    { addContactButton.addActionListener(listener); }
    public void addCreateCSVButtonListener(ActionListener listener)
    { createCSVButton.addActionListener(listener); }
    public void addLogoutButtonListener(ActionListener listener)
    { logoutButton.addActionListener(listener); }

    // method for adding ActionListener to JList
    public void addContactListSelectionListener(ListSelectionListener listener)
    { contactsList.addListSelectionListener(listener); }

    // accessors and mutators
    public Contact getSelectedContact() { return selectedContact; }
    public void setSelectedContact(Contact selectedContact) { this.selectedContact = selectedContact; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
