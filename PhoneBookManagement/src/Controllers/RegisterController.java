package Controllers;

import View.*;

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
                JOptionPane.showMessageDialog(null, "Registered Successfully");
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
