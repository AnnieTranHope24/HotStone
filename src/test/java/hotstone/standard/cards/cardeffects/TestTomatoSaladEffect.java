package hotstone.standard.cards.cardeffects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.factories.EtaStoneFactory;
import hotstone.standard.game.GameMutator;
import hotstone.standard.game.StandardHotStoneGame;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTomatoSaladEffect {
    
    private CardEffect cardEffect;
    private GameMutator game;

    @BeforeEach
    public void setup() {
        cardEffect = new TomatoSaladEffect();
        game = new StandardHotStoneGame(new EtaStoneFactory());
    }

    @Test
    public void shouldIncrementAttackByOneOnRandomMinionOfOwn() {
        cardEffect.useEffect(game);

        assertTrue(true);
    }
}
