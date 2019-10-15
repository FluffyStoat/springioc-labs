package com.luxoft.springioc.lab1.model;

import java.util.Objects;

public class UsualPerson implements Person {
    private int age;
    private float height;
    private boolean isProgrammer;
    private String name;

    private Country country;

    public UsualPerson() {

    }

    public UsualPerson(int age, float height, boolean isProgrammer, String name, Country country) {
        this.age = age;
        this.height = height;
        this.isProgrammer = isProgrammer;
        this.name = name;
        this.country = country;
    }

    public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHello(Person person) {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isProgrammer() {
        return isProgrammer;
    }

    public void setProgrammer(boolean programmer) {
        isProgrammer = programmer;
    }

    public String toString() {
        String s = "Name: " + name + "\n"
            + "Age: " + age + "\n"
            + "Height: " + height + "\n"
            + "Country: " + country + "\n"
            + "Is Programmer?: " + isProgrammer + "\n";
        return s;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsualPerson person = (UsualPerson) o;

        if (age != person.age) return false;
        if (Float.compare(person.height, height) != 0) return false;
        if (isProgrammer != person.isProgrammer) return false;
        if (!Objects.equals(country, person.country)) return false;
        if (!Objects.equals(name, person.name)) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (height != +0.0f ? Float.floatToIntBits(height) : 0);
        result = 31 * result + (isProgrammer ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}