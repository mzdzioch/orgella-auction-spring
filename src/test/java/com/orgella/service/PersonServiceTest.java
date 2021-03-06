package com.orgella.service;

import com.orgella.exceptions.LoginOrPasswordNullException;
import com.orgella.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Before
    public void contextLoads(){

        personService.savePerson(new Person("misiek", "1234"));
        personService.savePerson(new Person("michal", "12345"));
        personService.savePerson(new Person("jacek", "haslo"));
        personService.savePerson(new Person("bongo", "qwerty"));
    }

    @Test
    public void shouldReturnNotNullIfFindUser(){
        Person personTest = personService.findPersonByLogin("misiek");
        Assert.assertNotNull(personTest);
    }

    @Test
    public void shouldReturnNullIfFindUser(){
        Person personTest = personService.findPersonByLogin("misiekk");
        Assert.assertNull(personTest);
    }

    @Test
    public void shouldReturnFalseIfPasswordIsNotCorrect(){
    assertFalse(personService.isLoginAndPasswordCorrect(new Person("misiek", "123")));
    assertFalse(personService.isLoginAndPasswordCorrect(new Person("michal", "I2345")));
    assertFalse(personService.isLoginAndPasswordCorrect(new Person("jacek", "hasło")));
    assertFalse(personService.isLoginAndPasswordCorrect(new Person("bongo", "Qwerty")));
    }

    @Test
    public void shouldReturnTrueIfLoginAndPasswordCorrect(){
        assertTrue(personService.isLoginAndPasswordCorrect(new Person("misiek", "1234")));
        assertTrue(personService.isLoginAndPasswordCorrect(new Person("michal", "12345")));
        assertTrue(personService.isLoginAndPasswordCorrect(new Person("jacek", "haslo")));
        assertTrue(personService.isLoginAndPasswordCorrect(new Person("bongo", "qwerty")));
    }

    @Test
    public void shouldReturnFalseIfLoginIsNotCorrect(){
        assertFalse(personService.isLoginAndPasswordCorrect(new Person("misie", "1234")));
        assertFalse(personService.isLoginAndPasswordCorrect(new Person("michall", "12345")));
        assertFalse(personService.isLoginAndPasswordCorrect(new Person("jacekk", "haslo")));
        assertFalse(personService.isLoginAndPasswordCorrect(new Person("bongO", "qwerty")));
    }

//    @Test
//    public void shouldReturnUserIfSaveCorrectly() throws LoginOrPasswordNullException {
//
//        Person person = new Person("marian", "marian123");
//        Person personTest = personService.savePerson(person);
//        assertEquals(personTest, person);
//    }


    @Test
    public void shouldReturnNullIfUserRemovedCorrectly(){

        Person person = personService.findPersonByLogin("misiek");
        personService.deletePerson(person);
        Person personTest = personService.findPersonByLogin("misiek");
        Assert.assertNull(personTest);
    }

}
