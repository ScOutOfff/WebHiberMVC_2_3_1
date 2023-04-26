package web.Dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    void add(User user);
}
