package main.java;

public class Card {

    private String name;
    private String dataAddress;


    public Card(String name, String dataAddress) {
        this.name = name;
        this.dataAddress = dataAddress;
    }


    @Override
    public boolean equals(Object comparedObject) {

        if (!(comparedObject instanceof Card)) { return false; }

        if (this == comparedObject) { return true; }

        Card comparedCard = (Card) comparedObject;

        return this.name == comparedCard.name;
    }


    public String getName() { return name; }


    public String getdataAddress() { return dataAddress; }
}
