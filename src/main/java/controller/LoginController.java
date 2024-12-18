package controller;

import dao.UserDao;
import entity.User;
import view.GymManagerView;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private GymManagerView gymManagerView;

    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                gymManagerView = new GymManagerView();
                GymManagerController studentController = new GymManagerController(gymManagerView);
                studentController.showMemberView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username or password incorrect");
            }
        }
    }
}
