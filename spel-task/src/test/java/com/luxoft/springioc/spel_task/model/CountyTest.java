package com.luxoft.springioc.spel_task.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:application-context.xml",
})
public class CountyTest {
    @Autowired
    @Qualifier("ContryCode")
    Country countryCode;

    @Autowired
    Country countryXml;

    @Before
    public void setUp() {
    }

    @Test
    public void testInitLanguage() {
        System.out.println(countryCode);
        System.out.println(countryXml);
    }
}
