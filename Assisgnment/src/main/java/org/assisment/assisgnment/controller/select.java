package org.assisment.assisgnment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class select {
    @RequestMapping(value = "/select")

    public String getSelectPage(@RequestParam String id, @RequestParam String name, ModelMap model) {
        model.addAttribute("message", "welcome " + name + ", Your ID is " + id);
        return "select";
    }
}
