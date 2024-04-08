package Controllers;

import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController
{
    private LoginView loginView;
    public LoginController(LoginView loginView)
    {
        this.loginView = loginView;
        loginView.addRegisterButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // create a RegisterView instance and bind it to controller and set visible
                RegisterView rv = new RegisterView();
                RegisterController registerController = new RegisterController(rv);
                rv.setVisible(true);

                // disable the LoginView instance
                loginView.setVisible(false);
            }


        });

        loginView.addLoginButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }
}
