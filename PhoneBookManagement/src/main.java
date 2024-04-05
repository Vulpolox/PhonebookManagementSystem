import Controllers.LoginController;
import View.*;
import Controllers.*;


public class main
{
    public static void main(String[] args)
    {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
    }
}
