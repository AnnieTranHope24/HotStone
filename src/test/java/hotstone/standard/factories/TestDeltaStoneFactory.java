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
import hotstone.standard.cards.deck.decks.DishDeck;
import hotstone.standard.hero.heropower.Baby;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.mana.DeltaStoneManaManipulator;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.AlphaStoneWinConditionStrategy;
import hotstone.standard.winconditions.WinConditionStrategy;

public class TestDeltaStoneFactory {
    
    private DeltaStoneFactory deltaStoneFactory;

    @BeforeEach
    public void setup() {
        deltaStoneFactory = new DeltaStoneFactory();
    }

    @Test
    public void shouldReturnAlphaStoneWinCondition() {
        WinConditionStrategy result = deltaStoneFactory.getConditionStrategy();
        assertNotNull(result);

        assertTrue(result instanceof AlphaStoneWinConditionStrategy);
    }
    
    @Test
    public void shouldReturnBetaStoneManaManipulator() {
        ManaManipulator result = deltaStoneFactory.getManaManipulatorStrategy();
        assertNotNull(result);

        assertTrue(result instanceof DeltaStoneManaManipulator);
    }

    @Test
    public void shouldReturnCorrectHeroPower() {
        HeroPower result1 = deltaStoneFactory.getHeroPower(FINDUS);
        HeroPower result2 = deltaStoneFactory.getHeroPower(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof Baby);
        assertTrue(result2 instanceof Baby);
    }

    @Test
    public void shouldReturnCorrectDeck() {
        Deck result1 = deltaStoneFactory.getDeck(FINDUS);
        Deck result2 = deltaStoneFactory.getDeck(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof DishDeck);
        assertTrue(result2 instanceof DishDeck);
    }

    @Test
    public void shouldReturnNullCardEffectHandler(){
        CardEffectHandler result = deltaStoneFactory.getCardEffectHandler();
        assertNotNull(result);

        assertTrue(result instanceof NullCardEffectHandler);
    }
}
