package Controllers;

import View.*;
import Modules.*;
import MyUtils.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController
{
    private RegisterView registerView;
    public RegisterController(RegisterView rv)
    {
        this.registerView = rv;

        registerView.addRegisterButtonListener(new ActionListener()
        {
            // code for the register button click event
            public void actionPerformed(ActionEvent e)
            {
                User user = new User();                       // User object to hold user information
                boolean registeredSuccessfully = false;       // flag for registering successfully
                user.setUsername(registerView.getUsername()); // set the username field
                user.setPassword(registerView.getPassword()); // set the password field

                UserDataAccess uda = new UserDataAccess();    // UserDataAccess object for interface with db

                // if the user left fields blank
                if (registerView.getPassword().isEmpty() ||
                    registerView.getConfirmPassword().isEmpty() ||
                    registerView.getUsername().isEmpty())
                    JOptionPane.showMessageDialog(null, "One or more of the fields are empty.");

                // if the passwords do not match, tell the user
                else if (!Utilities.isPasswordMatching(registerView.getPassword(),
                                                       registerView.getConfirmPassword()))
                    JOptionPane.showMessageDialog(null, "Passwords do not match");

                // if everything is correct, register the user into the database
                else if (uda.isUniqueUsername(user))
                {
                    registeredSuccessfully = uda.registerUser(user);

                    if (registeredSuccessfully)
                        JOptionPane.showMessageDialog(null,"Registered successfully");
                    else
                        JOptionPane.showMessageDialog(null,"Registration failed");
                }

                // if the username is not unique, prompt the user to enter a new one
                else
                    JOptionPane.showMessageDialog(null, "Username already exists within system.  Please choose another one");



            }
        });

        registerView.addCancelButtonListener(new ActionListener()
        {
            // code for the cancel button click event
            public void actionPerformed(ActionEvent e)
            {
                // set the register view to be invisible
                registerView.setVisible(false);

                // re-enable the login view
                LoginView lv = new LoginView();
                LoginController loginController = new LoginController(lv);
                lv.setVisible(true);

            }
        });
    }
}
