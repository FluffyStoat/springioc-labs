package com.luxoft.springioc.lab1.model;

/**
 * @author bochkarev
 * @version $
 */
public class Type {
    private String typeName;
    private String isSupports;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }

    public String getIsSupports() {
        return isSupports;
    }

    public void setIsSupports(String isSupports) {
        this.isSupports = isSupports;
    }
}
