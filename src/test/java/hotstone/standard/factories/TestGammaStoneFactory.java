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
import hotstone.standard.hero.heropower.DanishChef;
import hotstone.standard.hero.heropower.HeroPower;
import hotstone.standard.hero.heropower.ThaiChef;
import hotstone.standard.mana.AlphaStoneManaManipulator;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.AlphaStoneWinConditionStrategy;
import hotstone.standard.winconditions.WinConditionStrategy;

public class TestGammaStoneFactory {
    
    private GammaStoneFactory gammaStoneFactory;

    @BeforeEach
    public void setup() {
        gammaStoneFactory = new GammaStoneFactory();
    }

    @Test
    public void shouldReturnAlphaStoneWinCondition() {
        WinConditionStrategy result = gammaStoneFactory.getConditionStrategy();
        assertNotNull(result);

        assertTrue(result instanceof AlphaStoneWinConditionStrategy);
    }
    
    @Test
    public void shouldReturnBetaStoneManaManipulator() {
        ManaManipulator result = gammaStoneFactory.getManaManipulatorStrategy();
        assertNotNull(result);

        assertTrue(result instanceof AlphaStoneManaManipulator);
    }

    @Test
    public void shouldReturnCorrectHeroPower() {
        HeroPower result1 = gammaStoneFactory.getHeroPower(FINDUS);
        HeroPower result2 = gammaStoneFactory.getHeroPower(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof ThaiChef);
        assertTrue(result2 instanceof DanishChef);
    }

    @Test
    public void shouldReturnCorrectDeck() {
        Deck result1 = gammaStoneFactory.getDeck(FINDUS);
        Deck result2 = gammaStoneFactory.getDeck(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof DeckImpl);
        assertTrue(result2 instanceof DeckImpl);
    }

    @Test
    public void shouldReturnNullCardEffectHandler(){
        CardEffectHandler result = gammaStoneFactory.getCardEffectHandler();
        assertNotNull(result);

        assertTrue(result instanceof NullCardEffectHandler);
    }
}