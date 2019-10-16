package com.luxoft.springioc.lab1.model;

/**
 * @author bochkarev
 * @version $
 */
public class Port {
    private Type civil;
    private Type warrior;
    private Type other;
    private String name;

    public Type getCivil() {
        return civil;
    }

    public void setCivil(Type civil) {
        this.civil = civil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getWarrior() {
        return warrior;
    }

    public void setWarrior(Type warrior) {
        this.warrior = warrior;
    }

    public Type getOther() {
        return other;
    }

    public void setOther(Type other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return String.format(
            "Port name: %s\nCivil supports = %s\nWarrior supports = %s\nOther supports = %s\n"
            , name
            , civil != null ? civil.getIsSupports() : "no info"
            , warrior != null ? warrior.getIsSupports() : "no info"
            , other != null ? other.getIsSupports() : "no info"
        );
    }
}
