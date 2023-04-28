package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //List of All users________________________________________________________
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    //Adding a new User_________________________________________________________
    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/users")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:users";
    }

    //Deleting a User_________________________________________________________________
    @DeleteMapping(value = "users/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    //Editing a User_____________________________________________________________________
//    @RequestMapping(value = "users/{id}/update", produces = "application/war", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
    @GetMapping(value = "users/{id}/update")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping(value = "users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.editUser(id, user);
        return "redirect:/users";
    }
}
