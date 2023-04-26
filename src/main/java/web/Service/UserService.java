package web.Service;

import web.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getUserList();
}
