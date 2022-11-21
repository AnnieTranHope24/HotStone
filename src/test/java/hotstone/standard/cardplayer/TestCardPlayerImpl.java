package hotstone.standard.cardplayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Card;
import hotstone.standard.GameConstants;
import hotstone.standard.cards.CardPlayer;
import hotstone.standard.cards.CardPlayerImpl;
import hotstone.standard.cards.Field;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.deck.decks.DeckImpl;
import hotstone.standard.hero.HeroImpl;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import static hotstone.framework.Player.FINDUS;

public class TestCardPlayerImpl {

    private CardPlayer cp;

    @BeforeEach
    public void setup() {   
        cp = new CardPlayerImpl(new HeroImpl(), new Field(), new DeckImpl(new Hand(), FINDUS));
    }

    @Test
    public void shouldRightInitialSize() {
        assertThat(cp.getDeckSize(),is(7));
        assertThat(cp.getHandSize(),is(0));
        assertThat(cp.getFieldSize(),is(0));
        cp = new CardPlayerImpl(new HeroImpl(), new Field(), new DeckImpl(new Hand(), FINDUS));
    }

    @Test
    public void testDealCard() {
        cp.dealCard();
        assertThat(cp.getDeckSize(),is(6));
        assertThat(cp.getHandSize(),is(1));
        assertThat(cp.getCardInHand(0).getName(),is(GameConstants.UNO_CARD));
    }

    @Test
    public void testPlayCard() {
        //deal card from deck to hand
        cp.dealCard();
        //now hand should have 4 cards, 3 initial and 1 just dealt
        Card playedCard = cp.getCardInHand(0);
        //play card from hand to field
        cp.playCard(playedCard);
        //now hand should have 3 cards
        assertThat(cp.getHandSize(),is(0));
        assertThat(cp.getFieldSize(),is(1));
        assertThat(cp.getCardInField(0),is(playedCard));
    }    
}
