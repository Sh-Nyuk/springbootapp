package com.bootapp.springbootapp.controller;

import com.bootapp.springbootapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootapp.springbootapp.service.UserService;


@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersPage(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users-page";
    }

    @GetMapping("/edit")
    public String editUsersPage(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users-edit";
    }

    @PostMapping("/edit")
    public String editUser(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("age") int age) {
        User user = new User(name, email, age);
        user.setId(id);
        userService.editUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("age") int age) {
        User user = new User(name, email, age);
        userService.addUser(user);
        return "redirect:/";
    }

}
