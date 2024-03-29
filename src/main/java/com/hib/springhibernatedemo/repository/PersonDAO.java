package com.hib.springhibernatedemo.repository;

import com.hib.springhibernatedemo.model.Person;
import com.hib.springhibernatedemo.model.Request;

import java.util.List;

public interface PersonDAO {
    Person savePerson(Request request);
    boolean delete(Person person);
    List<Person> getAllPersons();
}
