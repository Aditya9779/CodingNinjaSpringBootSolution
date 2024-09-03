package org.assisment.airtelproblem.web;

import org.assisment.airtelproblem.domain.NormalPlain;
import org.assisment.airtelproblem.domain.Plan;
import org.assisment.airtelproblem.service.NormalPlainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NPC {
    @Autowired
    NormalPlainService normal;

    @RequestMapping("/done")
    public String getNormalUserPage(Model normalplanModel) {
        Plan plan = normal.getNewNormalPlan();
        normalplanModel.addAttribute("normalplan", plan);
        return "normaluserplandetails";
    }

    @RequestMapping("/registernormalplan")
    public String getNormalUserDonePage(@ModelAttribute("donenormaluser") NormalPlain normalPlan) {
        if (normal.registerPlan(normalPlan.getData(), normalPlan.getDuration(), normalPlan.getSpeed(), normalPlan.getCalls())) {
            return "success";
        }
        return "normaluserplandetails";
    }
}
