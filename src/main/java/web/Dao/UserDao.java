package web.Dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    void add(User user);

    User getUserById(int id);

    void editUser(int id, User user);
}
