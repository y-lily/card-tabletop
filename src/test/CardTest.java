package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.java.Card;

public class CardTest {

    private Card card;

    @Before
    public void init() {
        card = new Card("name", "address");
    }

    @Test
    public void cardsWithDifferentAddressesAreEqual() {
        Card copy = new Card(card.getName(), "different address");
        assertTrue(card.equals(copy));
    }

    @Test
    public void cardsWithDifferentNamesAreNotEqual() {
        Card other = new Card("different name", card.getdataAddress());
        assertTrue(!card.equals(other));
    }

    @Test
    public void cardAndNullAreNotEqual() {
        Card none = null;
        assertTrue(!card.equals(none));
    }

    @Test
    public void equalsIsCalledByArrayListMethodContains() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card);

        Card copy = new Card(card.getName(), "different address");
        assertTrue(cards.contains(copy));
    }
}
