package org.assisment.assisgnment.controller;

import org.assisment.assisgnment.domain.ImdbUser;
import org.assisment.assisgnment.domain.User;
import org.assisment.assisgnment.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUp {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping("/signup")
    public String signup(Model model) {
        User user = serviceLayer.getUser();
        model.addAttribute("user", user);
        return "signup";
    }

    @RequestMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") ImdbUser user) {
//        ImdbUser user = (ImdbUser) comingUser; //type cast to use the imbduser
        int userId = serviceLayer.RegisterUser(user.getUserName(), user.getPassword(), user.getEmail());
        if (userId != -1) {
            ModelAndView modelMap = new ModelAndView("redirect:success?id=" + userId + "&name=" + user.getUserName());
            return modelMap.getViewName();
        } else {
            return "signup";
        }
    }

    @RequestMapping("/success")
    public String success(@RequestParam String id, @RequestParam String name) {
        return "success";
    }

}
