package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

//    @GetMapping("admin")
//    public String mainList(Model model) {
//        List<User> list = userService.getUsers();
//        model.addAttribute("listUser", list);
//        return "all_users";
//    }

//    @PostMapping("createUser")
//    public String createUser(@ModelAttribute User user) {
////        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
////        String hashedPassword = user.getPassword();
////        if (hashedPassword.length() < 20) {
////            hashedPassword = crypt.encode(hashedPassword);
////        }
//        user.setPassword(encode(user.getPassword()));
//        userService.createUser(user);
//        return "redirect:/admin";
//    }

//    @GetMapping("info_user")
//    public String infoUser(Model model) {
//        User user = new User();
//        model.addAttribute("info_user", user);
//        return "save_user";
//    }

//    @GetMapping("updateUser/{id}")
//    public String update(@PathVariable("id") Long id, Model model) {
//        User user = userService.findUserById(id);
//        model.addAttribute("user", user);
//        return "soloUpdate";
//    }

//    @PostMapping("admin/saveUpdatedUser")
//    public String updateUser(@ModelAttribute User user) {
////        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
////        int i = 0;
////        String hashedPassword = null;
////        while (i < 13) {
////            hashedPassword = crypt.encode(user.getPassword());
////            i++;
////        }
//        user.setPassword(encode(user.getPassword()));
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }
//    @RequestMapping("soloUser")
//    public String soloUser(@ModelAttribute User user) {
//        userService.createUser(user);
//        return "redirect:/user";
//    }

    @GetMapping("/inform")
    public String readUser(Model model) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userService.loadUserByUsername(user.getUsername()));
        return "user";
    }

//    @GetMapping("anigilation_user_in_hell/{id}")
//    public String anigilation(@PathVariable("id") Long id) {
//        userService.delete(id);
//        return "redirect:/admin";
//    }

    @GetMapping(value = "danger")
    public String dangerUser() {
        return "index";
    }

//    private String encode(String hash) {
//        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
//        if (hash.length() < 66) {
//            hash = crypt.encode(hash);
//        }
//        return hash;
//    }
}
