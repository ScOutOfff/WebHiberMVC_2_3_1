package web.Service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    void add(User user);
    void editUser(int id, User user);
    User getUserById(int id);
    void delete(int id);
}
