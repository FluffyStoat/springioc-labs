package com.luxoft.springioc.lab1.model;

import java.util.Properties;

/**
 * @author bochkarev
 * @version $
 */
public class Room {
    private int number;
    private Properties properties;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
