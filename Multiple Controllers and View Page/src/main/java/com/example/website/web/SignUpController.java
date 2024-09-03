package com.example.website.web;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

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

    /*Staic method*/
   /* @RequestMapping("/registerUser")
    public String createdUser(@ModelAttribute(value = "user") StudentUser studentUser) {
        boolean created = userService.signUp(studentUser.getName(), studentUser.getCollege(), studentUser.getLocation(), studentUser.getGender());
        if (created) {
            return "welcome";
        } else {
            return "signup";
        }
    }*/
    /*Dynamic Method*/
    @RequestMapping("/registerUser")
    public String createdUser(@ModelAttribute(value = "user") StudentUser studentUser) {
        int userId = userService.signUp(studentUser.getName(), studentUser.getCollege(), studentUser.getLocation(), studentUser.getGender());
        if (userId != -1) {
            ModelAndView modelAndView = new ModelAndView("redirect:welcome?id=" + userId);
            return modelAndView.getViewName();
        } else {
            return "signup";
        }
    }

    @RequestMapping("/welcome")
    public String welcome(@RequestParam("id") String usedId, ModelMap map) {
        map.addAttribute("id", usedId);
        return "welcome";
    }

    /*Path mathcing Request param */
    @RequestMapping("/instructor")
    public String instructor(ModelMap map) {
        //Creating tha arraylist for the instructor
        ArrayList<HashMap<String, Object>> listOfInstructor = new ArrayList<>();
        //Creating the hashmap for taking the different instruction details
        HashMap<String, Object> instructor_1 = new HashMap<>();
        instructor_1.put("id", 234);
        instructor_1.put("name", "Rohan");
        instructor_1.put("age", 27);
        listOfInstructor.add(instructor_1);

        HashMap<String, Object> instructor_2 = new HashMap<>();
        instructor_2.put("id", 200);
        instructor_2.put("name", "Aditya");
        instructor_2.put("age", 25);
        listOfInstructor.add(instructor_2);
        map.addAttribute("listOfInstructor", listOfInstructor);
        return "instructor";
    }

    @RequestMapping("/profile/{profileId}")
    public String showProfile(@PathVariable String profileId, ModelMap map) {
        map.addAttribute("profileId", profileId);
        return "profile";
    }
}

