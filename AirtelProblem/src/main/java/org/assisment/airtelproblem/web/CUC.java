package org.assisment.airtelproblem.web;

import org.assisment.airtelproblem.domain.CorporativeUser;
import org.assisment.airtelproblem.domain.User;
import org.assisment.airtelproblem.service.CorporateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CUC {
    @Autowired
    CorporateUserService corporateUserService;

    @RequestMapping("corporateuser")
    String getCorporateUserPage() {
        return "corporateuserselect";
    }

    @RequestMapping("/signup-corporate")
    public String getCorporateSignupPage(Model corporateUserModel) {
        User user = corporateUserService.getUserService();
        corporateUserModel.addAttribute("corporate", user);
        return "corporateuserform";
    }

    @RequestMapping("/corporateregister")
    public String getcorporateUserSelect(@ModelAttribute("user") CorporativeUser corporateUser) {
        if (corporateUserService.registeruser(corporateUser.getName(), corporateUser.getPlan(), corporateUser.getNumber())) {
            return "corporateuserplan";
        }
        return "corporateuserform";
    }
}
