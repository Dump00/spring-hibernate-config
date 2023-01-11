package com.hib.springhibernatedemo.repository;

import com.hib.springhibernatedemo.model.Person;
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
    public String savePerson(Person person) {
        Long isSuccess = (Long)getSession().save(person);
        if(isSuccess >= 1){
            return "Success";
        }else{
            return "Error while Saving Person";
        }
    }

    @Override
    public boolean delete(Person person) {
        getSession().delete(person);
        return true;
    }

    @Override
    public List getAllPersons() {
        return getSession().createQuery("from Person").list();
    }
}
