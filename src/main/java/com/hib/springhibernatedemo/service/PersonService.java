package com.hib.springhibernatedemo.service;

import com.hib.springhibernatedemo.model.Person;
import com.hib.springhibernatedemo.model.Request;

import java.util.List;

public interface PersonService {
    Person savePerson(Request request);
    boolean delete(Person person);
    List<Person> getAllPersons();
}
