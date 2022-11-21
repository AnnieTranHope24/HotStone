package hotstone.standard.hero;

import hotstone.framework.Card;
import hotstone.framework.Hero;
import hotstone.framework.Status;
import hotstone.standard.game.GameMutator;

public interface HeroMutator extends Hero {
    // void setHeroType(String heroType);

    void removeCardFromField(Card card);

    void setActive();

    void changeHealth(int health);

    void setHealth(int health);

    void dealDamage(int amount);

    void setManaAtBeginningOfTurn(int turn);

    void dealMana(int amount);

    void dealCard();

    int getDeckSize();

    int getHandSize();

    Card getCardInField(int index);

    int getFieldSize();

    Card getCardInHand(int index);

    Iterable<? extends Card> getHand();

    Iterable<? extends Card> getField();

    Status usePower(GameMutator gameMutator, HeroMutator attacker);
    
    void playCard(Card card);

    void addCardToHand(Card card);
}
