package com.hib.springhibernatedemo.controller;

import com.hib.springhibernatedemo.model.Person;
import com.hib.springhibernatedemo.model.Request;
import com.hib.springhibernatedemo.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// todo: Revamp

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    @Autowired
    private PersonDAO personDao;

    @DeleteMapping(value = "/{id}")
    public String deletePersonById(@PathVariable long id) {
        try {
            Person person = new Person();
            person.setId(id);
            personDao.delete(person);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person successfully deleted!";
    }

    @PostMapping
    public String savePerson(@RequestBody Request request) {
        System.out.println(request.getName());
        try {
            Person person = new Person();
            person.setName(request.getName());
            person.setCity(request.getCity());
            personDao.savePerson(person);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Person successfully saved!";
    }
    @GetMapping
    public List getAllPeople() {
        try {
            return personDao.getAllPersons();
        } catch (Exception ex) {
            return null;
        }
    }
}
