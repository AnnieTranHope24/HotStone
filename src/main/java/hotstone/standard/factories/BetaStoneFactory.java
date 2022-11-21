package hotstone.standard.factories;

import hotstone.framework.Player;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.cards.cardeffects.cardeffecthandler.CardEffectHandler;
import hotstone.standard.cards.cardeffects.cardeffecthandler.NullCardEffectHandler;
import hotstone.standard.cards.deck.deckbuilders.AlphaStoneDeckBuilder;
import hotstone.standard.hero.herobuilder.AlphaStoneHeroBuilder;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.mana.BetaStoneManaManipulator;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.BetaStoneWinConditionStrategy;
import hotstone.standard.winconditions.WinConditionStrategy;

public class BetaStoneFactory implements Factory{

    @Override
    public WinConditionStrategy getConditionStrategy() {
        return new BetaStoneWinConditionStrategy();
    }

    @Override
    public ManaManipulator getManaManipulatorStrategy() {
        return new BetaStoneManaManipulator();
    }

    @Override
    public HeroPower getHeroPower(Player player) {
        return new AlphaStoneHeroBuilder().generateHeroPower(player);
    }

    @Override
    public Deck getDeck(Player player) {
        return new AlphaStoneDeckBuilder().getDeck(player);
    }

    @Override
    public CardEffectHandler getCardEffectHandler() {
        return new NullCardEffectHandler();
    }
}
