package hotstone.standard.cards.deck.decks;
import java.util.ArrayList;

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.standard.cards.CardImpl;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.cardeffects.NullCardEffect;

public class DeckImpl implements Deck {
    private ArrayList<Card> cards;
    
    public DeckImpl(Hand hand, Player owner){
        cards = new ArrayList<>();
        cards.add(new CardImpl("Uno", 1, 1, 1, false, owner, new NullCardEffect()));
        cards.add(new CardImpl("Dos", 2, 2, 2, false, owner, new NullCardEffect()));
        cards.add(new CardImpl("Tres", 3, 3, 3, false, owner, new NullCardEffect()));
        cards.add(new CardImpl("Cuatro", 2, 3, 1, false, owner, new NullCardEffect()));
        cards.add(new CardImpl("Cinco", 3, 5, 1, false, owner, new NullCardEffect()));
        cards.add(new CardImpl("Seis", 2, 1, 3, false, owner, new NullCardEffect()));
        cards.add(new CardImpl("Siete", 3, 2, 4, false, owner, new NullCardEffect()));

        //initalDeal(hand);
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
