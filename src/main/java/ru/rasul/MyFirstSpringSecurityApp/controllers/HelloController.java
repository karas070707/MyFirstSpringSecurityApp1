package ru.rasul.MyFirstSpringSecurityApp.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rasul.MyFirstSpringSecurityApp.models.Person;
import ru.rasul.MyFirstSpringSecurityApp.services.PersonService;


@Controller
@RequestMapping("/hello")
public class HelloController {

    private final PersonService personService;

    public HelloController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/new")
    public String addPerson(@ModelAttribute("person") Person person){
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("person") Person person)
    {
        personService.save(person);
        return "redirect:/hello/new";
    }
}

