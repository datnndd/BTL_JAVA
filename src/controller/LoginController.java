package controller;

import model.dao.UserDao;
import model.entity.User;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private final LoginView loginView;
    private final UserDao userDao;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.userDao = new UserDao();
        loginView.addLoginButtonListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                loginView.showMessage("username or password correct");
            }
            else {
                loginView.showMessage("username or password incorrect");
            }
        }
    }
}
