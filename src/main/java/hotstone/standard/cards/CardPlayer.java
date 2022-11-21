package hotstone.standard.cards;

import hotstone.framework.Card;

public interface CardPlayer {
    void initalDeal();

    void dealCard();

    int getDeckSize();

    int getHandSize();

    Card getCardInField(int index);

    int getFieldSize();

    Card getCardInHand(int index);

    Iterable<? extends Card> getHand();

    Iterable<? extends Card> getField();
    void playCard(Card card);

    void addCardToHand(Card card);

    void removeCardFromField(Card card);
}