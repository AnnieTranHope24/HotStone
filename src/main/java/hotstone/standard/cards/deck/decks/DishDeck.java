package hotstone.standard.cards.deck.decks;

import java.util.ArrayList;

import static hotstone.standard.GameConstants.BROWN_RICE_CARD;
import static hotstone.standard.GameConstants.FRENCH_FRIES_CARD;
import static hotstone.standard.GameConstants.GREEN_SALAD_CARD;
import static hotstone.standard.GameConstants.TOMATO_SALAD_CARD;
import static hotstone.standard.GameConstants.POKE_BOWL_CARD;
import static hotstone.standard.GameConstants.PUMPKIN_SOUP_CARD;
import static hotstone.standard.GameConstants.NOODLE_SOUP_CARD;
import static hotstone.standard.GameConstants.SPRING_ROLLS_CARD;
import static hotstone.standard.GameConstants.BAKED_SALMON_CARD;
import static hotstone.standard.GameConstants.CHICKEN_CURRY_CARD;
import static hotstone.standard.GameConstants.BEEF_BURGER_CARD;
import static hotstone.standard.GameConstants.FILET_MIGNON_CARD;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.standard.cards.CardImpl;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.cardeffects.NullCardEffect;
import hotstone.standard.cards.cardeffects.BrownRiceEffect;
import hotstone.standard.cards.cardeffects.TomatoSaladEffect;
import hotstone.standard.cards.cardeffects.PokeBowlEffect;
import hotstone.standard.cards.cardeffects.NoodleSoupEffect;
import hotstone.standard.cards.cardeffects.ChickenCurryEffect;
import hotstone.standard.cards.cardeffects.BeefBurgerEffect;

public class DishDeck implements Deck {
    private ArrayList<Card> unshuffledCards;
    private ArrayList<Card> cards;

    
    public DishDeck(Hand hand, Player owner) {
        unshuffledCards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            unshuffledCards.add(new CardImpl(BROWN_RICE_CARD, 1, 1, 2, false, owner, new BrownRiceEffect()));
            unshuffledCards.add(new CardImpl(FRENCH_FRIES_CARD, 1, 2, 1, false, owner, new NullCardEffect()));
            unshuffledCards.add(new CardImpl(GREEN_SALAD_CARD, 2, 2, 3, false, owner, new NullCardEffect()));
            unshuffledCards.add(new CardImpl(TOMATO_SALAD_CARD, 2, 3, 2, false, owner, new TomatoSaladEffect()));
            unshuffledCards.add(new CardImpl(POKE_BOWL_CARD, 3, 2, 4, false, owner, new PokeBowlEffect()));
            unshuffledCards.add(new CardImpl(PUMPKIN_SOUP_CARD, 4, 2, 7, false, owner, new NullCardEffect()));
            unshuffledCards.add(new CardImpl(NOODLE_SOUP_CARD, 4, 5, 3, false, owner, new NoodleSoupEffect()));
            unshuffledCards.add(new CardImpl(SPRING_ROLLS_CARD, 5, 3, 7, false, owner, new NullCardEffect()));
            unshuffledCards.add(new CardImpl(BAKED_SALMON_CARD, 5, 8, 2, false, owner, new NullCardEffect()));
            unshuffledCards.add(new CardImpl(CHICKEN_CURRY_CARD, 6, 8, 4, false, owner, new ChickenCurryEffect()));
            unshuffledCards.add(new CardImpl(BEEF_BURGER_CARD, 6, 5, 6, false, owner, new BeefBurgerEffect()));
            unshuffledCards.add(new CardImpl(FILET_MIGNON_CARD, 7, 9, 5, false, owner, new NullCardEffect()));
        }

        cards = new ArrayList<>();
        for (int i = 0; i < unshuffledCards.size();) {
            int randomIndex = (int)(Math.random() * unshuffledCards.size()) + 0;
            Card randomCard = unshuffledCards.remove(randomIndex);
            cards.add(0, randomCard);
        }

        initalDeal(hand);
    }
    
    @Override
    public int getDeckSize() {
        return cards.size();
    }

    @Override
    public Card getCardByIndex(int index) {
        return cards.get(index);
    }

    @Override
    public void dealCard(Hand hand) {
        Card dealtCard = cards.remove(0);

        hand.addCardToHand(dealtCard);
    }

    @Override
    public void initalDeal(Hand hand) {
        for (int i = 0; i < 3; i++) {
            dealCard(hand);
        }
    }
    
}
