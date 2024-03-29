package com.luxoft.springioc.lab3.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SpringTCFAppTest {

    @Autowired
    private UsualPerson person;

    private UsualPerson expectedPerson;

    @Before
    public void setUp() {
        expectedPerson = getExpectedPerson();
    }

    @Test
    public void testInitPerson() {
        assertEquals(expectedPerson, person);
        System.out.println(person);
    }

    private UsualPerson getExpectedPerson() {
        UsualPerson person = new UsualPerson();
        person.setAge(35);
        person.setHeight(1.78F);
        person.setIsProgrammer(true);
        person.setName("Ivan Ivanov");

        Country country = new Country();
        country.setId(1);
        country.setName("Russia");
        country.setCodeName("RU");

        person.setCountry(country);

        List<String> contacts = new ArrayList<>();
        contacts.add("asd@asd.ru");
        contacts.add("+7-234-456-67-89");

        person.setContacts(contacts);

        return person;
    }

}
