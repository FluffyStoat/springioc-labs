package com.luxoft.springioc.lab1.model;

import java.io.Serializable;

/**
 * @author bochkarev
 * @version $
 */
public class Group implements Serializable {
    private static final long serialVersionUID = -8861623800888202482L;

    private String name;
    private final Room room;

    public Group(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return String.format("Group name: %s Room number: %s\n", name, room.getNumber());
    }
}
