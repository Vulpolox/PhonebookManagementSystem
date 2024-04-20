package Controllers;

import View.ContactsView;
import View.EditContactView;

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
            // code for cancelButton press
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        editContactView.addEditButtonListener(new ActionListener()
        {
            // code for cancelButton press
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }
}
