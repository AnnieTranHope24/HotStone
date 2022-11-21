package hotstone.standard.cards;

import hotstone.framework.Card;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.hero.HeroImpl;

public class CardPlayerImpl implements CardPlayer{
    
    private Deck deck;
    private Hand hand;
    private Field field;

    public CardPlayerImpl(HeroImpl heroImpl, Field field, Deck deck){
        this.hand = new Hand();
        this.field = field;
        this.deck = deck;

    }

    public void dealCard(){
        deck.dealCard(hand);
    }

    public void playCard(Card card){
        hand.dealCard(card, field);
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }

    @Override
    public int getHandSize() {
        return hand.getHandSize();
    }

    @Override
    public Card getCardInField(int index) {
        return field.getCardInField(index);
    }

    @Override
    public int getFieldSize() {
        return field.getFieldSize();
    }

    @Override
    public Card getCardInHand(int index) {
        return hand.getCardByIndex(index);
    }

    @Override
    public Iterable<? extends Card> getHand() {
        return hand.getHand();
    }

    @Override
    public Iterable<? extends Card> getField() {
        return hand.getHand();
    }

    @Override
    public void addCardToHand(Card card) {
        hand.addCardToHand(card);        
    }

    @Override
    public void initalDeal() {
        deck.initalDeal(hand);
        
    }

    @Override
    public void removeCardFromField(Card card) {
        field.removeCardFromField(card);
        
    }


}
