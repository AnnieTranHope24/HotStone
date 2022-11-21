package hotstone.standard.winconditions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Hero;
import hotstone.standard.cards.Field;
import hotstone.standard.cards.Hand;
import hotstone.standard.cards.deck.decks.DeckImpl;
import hotstone.standard.hero.HeroImpl;
import hotstone.standard.hero.heropower.Baby;
import hotstone.standard.mana.AlphaStoneManaManipulator;

import static hotstone.framework.Player.FINDUS;
import static hotstone.framework.Player.PEDDERSEN;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAlphaStoneWinCondtion {

    private AlphaStoneWinConditionStrategy alphaStoneWinConditionStrategy;
    private Hero hero1;
    private Hero hero2;

    @BeforeEach
    public void setup() {
        alphaStoneWinConditionStrategy = new AlphaStoneWinConditionStrategy();
        hero1 = new HeroImpl(PEDDERSEN, 21, new AlphaStoneManaManipulator(), new Baby(), new Field(), new DeckImpl(new Hand(), PEDDERSEN));
        hero2 = new HeroImpl(PEDDERSEN, 21, new AlphaStoneManaManipulator(), new Baby(), new Field(), new DeckImpl(new Hand(), PEDDERSEN));
    }

    @Test
    public void shouldReturnFindusAsWinner() {
        assertThat(alphaStoneWinConditionStrategy.getWinner(hero1, hero2), is(FINDUS));
    }
    
}
