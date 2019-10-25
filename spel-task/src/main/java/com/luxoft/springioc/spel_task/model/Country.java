package com.luxoft.springioc.spel_task.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component("ContryCode")
@PropertySource("classpath:country.properties")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Value("${country.id}")
    private int id;

    @Value("${country.name}")
    private String name;

    private Language language;

    public Country() {
    }

    @Autowired
    public Country(Language language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;
        if (!Objects.equals(name, country.name)) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return String.format("Country: id = %s; name = %s; language = %s", id, name, language);
    }

}
