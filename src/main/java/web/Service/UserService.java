package web.Service;

import web.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getUserById(int id);
    List<User> getUserList();
}
