package main.java;

import java.util.Objects;


public class Card {

    private String name;
    private String dataAddress;


    public Card(String name, String dataAddress) {
        this.name = name;
        this.dataAddress = dataAddress;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject) return true;

        if (!(comparedObject instanceof Card)) return false;

        Card comparedCard = (Card) comparedObject;

        return Objects.equals(name, comparedCard.name);
    }


    public String getName() { return name; }


    public String getdataAddress() { return dataAddress; }
}
