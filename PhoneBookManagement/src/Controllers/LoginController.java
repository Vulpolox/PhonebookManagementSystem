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
        loginView.addLoginButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                RegisterView rv = new RegisterView();
                rv.setVisible(true);
                loginView.setVisible(false);
            }
        });
    }
}
