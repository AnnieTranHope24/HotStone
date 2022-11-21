package hotstone.standard.cards;

import java.util.ArrayList;
import java.util.List;

import hotstone.framework.Card;

public class Hand {
    private List<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void addCardToHand(Card card) {
        hand.add(0, card);
    }

    public Card getCardByIndex(int index) {
        return hand.get(index);
    }

    public int getHandSize() {
        return hand.size();
    }

    public List<Card> getHand(){
        return hand;
    }

    public void dealCard(Card card, Field field) {
        for(int i = 0; i < hand.size(); i++) {
            if(hand.get(i).equals(card)) {
                Card dealtCard = hand.remove(i);
                field.addCard(dealtCard);
                return;
            }
        }
        

        //field.addCard(dealtCard);
    }
}
