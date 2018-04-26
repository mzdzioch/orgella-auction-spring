package com.orgella.service;

import com.orgella.model.Person;
import com.orgella.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class PersonService implements IPersonService{

    @Autowired
    PersonRepository personRepository;

    public Person savePerson(Person person) {

        try {
            return personRepository.save(person);

        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public boolean isLoginAndPasswordCorrect(Person person) {

        Person findPerson = findPersonByLogin(person.getLogin());

        if (findPerson == null) {
            return false;
        } else if (findPerson.getPassword().equals(person.getPassword())) {
            return true;
        }

        return false;
    }

    public Person findPersonByLogin(String login) {

        return personRepository.findPersonByLogin(login);
    }

    public Boolean existPersonByLogin(String login) {

        return personRepository.existsPersonByLogin(login);
    }

}
