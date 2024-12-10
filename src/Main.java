import view.LoginView;
import controller.LoginController;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                LoginView loginView = new LoginView();
                LoginController loginController = new LoginController(loginView);
                loginController.showLoginView();
            }
        });
    }
}