package com.luxoft.springioc.spel_task.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author bochkarev
 * @version $
 */
@Component
public class Language {
    int id;
    @Value("Default")
    String code;
    @Value("Default")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[id = %s; name = %s; code = %s]", id, name, code);
    }
}
