package com.luxoft.springioc.lab1.model;

/**
 * @author bochkarev
 * @version $
 */
public class Engine {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\n";
    }
}
