package Controllers;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modules.*;
import MyUtils.*;

import javax.swing.*;

public class LoginController
{
    private LoginView loginView;
    public LoginController(LoginView loginView)
    {
        this.loginView = loginView; // set the instance's LoginView to the one passed

        loginView.addRegisterButtonListener(new ActionListener()
        {
            // listener for the register button click event
            public void actionPerformed(ActionEvent e)
            {
                // create a RegisterView instance and bind it to controller and set visible
                RegisterView rv = new RegisterView();
                RegisterController registerController = new RegisterController(rv);
                rv.setLocationRelativeTo(null);
                rv.setVisible(true);

                // disable the LoginView instance
                loginView.setVisible(false);
            }
        });

        loginView.addLoginButtonListener(new ActionListener()
        {
            // listener function for the login button click event
            public void actionPerformed(ActionEvent e)
            {
                User user = new User(loginView.getUsername(), loginView.getPassword());
                UserDataAccess uda = new UserDataAccess();

                // if any of the fields are empty, tell the user
                if (loginView.getUsername().isEmpty() ||
                    loginView.getPassword().isEmpty())
                    JOptionPane.showMessageDialog(null, "One or more of the fields are empty");

                // if the username or password doesn't match any within the database
                else if (uda.isNotRegistered(user))
                    JOptionPane.showMessageDialog(null, "The username or password are incorrect");

                // if everything is correct
                else
                {
                    loginView.setVisible(false);

                    ContactsView cv = new ContactsView(user);
                    ContactsController contactsController = new ContactsController(cv);
                    cv.setVisible(true);
                }

            }
        });
    }
}
