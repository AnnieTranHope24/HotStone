package hotstone.standard.cards.cardeffects;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.standard.factories.EtaStoneFactory;
import hotstone.standard.game.GameMutator;
import hotstone.standard.game.StandardHotStoneGame;

import static org.hamcrest.CoreMatchers.is;

public class TestChickenCurryEffect {
    
    private CardEffect cardEffect;
    private GameMutator game;

    @BeforeEach
    public void setup() {
        cardEffect = new NullCardEffect();
        game = new StandardHotStoneGame(new EtaStoneFactory());
    }

    @Test
    public void shouldDoSomething() {
        
    }
}
