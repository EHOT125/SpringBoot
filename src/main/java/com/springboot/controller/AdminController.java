package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("admin/list")
    public String mainList(Model model) {
        List<User> list = userService.getUsers();
        model.addAttribute("listUser", list);
        return "all_users";
    }

    @PostMapping("admin/createUser")
    public String createUser(@ModelAttribute User user) {
        if (user.getPassword() != null && !user.getPassword().equals("")) {
            user.setPassword(encode(user.getPassword()));
        } else {
            user.setPassword(user.getPassword());
        }
        userService.createUser(user);
        return "redirect:/admin/list";
    }

    @GetMapping("admin/info_user")
    public String infoUser(Model model) {
        User user = new User();
        model.addAttribute("info_user", user);
        return "save_user";
    }

    @GetMapping("admin/updateUser/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "soloUpdate";
    }
    @PostMapping("admin/saveUpdatedUser")
    public String updateUser(@ModelAttribute User user) {
        user.setPassword(encode(user.getPassword()));
        userService.updateUser(user);
        return "redirect:/admin/list";
    }

    @GetMapping("admin/anigilation_user_in_hell/{id}")
    public String anigilation(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/list";
    }

    private String encode(String hash) {
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

        return crypt.encode(hash);
    }
}

