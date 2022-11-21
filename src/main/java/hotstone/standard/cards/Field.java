package hotstone.standard.cards;

import java.util.ArrayList;

import hotstone.framework.Card;

public class Field {

    ArrayList<Card> cards = new ArrayList<>();

    public int getFieldSize() {
        return cards.size();
    }

    public Card getCardInField(int indexInField) {
        return cards.get(indexInField);
    }

    public Iterable<? extends Card> getField() {
        return cards;
    }
    
    public void addCard(Card card) {
        cards.add(0,card);
    }

    public void removeCardFromField(Card card) {
        cards.remove(card);
    }
}

