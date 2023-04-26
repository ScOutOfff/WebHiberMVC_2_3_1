package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Dao.UserDao;
import web.models.User;

@Controller
public class UsersController {

    private final UserDao userService;

    @Autowired
    public UsersController(UserDao userService) {
        this.userService = userService;
    }

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

//    @GetMapping("users/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "show";
//    }

    @RequestMapping(value = "/users", produces = "application/war", method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:users";
    }

    //Need to realize
    @DeleteMapping(value = "/{id}")
//    @RequestMapping(value = "/{id}", produces = "application/war", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "users/{id}/update", produces = "application/war", method = {RequestMethod.GET, RequestMethod.POST})
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @RequestMapping(value = "users/{id}", produces = "application/war", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.editUser(id, user);
        return "redirect:/users";
    }
}
