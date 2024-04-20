package Controllers;

import View.*;
import Modules.*;
import MyUtils.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContactController
{
    // instance data
    private AddContactView addContactView;

    public AddContactController(AddContactView acv)
    {
        this.addContactView = acv;

        addContactView.addAddButtonListener(new ActionListener()
        {
            // code for addButton press
            public void actionPerformed(ActionEvent e)
            {
                // if one or more fields are empty, tell user
                if (addContactView.getFirstName().isEmpty() ||
                    addContactView.getLastName().isEmpty() ||
                    addContactView.getPhoneNumber().isEmpty())
                    JOptionPane.showMessageDialog(null, "One or more fields are empty");

                // if everything is valid, add the contact to the database
                else
                {
                    Contact contactToAdd = new Contact(addContactView.getFirstName(),
                                                       addContactView.getLastName(),
                                                       addContactView.getPhoneNumber());
                    UserDataAccess uda = new UserDataAccess();
                    boolean successful = uda.addContact(addContactView.getUser(), contactToAdd);

                    if (successful)
                        JOptionPane.showMessageDialog(null, "Successfully added contact");
                    else
                        JOptionPane.showMessageDialog(null, "Failed to add contact");
                }
            }
        });

        addContactView.addCancelButtonListener(new ActionListener()
        {
            // code for cancelButton press
            public void actionPerformed(ActionEvent e)
            {
                // set the addContactView to be invisible
                addContactView.setVisible(false);

                // re-enable the contacts view
                ContactsView cv = new ContactsView(addContactView.getUser());
                ContactsController contactController = new ContactsController(cv);
                cv.setVisible(true);
            }
        });
    }
}
