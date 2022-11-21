package hotstone.standard.cards.deck.deckbuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.cards.deck.decks.DishDeck;

public class TestDeltaStoneDeckBuilder {
    
    private DeckBuilder deckBuilder;

    @BeforeEach
    public void setup() {
        deckBuilder = new DeltaStoneDeckBuilder();
    }

    @Test
    public void shouldReturnDeck() {
        Deck result1 = deckBuilder.getDeck(FINDUS);
        Deck result2 = deckBuilder.getDeck(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof DishDeck);
        assertTrue(result2 instanceof DishDeck);
    }
}
