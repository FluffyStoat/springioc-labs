package com.luxoft.springioc.lab3.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Configuration
@ImportResource("classpath:application-context.xml")
public class SimpleAppTest {

    private AbstractApplicationContext context;

    private UsualPerson expectedPerson;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(SimpleAppTest.class);
        expectedPerson = getExpectedPerson();
    }

    @Test
    public void testInitPerson() {
		Person person = context.getBean(UsualPerson.class);
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

    @After
    public void tearDown() {
        context.close();
    }
}
