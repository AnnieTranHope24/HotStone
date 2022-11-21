package hotstone.standard.cards.cardeffects;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.factories.EtaStoneFactory;
import hotstone.standard.game.GameMutator;
import hotstone.standard.game.StandardHotStoneGame;
import hotstone.standard.hero.HeroMutator;

import static org.hamcrest.CoreMatchers.is;

public class TestNoodleSoupEffect {
    
    private CardEffect cardEffect;
    private GameMutator game;

    @BeforeEach
    public void setup() {
        cardEffect = new NoodleSoupEffect();
        game = new StandardHotStoneGame(new EtaStoneFactory());
    }

    @Test
    public void shouldDraw1CardFromDeck() {
        HeroMutator hero = game.getHeroM(game.getPlayerInTurn());
        int initalDeckSize = hero.getDeckSize();
        cardEffect.useEffect(game);
        int deckSizeNow = hero.getDeckSize();
        assertThat(initalDeckSize-deckSizeNow, is(1));
    }
}

