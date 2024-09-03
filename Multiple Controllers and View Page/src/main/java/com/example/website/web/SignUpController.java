package com.example.website.web;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
    @Autowired
    UserService userService;

    @RequestMapping("/signup")
    public String getSignUpPage(Model model) {
        User user = userService.getUser();
        model.addAttribute("user", user);
        return "signup";
    }

    @RequestMapping("/registerUser")
    public String createdUser(@ModelAttribute(value = "user") StudentUser studentUser) {
        boolean created = userService.signUp(studentUser.getName(), studentUser.getCollege(), studentUser.getLocation(), studentUser.getGender());
        if (created) {
            return "welcome";
        } else {
            return "signup";
        }
    }
}

