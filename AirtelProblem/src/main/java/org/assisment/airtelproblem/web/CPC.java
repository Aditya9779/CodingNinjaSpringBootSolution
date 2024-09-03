package org.assisment.airtelproblem.web;

import org.assisment.airtelproblem.domain.CorporativePlan;
import org.assisment.airtelproblem.domain.Plan;
import org.assisment.airtelproblem.service.CorporatePlainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CPC {

    @Autowired
    CorporatePlainService corporatePlainService;

    @RequestMapping("/corporateplans")
    public String getCorporatePlanDetails(Model corporateplanModel) {
        Plan plan = corporatePlainService.getNewNormalPlan();
        corporateplanModel.addAttribute("corporateplan", plan);
        return "corporateuserplandetails";
    }

    @RequestMapping("/registercorporateplan")
    public String getCorporateUserDonePage(@ModelAttribute("donecorporateuser") CorporativePlan corporatePlan) {
        if (corporatePlainService.registerPlan(corporatePlan.getData(), corporatePlan.getDuration(), corporatePlan.getSpeed(), corporatePlan.getCalls())) {
            return "success";
        }
        return "corporateuserplandetails";
    }

}
