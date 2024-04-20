package Controllers;

import Modules.Contact;
import Modules.UserDataAccess;
import View.ContactsView;
import View.EditContactView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditContactController
{
    private EditContactView editContactView;

    public EditContactController(EditContactView ecv)
    {
        this.editContactView = ecv;

        editContactView.addCancelButtonListener(new ActionListener()
        {
            // code for cancelButton press
            public void actionPerformed(ActionEvent e)
            {
                // set the addContactView to be invisible
                editContactView.setVisible(false);

                // re-enable the contacts view
                ContactsView cv = new ContactsView(editContactView.getUser());
                ContactsController contactController = new ContactsController(cv);
                cv.setVisible(true);
            }
        });

        editContactView.addRemoveButtonListener(new ActionListener()
        {
            // code for remove button press
            public void actionPerformed(ActionEvent e)
            {
                UserDataAccess uda = new UserDataAccess();
                boolean success = uda.removeContact(editContactView.getUser(), editContactView.getContactToEdit());

                // give the user feedback whether the contact was successfully removed
                if (success)
                    JOptionPane.showMessageDialog(null, "Contact removed from phonebook");
                else
                    JOptionPane.showMessageDialog(null, "Failed to remove contact");

                // set the addContactView to be invisible
                editContactView.setVisible(false);

                // re-enable the contacts view
                ContactsView cv = new ContactsView(editContactView.getUser());
                ContactsController contactController = new ContactsController(cv);
                cv.setVisible(true);
            }
        });

        editContactView.addEditButtonListener(new ActionListener()
        {
            // code for edit button press
            public void actionPerformed(ActionEvent e)
            {
                // initialize new contact
                Contact newContact = new Contact(editContactView.getNewFirstName(),
                                                 editContactView.getNewLastName(),
                                                 editContactView.getNewPhoneNumber());

                // remove the old contact and add the new contact
                UserDataAccess uda = new UserDataAccess();
                uda.removeContact(editContactView.getUser(), editContactView.getContactToEdit());
                boolean success = uda.addContact(editContactView.getUser(), newContact);

                // give the user feedback whether they successfully updated the contact
                if (success)
                    JOptionPane.showMessageDialog(null, "Updated contact");
                else
                    JOptionPane.showMessageDialog(null, "Failed to update contact");
            }
        });
    }
}
