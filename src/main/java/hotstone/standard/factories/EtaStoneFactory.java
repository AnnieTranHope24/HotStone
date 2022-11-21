package hotstone.standard.factories;

import hotstone.framework.Player;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.cards.cardeffects.cardeffecthandler.CardEffectHandler;
import hotstone.standard.cards.cardeffects.cardeffecthandler.EtaStoneCardEffectHandler;
import hotstone.standard.cards.deck.deckbuilders.DeltaStoneDeckBuilder;
import hotstone.standard.hero.herobuilder.AlphaStoneHeroBuilder;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.mana.DeltaStoneManaManipulator;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.AlphaStoneWinConditionStrategy;
import hotstone.standard.winconditions.WinConditionStrategy;

public class EtaStoneFactory implements Factory {

    @Override
    public WinConditionStrategy getConditionStrategy() {
        return new AlphaStoneWinConditionStrategy();
    }

    @Override
    public ManaManipulator getManaManipulatorStrategy() {
        return new DeltaStoneManaManipulator();
    }

    @Override
    public HeroPower getHeroPower(Player player) {
        return new AlphaStoneHeroBuilder().generateHeroPower(player);
    }
    
    @Override
    public Deck getDeck(Player player) {
        return new DeltaStoneDeckBuilder().getDeck(player);
    }

    @Override
    public CardEffectHandler getCardEffectHandler() {
        return new EtaStoneCardEffectHandler();
    }
}
