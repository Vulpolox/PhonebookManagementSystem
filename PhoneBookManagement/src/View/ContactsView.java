package View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

import Modules.*;
import MyUtils.Utilities;

public class ContactsView extends JFrame
{
    // components for ContactsView
    private JButton editContactButton, addContactButton, createCSVButton, logoutButton, searchButton;
    private JTextField searchField;
    private JList<Contact> contactsList;
    private JPanel buttonPanel, contentPanel, searchPanel;

    // instance data
    private Contact selectedContact = null;
    private User user = null;
    private Contact[] underlyingData;


    // constructor
    public ContactsView(User user)
    {
        // initialize the user
        this.user = user;

        // JFrame setup
        setTitle("Contacts");
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize underLyingData
        UserDataAccess uda = new UserDataAccess();
        this.underlyingData = uda.getContacts(user);
        Arrays.sort(this.underlyingData, new ContactComparator());

        // initialize JList
        DefaultListModel<Contact> model = new DefaultListModel<>();
        this.contactsList = new JList<>(model);
        this.contactsList.setFont(new Font("Courier New", Font.PLAIN, 12)); // from Gemini
        Utilities.populateContactList(model, this.underlyingData);

        // --- old code using AbstractListModel; search is harder to implement with it
            // UserDataAccess uda = new UserDataAccess();
            // Contact[] contacts = uda.getContacts(user);
            // this.contactsList = new JList<>(contacts);

        this.contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // initialize JButtons
        editContactButton = new JButton("Edit Contact");
        addContactButton = new JButton("Add Contact");
        createCSVButton = new JButton("Export to CSV");
        logoutButton = new JButton("Logout");
        searchButton = new JButton("Search");
        Color c1 = Color.blue;
        Color c2 = new Color(111, 0, 255);
        Color c3 = new Color(137, 72, 222, 255);
        Color c4 = new Color(194, 39, 204, 255);
        Color c5 = new Color(50, 21, 82,255);
        editContactButton.setForeground(Color.white);
        addContactButton.setForeground(Color.white);
        createCSVButton.setForeground(Color.white);
        logoutButton.setForeground(Color.white);
        searchButton.setForeground(Color.white);
        editContactButton.setBackground(c1);
        addContactButton.setBackground(c2);
        createCSVButton.setBackground(c3);
        logoutButton.setBackground(c4);
        searchButton.setBackground(c5);
        editContactButton.setOpaque(true);
        addContactButton.setOpaque(true);
        createCSVButton.setOpaque(true);
        logoutButton.setOpaque(true);
        searchButton.setOpaque(true);
        editContactButton.setBorderPainted(false);
        addContactButton.setBorderPainted(false);
        createCSVButton.setBorderPainted(false);
        logoutButton.setBorderPainted(false);
        searchButton.setBorderPainted(false);

        // initialize JTextFields
        searchField = new JTextField();
        searchField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        // initialize buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(editContactButton);
        buttonPanel.add(addContactButton);
        buttonPanel.add(createCSVButton);
        buttonPanel.add(logoutButton);

        // initialize searchPanel
        searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // initialize contentPanel
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1));
        contentPanel.add(new JScrollPane(contactsList));
        contentPanel.add(searchPanel);
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
    public void addSearchButtonListener(ActionListener listener)
    { searchButton.addActionListener(listener); }

    // method for adding ActionListener to JList
    public void addContactListSelectionListener(ListSelectionListener listener)
    { contactsList.addListSelectionListener(listener); }

    // accessors and mutators
    public Contact getSelectedContact() { return contactsList.getSelectedValue(); }
    public void setSelectedContact(Contact selectedContact) { this.selectedContact = selectedContact; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getSearchFilter() { return this.searchField.getText(); }
    public Contact[] getUnderlyingData() { return this.underlyingData; }
    public DefaultListModel getContactListModel() { return (DefaultListModel) this.contactsList.getModel(); }
}
