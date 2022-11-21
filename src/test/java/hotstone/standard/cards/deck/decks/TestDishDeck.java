package hotstone.standard.cards.deck.decks;

import static hotstone.framework.Player.FINDUS;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Card;
import hotstone.standard.cards.Hand;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestDishDeck {
    
    private Deck deck;
    private Hand hand;
    
    @BeforeEach
    public void setup() {
        hand = new Hand();
        deck = new DishDeck(hand, FINDUS);
    }

    @Test
    public void testConstructor() {
        assertThat(deck.getDeckSize(), is(21));
    }

    @Test
    public void shouldDealOneCardAndRemoveItFromDeck() {
        Card cardInSecondPostion = deck.getCardByIndex(1);
        int deckSize = deck.getDeckSize();

        deck.dealCard(hand);

        // checks that a card was dealt
        assertThat(deck.getDeckSize(), is(deckSize - 1));

        // ensures that the first card in the deck is dealt
        assertThat(deck.getCardByIndex(0), is(cardInSecondPostion));
    }

    @Test
    public void shouldDealThreeCardsForInitalDeal() {
        Card cardInFourthPostion = deck.getCardByIndex(3);
        int deckSize = deck.getDeckSize();

        deck.initalDeal(hand);

        // checks that 3 cards were dealt
        assertThat(deck.getDeckSize(), is(deckSize - 3));

        // ensures that the first three cards in the deck were dealt
        assertThat(deck.getCardByIndex(0), is(cardInFourthPostion));
    }
}
