package com.hib.springhibernatedemo.repository;

import com.hib.springhibernatedemo.model.Person;

import java.util.List;

public interface PersonDAO {
    String savePerson(Person person);
    boolean delete(Person person);
    List getAllPersons();
}
