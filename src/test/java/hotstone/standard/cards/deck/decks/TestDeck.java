package hotstone.standard.cards.deck.decks;

import static hotstone.framework.Player.FINDUS;
import static hotstone.standard.GameConstants.CINCO_CARD;
import static hotstone.standard.GameConstants.CUATRO_CARD;
import static hotstone.standard.GameConstants.SEIS_CARD;
import static hotstone.standard.GameConstants.SIETE_CARD;
import hotstone.standard.GameConstants;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Card;
import hotstone.standard.cards.Hand;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestDeck {

    private Deck deck;
    private Hand hand;
    
    @BeforeEach
    public void setup() {
        hand = new Hand();
        deck = new DeckImpl(hand, FINDUS);
    }

    @Test
    public void testConstructor() {
        assertThat(deck.getDeckSize(), is(7));
    }

    @Test
    public void shouldHaveCorrectOrderInitially() {
        assertThat(deck.getCardByIndex(0).getName(), is(GameConstants.UNO_CARD));
        assertThat(deck.getCardByIndex(1).getName(), is(GameConstants.DOS_CARD));
        assertThat(deck.getCardByIndex(2).getName(), is(GameConstants.TRES_CARD));        
        assertThat(deck.getCardByIndex(3).getName(), is(CUATRO_CARD));
        assertThat(deck.getCardByIndex(4).getName(), is(CINCO_CARD));
        assertThat(deck.getCardByIndex(5).getName(), is(SEIS_CARD));
        assertThat(deck.getCardByIndex(6).getName(), is(SIETE_CARD));
 
    }

    @Test
    public void shouldReturnCorrectCard() {
        Card firstCard = deck.getCardByIndex(0);

        assertThat(firstCard.getName(), is(GameConstants.UNO_CARD));
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
