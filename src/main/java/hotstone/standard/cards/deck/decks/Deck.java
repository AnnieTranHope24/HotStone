package hotstone.standard.cards.deck.decks;

import hotstone.framework.Card;
import hotstone.standard.cards.Hand;

/*
 * A Deck is an array of cards.
 */
public interface Deck {
    public int getDeckSize();

    public Card getCardByIndex(int index);

    public void dealCard(Hand hand);

    public void initalDeal(Hand hand);
}
