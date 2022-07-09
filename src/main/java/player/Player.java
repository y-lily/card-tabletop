package main.java.player;

import java.util.ArrayList;
import java.util.List;

import main.java.Field;
import main.java.access.AccessPermission;
import main.java.access.AccessType;


public class Player {

    protected String name;
    protected List<Field> fields;


    public Player(String name) {
        this.name = name;
        fields = new ArrayList<>();
        initiateFields();
    }


    protected void initiateFields() {
        Field main = new Field("main");
        main.setAccess(AccessType.VIEW, AccessPermission.EVERYBODY);
        main.setAccess(AccessType.MODIFY, AccessPermission.OWNER);
        fields.add(main);
    }


    public String getName() { return name; }


    public List<Field> getFields() { return fields; }
}
