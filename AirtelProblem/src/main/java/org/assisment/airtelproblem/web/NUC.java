package org.assisment.airtelproblem.web;

import org.assisment.airtelproblem.domain.NormalUser;
import org.assisment.airtelproblem.domain.User;
import org.assisment.airtelproblem.service.NormalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NUC {
    @Autowired
    NormalUserService userService;

    @RequestMapping("normaluser")
    String getNormalUserPage() {
        return "normaluserselect";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)

    public String getSignupPage(Model normalUserModel) {
        User user = userService.getUserService();
        normalUserModel.addAttribute("user", user);
        return "normaluserform";
    }

    @RequestMapping("/register")
    public String getnormalUserSelect(@ModelAttribute("user") NormalUser normalUser) {
        if (userService.registeruser(normalUser.getName(), normalUser.getPlan(), normalUser.getNumber())) {
            return "normaluserplan";
        }
        return "normaluserselect";
    }

}
