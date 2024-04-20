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

            }
        });

        contactsView.addLogoutButtonListener(new ActionListener()
        {
            // code for logoutButton button press
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        contactsView.addContactListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                
            }
        });
    }
}
