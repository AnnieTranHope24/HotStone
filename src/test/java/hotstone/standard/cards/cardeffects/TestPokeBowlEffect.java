package hotstone.standard.cards.cardeffects;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.factories.EtaStoneFactory;
import hotstone.standard.game.GameMutator;
import hotstone.standard.game.StandardHotStoneGame;

import static org.hamcrest.CoreMatchers.is;

public class TestPokeBowlEffect {

    private static final int HEALTH_INCREMENT = 2;
    
    private CardEffect cardEffect;
    private GameMutator game;

    @BeforeEach
    public void setup() {
        cardEffect = new PokeBowlEffect();
        game = new StandardHotStoneGame(new EtaStoneFactory());
    }

    @Test
    public void shouldAddTwoHealthToActivePlayer() {
        int healthBefore = game.getHero(game.getPlayerInTurn()).getHealth();

        cardEffect.useEffect(game);

        assertThat(game.getHero(game.getPlayerInTurn()).getHealth(), is(healthBefore + HEALTH_INCREMENT));
    }
}
