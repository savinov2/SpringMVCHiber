package ru.savinov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.savinov.models.User;
import ru.savinov.service.UserService;
import ru.savinov.service.UserServiceImpl;

@Controller
public class ControllerUser {
    private final UserService userService;
    @Autowired
    public ControllerUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "user/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "user/show";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user",new User());
        return "user/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "user/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.update(user,id);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/";
    }
}
