package com.example.website.web;

import com.example.website.service.UserSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SupportController {
    @Autowired
    UserSupport userSupport;

    /*Model method its a interface*/
 /*   @RequestMapping("/support")
    public String getSupport(@RequestParam("id") String id, Model model) {
        String finalMessage = userSupport.createUser(Integer.parseInt(id));
        model.addAttribute("message", finalMessage);
        return "support";
    }*/
    /*ModelMap is the Class its more better than model its like a hashmap*/
    @RequestMapping("/support")
    public String getSupport(@RequestParam("id") String id, ModelMap map) {
//        String finalMessage = userSupport.getUSerName(Integer.parseInt(id));
//        map.addAttribute("message", "Welcome to ModelMap message " + id);
        Optional<String> finalMessage = userSupport.getUSerName(Integer.parseInt(id));
        if (finalMessage.isPresent()) {
            // If the ID exists
            map.addAttribute("message", "Welcome " + finalMessage.get() + " (ID: " + id + ")");
        } else {
            // If the ID does not exist
            map.addAttribute("message", "User ID " + id + " does not exist.");
        }

        return "support";
    }
}
