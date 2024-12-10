package model.dao;

import model.entity.User;

public class UserDao {
    public boolean checkUser(User user) {
        if (user != null) {
            return "admin".equals(user.getUsername()) && "admin".equals(user.getPassword());
        }
        return false;
    }
}
