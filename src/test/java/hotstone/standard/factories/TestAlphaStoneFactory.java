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
import hotstone.standard.hero.heropower.Baby;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.mana.AlphaStoneManaManipulator;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.AlphaStoneWinConditionStrategy;
import hotstone.standard.winconditions.WinConditionStrategy;

public class TestAlphaStoneFactory {

    private AlphaStoneFactory alphaStoneFactory;

    @BeforeEach
    public void setup() {
        alphaStoneFactory = new AlphaStoneFactory();
    }

    @Test
    public void shouldReturnAlphaStoneWinCondition() {
        WinConditionStrategy result = alphaStoneFactory.getConditionStrategy();
        assertNotNull(result);

        assertTrue(result instanceof AlphaStoneWinConditionStrategy);
    }
    
    @Test
    public void shouldReturnBetaStoneManaManipulator() {
        ManaManipulator result = alphaStoneFactory.getManaManipulatorStrategy();
        assertNotNull(result);

        assertTrue(result instanceof AlphaStoneManaManipulator);
    }

    @Test
    public void shouldReturnCorrectHeroPower() {
        HeroPower result1 = alphaStoneFactory.getHeroPower(FINDUS);
        HeroPower result2 = alphaStoneFactory.getHeroPower(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof Baby);
        assertTrue(result2 instanceof Baby);
    }

    @Test
    public void shouldReturnCorrectDeck() {
        Deck result1 = alphaStoneFactory.getDeck(FINDUS);
        Deck result2 = alphaStoneFactory.getDeck(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof DeckImpl);
        assertTrue(result2 instanceof DeckImpl);
    }

    @Test
    public void shouldReturnNullCardEffectHandler(){
        CardEffectHandler result = alphaStoneFactory.getCardEffectHandler();
        assertNotNull(result);

        assertTrue(result instanceof NullCardEffectHandler);
    }
}
