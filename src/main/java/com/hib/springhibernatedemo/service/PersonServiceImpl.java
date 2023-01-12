package com.hib.springhibernatedemo.service;

import com.hib.springhibernatedemo.model.Person;
import com.hib.springhibernatedemo.model.Request;
import com.hib.springhibernatedemo.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDAO;

    @Override
    public Person savePerson(Request request) {
        return personDAO.savePerson(request);
    }

    @Override
    public boolean delete(Person person) {
        return personDAO.delete(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }
}
