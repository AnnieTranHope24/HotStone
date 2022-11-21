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
import hotstone.standard.mana.BetaStoneManaManipulator;
import hotstone.standard.mana.ManaManipulator;
import hotstone.standard.winconditions.BetaStoneWinConditionStrategy;
import hotstone.standard.winconditions.WinConditionStrategy;

public class TestBetaStoneFactory {

    private BetaStoneFactory betaStoneFactory;

    @BeforeEach
    public void setup() {
        betaStoneFactory = new BetaStoneFactory();
    }

    @Test
    public void shouldReturnBetaStoneWinCondition() {
        WinConditionStrategy result = betaStoneFactory.getConditionStrategy();
        assertNotNull(result);

        assertTrue(result instanceof BetaStoneWinConditionStrategy);
    }

    @Test
    public void shouldReturnBetaStoneManaManipulator() {
        ManaManipulator result = betaStoneFactory.getManaManipulatorStrategy();
        assertNotNull(result);

        assertTrue(result instanceof BetaStoneManaManipulator);
    }

    @Test
    public void shouldReturnCorrectHeroPower() {
        HeroPower result1 = betaStoneFactory.getHeroPower(FINDUS);
        HeroPower result2 = betaStoneFactory.getHeroPower(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof Baby);
        assertTrue(result2 instanceof Baby);
    }

    @Test
    public void shouldReturnCorrectDeck() {
        Deck result1 = betaStoneFactory.getDeck(FINDUS);
        Deck result2 = betaStoneFactory.getDeck(PEDDERSEN);

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1 instanceof DeckImpl);
        assertTrue(result2 instanceof DeckImpl);
    }

    @Test
    public void shouldReturnNullCardEffectHandler(){
        CardEffectHandler result = betaStoneFactory.getCardEffectHandler();
        assertNotNull(result);

        assertTrue(result instanceof NullCardEffectHandler);
    }
}
