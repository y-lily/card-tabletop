package test;

import java.lang.IndexOutOfBoundsException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.Card;
import main.java.Deck;


public class DeckTest {

    private Deck deck;
    private Card card;
    private Card notAdded;
    private Card first, second;


    @Before
    public void init() {
        deck = new Deck();
        card = new Card("card", "cardAddress");
        notAdded = new Card("none", "nowhere");
        first = new Card("first", "firstAddress");
        second = new Card("second", "secondAddress");
    }


    @Test
    public void sizeOfNewDeckIsZero() { assertEquals(0, deck.size()); }


    @Test
    public void newDeckIsEmpty() { assertTrue(deck.isEmpty()); }


    @Test
    public void deckWithAddedCardIsNotEmpty() {
        deck.add(card);
        assertTrue(!deck.isEmpty());
    }


    @Test
    public void addIncreasesSize() {
        deck.add(card);
        assertEquals(1, deck.size());
    }


    @Test
    public void deckContainsAddedCard() {
        deck.add(card);
        assertTrue(deck.containsCardWithName(card));
    }


    @Test
    public void deckDoesNotContainNotAddedCard() {
        deck.add(card);
        assertTrue(!deck.containsCardWithName(notAdded));
    }


    @Test
    public void indexOfCardIsIndexOfFirstSuchCard() {
        deck.add(card);
        deck.add(card);
        assertEquals(0, deck.indexOfCardWithName(card));
    }


    @Test
    public void indexOfCardIsNotChangedWhenAnotherCardAdded() {
        deck.add(first);
        deck.add(second);
        assertEquals(0, deck.indexOfCardWithName(first));
    }


    @Test
    public void indexOfSecondAddedCardIsOne() {
        deck.add(first);
        deck.add(second);
        assertEquals(1, deck.indexOfCardWithName(second));
    }


    @Test
    public void indexOfNotAddedCardIsMinusOne() {
        deck.add(first);
        deck.add(second);
        assertEquals(-1, deck.indexOfCardWithName(notAdded));
    }


    @Test
    public void deckContainsCardWithNameOfAddedCard() {
        deck.add(card);
        assertTrue(deck.containsCardWithName(card.getName()));
    }


    @Test
    public void deckDoesNotContainCardWithNameOfNotAddedCard() {
        deck.add(card);
        assertTrue(!deck.containsCardWithName(notAdded.getName()));
    }


    @Test
    public void indexOfCardWithNameIsIndexOfFirstCardWithSuchName() {
        deck.add(card);
        deck.add(card);
        assertEquals(0, deck.indexOfCardWithName(card.getName()));
    }


    @Test
    public void indexOfCardWithNameIsNotChangedWhenAnotherCardAdded() {
        deck.add(first);
        deck.add(second);
        assertEquals(0, deck.indexOfCardWithName(first.getName()));
    }


    @Test
    public void indexOfCardWithNameOfSecondAddedCardIsOne() {
        deck.add(first);
        deck.add(second);
        assertEquals(1, deck.indexOfCardWithName(second.getName()));
    }


    @Test
    public void indexOfCardWithNameOfNotAddedCardIsMinusOne() {
        deck.add(card);
        assertEquals(-1, deck.indexOfCardWithName(notAdded.getName()));
    }


    @Test
    public void getReturnsCardEqualToTheAddedCard() {
        deck.add(card);
        assertTrue(deck.get(0).equals(card));
    }


    @Test
    public void getDoesNotReturnCardEqualToCardAddedEarlier() {
        deck.add(first);
        deck.add(second);
        assertTrue(!deck.get(1).equals(first));
    }


    @Test
    public void getThrowsIndexOutOfBoundsExceptionOnNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.get(-1);
        });
    }


    @Test
    public void getThrowsIndexOutOfBoundsExceptionOnOutOfBoundsIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.get(deck.size());
        });
    }


    @Test
    public void getDoesNotChangeSize() {
        deck.add(card);
        deck.get(0);
        assertEquals(1, deck.size());
    }


    @Test
    public void popDecreasesSize() {
        deck.add(card);
        deck.pop();
        assertEquals(0, deck.size());
    }


    @Test
    public void deckDoesNotContainPoppedCard() {
        deck.add(card);
        deck.pop();
        assertTrue(!deck.containsCardWithName(card));
    }


    @Test
    public void popOnlyRemovesOneOfTheSameCards() {
        deck.add(card);
        deck.add(card);
        deck.pop();
        assertTrue(deck.containsCardWithName(card));
    }


    @Test
    public void popOnlyRemovesLastCard() {
        deck.add(first);
        deck.add(second);
        deck.pop();
        assertTrue(deck.containsCardWithName(first));
    }


    @Test
    public void popReturnsCardEqualToTheAdded() {
        deck.add(card);
        assertEquals(card, deck.pop());
    }


    @Test
    public void popThrowsIndexOutOfBoundsExceptionOnEmptyDeck() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.pop();
        });
    }


    @Test
    public void removeDecreasesSize() {
        deck.add(card);
        deck.remove(0);
        assertEquals(0, deck.size());
    }


    @Test
    public void deckDoesNotContainRemovedCard() {
        deck.add(first);
        deck.add(second);
        deck.remove(0);
        assertTrue(!deck.containsCardWithName(first));
    }


    @Test
    public void removeOnlyRemovesOneOfTheSameCards() {
        deck.add(card);
        deck.add(card);
        deck.remove(0);
        assertTrue(deck.containsCardWithName(card));
    }


    @Test
    public void removeReturnsCardEqualToTheAdded() {
        deck.add(card);
        assertEquals(card, deck.remove(0));
    }


    @Test
    public void removeThrowsOutOfBoundsExceptionOnNegativeIndex() {
        deck.add(card);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.remove(-1);
        });
    }


    @Test
    public void removeThrowsOutOfBoundsExceptionOnOutOfBoundsIndex() {
        deck.add(card);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.remove(deck.size());
        });
    }


    @Test
    public void cardAddedWithIndexCanBeFoundByThisIndex() {
        deck.add(first);
        deck.add(second);
        deck.add(1, card);
        assertEquals(1, deck.indexOfCardWithName(card));
    }


    @Test
    public void addingCardWithIndexDoesNotChangeLesserIndices() {
        deck.add(first);
        deck.add(second);
        deck.add(1, card);
        assertEquals(0, deck.indexOfCardWithName(first));
    }


    @Test
    public void addingCardWithIndexChangesGreaterIndices() {
        deck.add(first);
        deck.add(second);
        deck.add(1, card);
        assertEquals(2, deck.indexOfCardWithName(second));
    }


    @Test
    public void addCardWithIndexThrowsOutOfBoundsExceptionOnNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.add(-1, card);
        });
    }


    @Test
    public void addCardWithIndexThrowsOutOfBoundsExceptionOnOutOfBoundsIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            deck.add(1, card);
        });
    }


    // TODO: delete this one.
    @Test
    public void thisShouldBeDeleted() {
        deck.add(first);
        deck.add(second);
        deck.add(card);
        deck.add(card);
        deck.add(card);
        deck.add(card);
        deck.add(card);
        assertTrue(deck.indexOfCardWithName(first) == 0);
        deck.shuffle();
        assertTrue(!(deck.indexOfCardWithName(first) == 0));
    }
}
