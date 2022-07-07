package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Deck implements Iterable<Card> {

    private List<Card> cards;


    public Deck() { cards = new ArrayList<>(); }


    @Override
    public Iterator<Card> iterator() { return cards.iterator(); }


    public void add(Card card) { cards.add(card); }


    public void add(int index, Card card) { cards.add(index, card); }


    public void clear() { cards.clear(); }


    public boolean containsCardWithName(Card card) {
        return cards.contains(card);
    }


    public boolean containsCardWithName(String cardName) {
        return indexOfCardWithName(cardName) != -1;
    }


    public Card get(int index) { return cards.get(index); }


    public int indexOfCardWithName(Card card) { return cards.indexOf(card); }


    public int indexOfCardWithName(String cardName) {

        for (int i = 0; i < cards.size(); ++i) {

            if (cards.get(i).getName().equals(cardName)) { return i; }
        }

        return -1;
    }


    public Card remove(int index) {
        Card toRemove = cards.get(index);
        cards.remove(index);
        return toRemove;
    }


    public Card pop() { return remove(cards.size() - 1); }


    public void shuffle() { Collections.shuffle(cards); }


    public boolean isEmpty() { return cards.isEmpty(); }


    public int size() { return cards.size(); }
}
