package hotstone.standard.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.standard.cards.cardeffects.NullCardEffect;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestHand {
    
    private Hand hand;

    @BeforeEach
    public void setup() {
        hand = new Hand();
    }

    @Test
    public void shouldAddCardToHand() {
        Card card = new CardImpl("Uno", 1, 1, 1, false, Player.FINDUS, new NullCardEffect());

        hand.addCardToHand(card);

        assertThat(hand.getCardByIndex(0), is(card));
    }

    @Test
    public void shouldReturnZeroForInitialHandSize() {
        assertThat(hand.getHandSize(), is(0));
    }

    @Test
    public void shouldReturnOneAfterCardIsAddedToHand() {
        Card card = new CardImpl("Uno", 1, 1, 1, false, Player.FINDUS, new NullCardEffect());

        hand.addCardToHand(card);

        assertThat(hand.getHandSize(), is(1));
    }
}
