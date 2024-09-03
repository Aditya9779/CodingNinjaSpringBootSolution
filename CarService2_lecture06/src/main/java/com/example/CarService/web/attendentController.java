package com.example.CarService.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class attendentController {
    @GetMapping("/attendent/{attendentId}")
    public String getAttendent(@PathVariable(value = "attendentId") String attendentId, ModelMap model){
        model.addAttribute("name", "TEST 123");
        model.addAttribute("work","Engine,BodyShop");
        return "attendent";
    }
}
