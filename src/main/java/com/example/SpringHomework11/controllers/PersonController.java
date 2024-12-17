package com.example.SpringHomework11.controllers;

import com.example.SpringHomework11.model.Person;
import com.example.SpringHomework11.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> findAllPerson(){;
        return personService.findAllPerson();
    }


    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }


    @DeleteMapping ("/persons/delete/{id}")
    public String deletePersonById(@PathVariable("id") Long id){
        personService.deletePersonById(id);
        return ("Person with id: " + id + " deleted!");
    }


    @PutMapping("/persons/update/{id}")
    public Person updatePersonById(@PathVariable("id") Long id, @RequestBody Person person){
        return personService.updatePersonById(id, person);
    }

}
