package com.luxoft.springioc.lab1.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:application-context.xml",
})
public class HelloWorldTest {
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";
/*
	//Get context from test scope.
	@Autowired
	private ApplicationContext context;
*/

	@Autowired
	private Person russianPerson;
	@Autowired
	private Person russianPerson2;
	@Autowired
	private Person americanPerson;
    @Resource(name = "canadian")
    private Person canadianPerson;
    @Autowired
    private Person defaultPerson;
    @Resource(name = "group")
    private Group resourceGroup;

	private Person expectedRussianPerson;
	private Person expectedAmericanPerson;

    private AbstractApplicationContext context;

	@Before
	public void setUp() {
		context = new FileSystemXmlApplicationContext(new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		expectedRussianPerson = getRussianPerson();
		expectedAmericanPerson = getAmericanPerson();
	}

	@Test
	public void testInitPerson() {
		UsualPerson russian = (UsualPerson) context.getBean("russianPerson", Person.class);
		UsualPerson american = (UsualPerson) context.getBean("americanPerson", Person.class);
        Group group = context.getBean(Group.class);
        Room room = group.getRoom();

		assertEquals(expectedRussianPerson, russian);
		assertEquals(expectedAmericanPerson, american);

		assertEquals(expectedRussianPerson, russianPerson);
		assertEquals(expectedAmericanPerson, americanPerson);

		assertNotEquals(russianPerson, americanPerson);

		assertEquals(101, room.getNumber());
		assertEquals("15", room.getProperties().getProperty("quantity"));
		assertEquals("true", room.getProperties().getProperty("isNetworkPresent"));
		assertNotNull(resourceGroup);

		assertNotNull(russianPerson2);

		System.out.println("Russian BeanFactory:\n" + russian);
		System.out.println("American BeanFactory:\n" + american);

		System.out.println("Russian Autowired:\n" + russianPerson);
		System.out.println("Russian Autowired2:\n" + russianPerson2);

		System.out.println("American Autowired:\n" + americanPerson);
        System.out.println("Canadian Resource:\n" + canadianPerson);
        System.out.println("Default:\n" + defaultPerson);

        System.out.println("Group:\n" + group);
        System.out.println("Resource group:\n" + resourceGroup);
	}

	private UsualPerson getRussianPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setHeight(175);
		person.setIsProgrammer(true);
		person.setName("Peter Petrov");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		return person;
	}

	private Person getAmericanPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(29);
		person.setHeight(173);
		person.setIsProgrammer(true);
		person.setName("John Smith");

		Country country = new Country();
		country.setId(2);
		country.setName("Usa");
		country.setCodeName("US");

		person.setCountry(country);

		return person;
	}

	@After
	public void tearDown() {
		if (context != null) {
			context.close();
		}
	}
}
