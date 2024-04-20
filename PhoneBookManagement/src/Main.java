import Controllers.LoginController;
import View.*;

public class Main
{
    public static void main(String[] args)
    {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
    }
}
