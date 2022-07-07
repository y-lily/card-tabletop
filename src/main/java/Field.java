package main.java;

import java.util.HashMap;
import java.util.Map;

import main.java.access.AccessPermission;
import main.java.access.AccessType;


public class Field {

    private String name;
    private Deck cards;
    private Map<AccessType, AccessPermission> permissions;


    public Field(String name, Deck cards) {
        this.name = name;
        this.cards = cards;
        permissions = new HashMap<>();
    }


    public Field(String name) { this(name, new Deck()); }


    public String getName() { return name; }


    public Deck getCards() { return cards; }


    public void setAccess(AccessType access, AccessPermission permission) {
        permissions.put(access, permission);
    }


    public AccessPermission whoCanAccess(AccessType access) {
        return permissions.getOrDefault(access, AccessPermission.UNKNOWN);
    }
}
