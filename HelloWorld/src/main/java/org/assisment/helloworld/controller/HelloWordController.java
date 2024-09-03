package org.assisment.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
/*For accessing the coding url-http://localhost:8080/project/coding
 *AND For hello url-http://localhost:8080/project/hello*/


public class HelloWordController {
    @RequestMapping("/hello")//http://localhost:8080/hello this is the url
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/coding")//http://localhost:8080/coding
    public String coding() {
        return "Hello Coding Ninjas";
    }

    @GetMapping("/Aditya/{Level}")//http://localhost:8080/project/Aditya/Master
    //http://localhost:8080/project/Aditya/Hero it will be any name passing in the link
    public String Aditya(@PathVariable String Level) {
        return "Hello Aditya " + Level;
    }

}
