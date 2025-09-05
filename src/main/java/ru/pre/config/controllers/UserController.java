package ru.pre.config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pre.config.services.UserServ;
import ru.pre.model.User;

@Controller
public class UserController {
    UserServ userServ;

    @Autowired
    public UserController(UserServ userServ) {
        this.userServ = userServ;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userServ.getAllUser());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model, @ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        userServ.addNewUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id") int id) {
        userServ.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("user", userServ.getUserById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("id") int id) {
        userServ.update(id, user);
        return "redirect:/";
    }
}
