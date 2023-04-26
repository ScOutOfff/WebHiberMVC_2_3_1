package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Dao.UserDao;
import web.models.User;

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
        model.addAttribute("user", new User());
        return "new";
    }

    @RequestMapping(value = "/users",produces = "application/war",method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:users";
    }

    //Need to realize
    @GetMapping("/delete")
    public String deleteUser(Model model) {
        return "redirect:users";
    }
}
