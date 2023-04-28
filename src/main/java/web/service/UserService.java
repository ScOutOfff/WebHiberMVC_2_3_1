package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getUserById(int id);
    List<User> getUserList();
    void delete(int id);
    void editUser(int id, User user);
}
