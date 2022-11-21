package hotstone.standard.winconditions;

import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.cards.Field;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.deck.decks.DeckImpl;
import hotstone.standard.hero.HeroImpl;
import hotstone.standard.hero.heropower.Baby;
import hotstone.standard.mana.BetaStoneManaManipulator;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBetaStoneWinCondition {

    private BetaStoneWinConditionStrategy betaStoneWinConditionStrategy;
    private HeroImpl hero1;
    private HeroImpl hero2;

    @BeforeEach
    public void setup() {
        betaStoneWinConditionStrategy = new BetaStoneWinConditionStrategy();
        hero1 = new HeroImpl(FINDUS, 21, new BetaStoneManaManipulator(), new Baby(), new Field(), new DeckImpl(new Hand(), FINDUS));
        hero2 = new HeroImpl(PEDDERSEN, 21, new BetaStoneManaManipulator(), new Baby(), new Field(), new DeckImpl(new Hand(), PEDDERSEN));
    }

    @Test
    public void shouldReturnNullAsWinner() {
        assertThat(betaStoneWinConditionStrategy.getWinner(hero1, hero2), nullValue());
    }

    @Test
    public void shouldReturnFindusAsWinner() {
        hero2.setHealth(0);
        assertThat(betaStoneWinConditionStrategy.getWinner(hero1, hero2), is(FINDUS));
    }

    @Test
    public void shouldReturnPeddersenAsWinner() {
        hero1.setHealth(0);
        assertThat(betaStoneWinConditionStrategy.getWinner(hero1, hero2), is(PEDDERSEN));
    }
}
