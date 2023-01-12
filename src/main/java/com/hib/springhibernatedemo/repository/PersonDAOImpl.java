package com.hib.springhibernatedemo.repository;

import com.hib.springhibernatedemo.model.Person;
import com.hib.springhibernatedemo.model.Request;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Person savePerson(Request request) {
        Person person = new Person();
        person.setName(request.getName());
        person.setCity(request.getCity());
        getSession().persist(person);
        return person;
    }

    @Override
    public boolean delete(Person person) {
        getSession().remove(person);
        return true;
    }

    @Override
    public List<Person> getAllPersons() {
        return getSession().createQuery("from Person", Person.class).list();
    }
}