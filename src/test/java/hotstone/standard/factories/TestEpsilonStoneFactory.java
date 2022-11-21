package hotstone.standard.factories;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.cards.cardeffects.cardeffecthandler.CardEffectHandler;
import hotstone.standard.cards.cardeffects.cardeffecthandler.NullCardEffectHandler;
import hotstone.standard.cards.deck.decks.Deck;
import hotstone.standard.cards.deck.decks.DeckImpl;
import hotstone.standard.hero.heropower.FrenchChef;
import hotstone.standard.hero.heropower.ItalianChef;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.mana.AlphaStoneManaManipulator;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.AlphaStoneWinConditionStrategy;
import hotstone.standard.winconditions.WinConditionStrategy;

public class TestEpsilonStoneFactory {
    
    private EpsilonStoneFactory epsilonStoneFactory;

    @BeforeEach
    public void setup() {
        epsilonStoneFactory = new EpsilonStoneFactory();
    }

    @Test
    public void shouldReturnAlphaStoneWinCondition() {
        WinConditionStrategy result = epsilonStoneFactory.getConditionStrategy();
        assertNotNull(result);

        assertTrue(result instanceof AlphaStoneWinConditionStrategy);
    }
    
    @Test
    public void shouldReturnBetaStoneManaManipulator() {
        ManaManipulator result = epsilonStoneFactory.getManaManipulatorStrategy();
        assertNotNull(result);

        assertTrue(result instanceof AlphaStoneManaManipulator);
    }

    @Test
    public void shouldReturnCorrectHeroPower() {
        HeroPower result1 = epsilonStoneFactory.getHeroPower(FINDUS);
        HeroPower result2 = epsilonStoneFactory.getHeroPower(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof FrenchChef);
        assertTrue(result2 instanceof ItalianChef);
    }

    @Test
    public void shouldReturnCorrectDeck() {
        Deck result1 = epsilonStoneFactory.getDeck(FINDUS);
        Deck result2 = epsilonStoneFactory.getDeck(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof DeckImpl);
        assertTrue(result2 instanceof DeckImpl);
    }

    @Test
    public void shouldReturnNullCardEffectHandler(){
        CardEffectHandler result = epsilonStoneFactory.getCardEffectHandler();
        assertNotNull(result);

        assertTrue(result instanceof NullCardEffectHandler);
    }
}
