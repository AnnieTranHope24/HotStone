package hotstone.standard.cards.cardeffects;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.factories.EtaStoneFactory;
import hotstone.standard.game.GameMutator;
import hotstone.standard.game.StandardHotStoneGame;

import static org.hamcrest.CoreMatchers.is;

public class TestBrownRiceEffect {

    private static final int DAMAGE = -1;
    
    private CardEffect cardEffect;
    private GameMutator game;

    @BeforeEach
    public void setup() {
        cardEffect = new BrownRiceEffect();
        game = new StandardHotStoneGame(new EtaStoneFactory());
    }

    @Test
    public void shouldDo1DamageToOpponent() {
        int healthBefore = game.getTarget().getHealth();

        cardEffect.useEffect(game);

        assertThat(game.getTarget().getHealth(), is(healthBefore + DAMAGE));
    }
}
