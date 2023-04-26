package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Dao.UserDao;
import web.Service.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserDao userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user");
        return "new";
    }
}
