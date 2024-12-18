import controller.LoginController;
import view.LoginView;

import java.awt.*;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView loginView = new LoginView();
                LoginController loginController = new LoginController(loginView);
                loginController.showLoginView();
            }
        });
    }
}
