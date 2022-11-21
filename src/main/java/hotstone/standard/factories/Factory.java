package hotstone.standard.factories;

import hotstone.framework.Player;
import hotstone.standard.cards.cardeffects.cardeffecthandler.CardEffectHandler;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.WinConditionStrategy;

public interface Factory {

    WinConditionStrategy getConditionStrategy();
    
    ManaManipulator getManaManipulatorStrategy();

    HeroPower getHeroPower(Player player);

    Deck getDeck(Player player);

    CardEffectHandler getCardEffectHandler();
}
