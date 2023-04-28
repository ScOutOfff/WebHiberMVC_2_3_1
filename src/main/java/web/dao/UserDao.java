package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    void add(User user);

    User getUserById(int id);

    void editUser(int id, User user);

    void delete(int id);
}
