package com.orgella.service;


import com.orgella.model.Person;

public interface IPersonService {

    void deletePerson(Person person);

    boolean isLoginAndPasswordCorrect(Person person);

    Person findPersonByLogin(String login);

    Boolean existPersonByLogin(String login);

}
