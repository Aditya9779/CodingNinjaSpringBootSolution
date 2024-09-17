package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id)
    {
        return personService.getPersonById(id);
    }

    @GetMapping("/all")
    public List<Person> getAllPersons()
    {
        return personService.getAllPersons();
    }
}
