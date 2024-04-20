package Controllers;

import View.*;
import Modules.*;
import MyUtils.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactsController
{
    // instance data
    private ContactsView contactsView;

    // constructor
    public ContactsController(ContactsView cv)
    {
        this.contactsView = cv;

        contactsView.addAddContactButtonListener(new ActionListener()
        {
            // code for addContactButton button press
            public void actionPerformed(ActionEvent e)
            {
                contactsView.setVisible(false);

                AddContactView acv = new AddContactView(contactsView.getUser());
                AddContactController addContactController = new AddContactController(acv);
                acv.setVisible(true);
            }
        });

        contactsView.addCreateCSVButtonListener(new ActionListener()
        {
            // code for createCSVButton button press
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        contactsView.addEditButtonListener(new ActionListener()
        {
            // code for editContactButton button press
            public void actionPerformed(ActionEvent e)
            {
                if (contactsView.getSelectedContact() == null)
                    JOptionPane.showMessageDialog(null, "Please select contact to edit");
                else
                {
                    Contact contactToEdit = contactsView.getSelectedContact();

                    contactsView.setVisible(false);
                    EditContactView ecv = new EditContactView(contactsView.getUser(), contactToEdit);
                    EditContactController editContactController = new EditContactController(ecv);
                    ecv.setVisible(true);
                }
            }
        });

        contactsView.addLogoutButtonListener(new ActionListener()
        {
            // code for logoutButton button press
            public void actionPerformed(ActionEvent e)
            {
                // set the contactsView to be invisible
                contactsView.setVisible(false);

                JOptionPane.showMessageDialog(null, "Logged out");

                // re-enable the login view
                LoginView lv = new LoginView();
                LoginController loginController = new LoginController(lv);
                lv.setVisible(true);
            }
        });

        contactsView.addContactListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                if (!e.getValueIsAdjusting())
                {
                    contactsView.setSelectedContact(contactsView.getSelectedContact());
                }
            }
        });
    }
}
